package com.ifrn.rok.dto;

import com.ifrn.rok.models.Genero;

public class GenerosDTO {

    private Long id;
    private String nome;

    public GenerosDTO(Genero genero) {
        this.id = genero.getId();
        this.nome = genero.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
