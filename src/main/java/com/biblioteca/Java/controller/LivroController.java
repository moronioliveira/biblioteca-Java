package com.biblioteca.Java.controller;

import com.biblioteca.Java.business.LivroService;
import com.biblioteca.Java.infraestructure.entity.Livro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/livros")
public class LivroController {
        private final LivroService service;

        @PostMapping
        public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro){
        Livro livroSalvo = service.salvarNovoLivro(livro);
        return ResponseEntity.ok(livroSalvo);
    }
}
