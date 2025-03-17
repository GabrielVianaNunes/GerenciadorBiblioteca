package com.biblioteca.gerenciador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String autor;

    private int anoPublicacao;

    @NotBlank
    private String isbn;

    @NotBlank
    private String editora;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private boolean emprestado;

    public Livro() {}

    public Livro(String titulo, String autor, int anoPublicacao, String isbn, String editora, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.isbn = isbn;
        this.editora = editora;
        this.categoria = categoria;
        this.emprestado = false;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnoPublicacao() { return anoPublicacao; }
    public String getIsbn() { return isbn; }
    public String getEditora() { return editora; }
    public Categoria getCategoria() { return categoria; }
    public boolean isEmprestado() { return emprestado; }
    public void setEmprestado(boolean emprestado) { this.emprestado = emprestado; }
}