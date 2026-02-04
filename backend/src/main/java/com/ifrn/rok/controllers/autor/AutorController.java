package com.ifrn.rok.controllers.autor;


import com.ifrn.rok.dto.AutorDTO;
import com.ifrn.rok.repository.AutorRepository;
import com.ifrn.rok.repository.LivroRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    LivroRepository livroRepository;

    @GetMapping(value = "/autores")
    @Operation(summary = "Visualização de autores")
    public Collection<AutorDTO> list() {
        return autorRepository.findAll().stream()
                .map(AutorDTO:: new)
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/autor/{id}")
    @Transactional
    @Operation(summary = "Exclusão de um autor específico.")
    public ResponseEntity<?> deletarAutor(@PathVariable("id") Long id) {
        if (!autorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        // Verifica se há livros associados ao autor
        long countLivros = livroRepository.findAll().stream()
                .filter(livro -> livro.getAutor().getId().equals(id))
                .count();
        
        if (countLivros > 0) {
            return ResponseEntity.badRequest()
                    .body("Não é possível excluir este autor pois existem " + countLivros + " livro(s) associado(s) a ele.");
        }
        
        autorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
