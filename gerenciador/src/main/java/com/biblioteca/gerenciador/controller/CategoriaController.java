package com.biblioteca.gerenciador.controller;

import com.biblioteca.gerenciador.model.Categoria;
import com.biblioteca.gerenciador.service.BibliotecaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final BibliotecaService bibliotecaService;

    public CategoriaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }
    
    @PostMapping
    public Categoria cadastrarCategoria(@RequestBody Categoria categoria) {
        return bibliotecaService.cadastrarCategoria(categoria);
    }
}
