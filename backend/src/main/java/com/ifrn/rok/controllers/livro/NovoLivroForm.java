package com.ifrn.rok.controllers.livro;

import com.ifrn.rok.models.Autor;
import com.ifrn.rok.models.Genero;
import com.ifrn.rok.models.Livro;
import com.ifrn.rok.repository.AutorRepository;
import com.ifrn.rok.repository.GeneroRepository;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

public class NovoLivroForm {

    @NotBlank
    @Size(max=100)
    private String titulo;
    @NotBlank
    @Size(max = 50)
    private String subTitulo;
    @Min(15)
    private BigDecimal preco;
    @NotBlank
    private String conteudo;
    @NotBlank
    private String sumario;
    @Min(30)
    private Integer numeroPaginas;
    @NotBlank
    private String isbn;
    @NotNull
    private Long autorId;
    @NotNull
    private Long generoId;

    public String getSumario() {
        return sumario;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Long getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Long generoId) {
        this.generoId = generoId;
    }

    public Livro novoLivro(AutorRepository autorRepository, GeneroRepository generoRepository) {
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Autor não encontrado."));
        Genero genero = generoRepository.findById(generoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gênero não encontrado."));
        return new Livro(titulo, subTitulo, preco, conteudo, sumario, numeroPaginas, isbn, autor, genero);
    }
}
