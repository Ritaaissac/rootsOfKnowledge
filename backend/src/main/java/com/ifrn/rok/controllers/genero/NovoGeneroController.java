package com.ifrn.rok.controllers.genero;

import com.ifrn.rok.models.Genero;
import com.ifrn.rok.repository.GeneroRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class NovoGeneroController {

    @Autowired
    GeneroRepository generoRepository;

    @PostMapping("/novogenero")
    @Transactional
    @Operation(summary = "Novo gênero")
    public void novoGenero(@ModelAttribute @Valid NovoGeneroForm form) {

        boolean generoJaExiste = generoRepository.findByNome(form.getNome()).isPresent();

        if (generoJaExiste) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gênero já existe");
        }

        Genero genero = form.novoGenero();
        generoRepository.save(genero);
    }
}
