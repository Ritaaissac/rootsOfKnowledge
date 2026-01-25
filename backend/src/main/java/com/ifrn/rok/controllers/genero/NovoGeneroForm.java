package com.ifrn.rok.controllers.genero;

import com.ifrn.rok.models.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NovoGeneroForm {
    @NotBlank
    @Size(max = 50)
    String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero novoGenero() {
        return new Genero(nome);
    }
}
