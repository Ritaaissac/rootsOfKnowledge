package com.ifrn.rok.controllers.livro;

import com.ifrn.rok.dto.LivroDTO;
import com.ifrn.rok.models.Livro;
import com.ifrn.rok.repository.LivroRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping(value = "/livro/{id}")
    @Operation(summary = "Visualização de um livro específico.")
    public LivroDTO livroDetalhe(@PathVariable("id") Long id) {
        Livro livro = livroRepository.findById(id).get();
        return new LivroDTO(livro);
    }

    @DeleteMapping(value = "/livro/{id}")
    @Transactional
    @Operation(summary = "Exclusão de um livro específico.")
    public ResponseEntity<Void> deletarLivro(@PathVariable("id") Long id) {
        if (!livroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        livroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
