package com.biblioteca.gerenciador.repository;

import com.biblioteca.gerenciador.model.Livro;
import com.biblioteca.gerenciador.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTituloContaining(String titulo);
    List<Livro> findByAutor(String autor);
    List<Livro> findByCategoria(Categoria categoria);
    List<Livro> findByEmprestadoFalse();
}
