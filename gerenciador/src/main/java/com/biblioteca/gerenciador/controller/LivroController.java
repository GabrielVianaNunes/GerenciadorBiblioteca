package com.biblioteca.gerenciador.controller;

import com.biblioteca.gerenciador.model.Livro;
import com.biblioteca.gerenciador.service.BibliotecaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final BibliotecaService bibliotecaService;

    public LivroController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }
    
    @PostMapping
    public Livro cadastrarLivro(@RequestBody Livro livro) {
        return bibliotecaService.cadastrarLivro(livro);
    }
    
    @GetMapping("/titulo")
    public List<Livro> buscarPorTitulo(@RequestParam String titulo) {
        return bibliotecaService.buscarPorTitulo(titulo);
    }
}
