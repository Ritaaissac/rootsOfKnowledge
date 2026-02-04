package com.ifrn.rok.controllers.livro;

import com.ifrn.rok.models.Livro;
import com.ifrn.rok.repository.AutorRepository;
import com.ifrn.rok.repository.GeneroRepository;
import com.ifrn.rok.repository.LivroRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class NovoLivroController {

    @Autowired
    AutorRepository autorRepository;
    @Autowired
    GeneroRepository generoRepository;
    @Autowired
    LivroRepository livroRepository;

    @PostMapping("/novolivro")
    @Transactional
    @Operation(summary = "Novo livro")
    public void novoLivro(@RequestBody @Valid NovoLivroForm form) {
        boolean livroComMesmoIsbn = livroRepository.findByIsbn(form.getIsbn()).isPresent();
        if (livroComMesmoIsbn) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Livro com mesmo ISBN já existe.");
        }
        Livro livro = form.novoLivro(autorRepository, generoRepository);
        livroRepository.save(livro);

    }
}
