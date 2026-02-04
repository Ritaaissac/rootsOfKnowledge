package com.ifrn.rok.dto;

import com.ifrn.rok.models.Autor;

import java.net.URL;

public class AutorDTO {

    private Long id;
    private String nome;
    private URL portfolioAutor;

    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.portfolioAutor = autor.getPortfolioAutor();
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

    public URL getPortfolioAutor() {
        return portfolioAutor;
    }

    public void setPortfolioAutor(URL portfolioAutor) {
        this.portfolioAutor = portfolioAutor;
    }
}
