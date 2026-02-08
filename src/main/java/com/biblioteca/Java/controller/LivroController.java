package com.biblioteca.Java.controller;

import com.biblioteca.Java.business.LivroService;
import com.biblioteca.Java.infraestructure.entity.Livro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public ResponseEntity<List<Livro>> listar(){
            List<Livro> lista = service.listarTodos();
            return ResponseEntity.ok(lista);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizção(@RequestBody Livro livro, @PathVariable Long id){
            Livro livroAtualizado = service.atualizarLivro(id, livro);
            return ResponseEntity.ok(livroAtualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
            service.deletarLivro(id);
            return ResponseEntity.noContent().build();
    }
}
