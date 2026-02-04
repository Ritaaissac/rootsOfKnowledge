package com.ifrn.rok.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.net.URL;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String nome;
    private @NotBlank URL portfolioAutor;
    @PastOrPresent
    private LocalDateTime createdAt = LocalDateTime.now();

    @Deprecated
    public Autor() {

    }

    // Construtor
    public Autor(@NotBlank String nome, @NotBlank URL portfolioAutor) {
        this.nome = nome;
        this.portfolioAutor = portfolioAutor;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public URL getPortfolioAutor() {
        return portfolioAutor;
    }

    public Long getId() {
        return id;
    }
}
