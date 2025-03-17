package com.biblioteca.gerenciador.service;

import com.biblioteca.gerenciador.model.Livro;
import com.biblioteca.gerenciador.model.Categoria;
import com.biblioteca.gerenciador.repository.LivroRepository;
import com.biblioteca.gerenciador.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaService {
    private final LivroRepository livroRepository;
    private final CategoriaRepository categoriaRepository;

    public BibliotecaService(LivroRepository livroRepository, CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.categoriaRepository = categoriaRepository;
    }

    // Cadastrar um novo livro
    public Livro cadastrarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    // Cadastrar uma nova categoria
    public Categoria cadastrarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Buscar livros por título (contendo uma palavra-chave)
    public List<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.findByTituloContaining(titulo);
    }

    // Buscar livros por autor
    public List<Livro> buscarPorAutor(String autor) {
        return livroRepository.findByAutor(autor);
    }

    // Buscar livros por categoria
    public List<Livro> buscarPorCategoria(Long categoriaId) {
        Optional<Categoria> categoria = categoriaRepository.findById(categoriaId);
        return categoria.map(livroRepository::findByCategoria).orElse(List.of());
    }

    // Buscar livros disponíveis (quantidade disponível > 0)
    public List<Livro> buscarDisponiveis() {
        return livroRepository.findByEmprestadoFalse();
    }
}
