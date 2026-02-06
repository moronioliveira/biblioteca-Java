package com.biblioteca.Java.business;

import com.biblioteca.Java.infraestructure.entity.Livro;
import com.biblioteca.Java.infraestructure.repository.LivroRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class LivroService {
    private final LivroRepository repository;
    public Livro salvarNovoLivro(Livro livro) {

        Optional<Livro> livroExistente = repository.findByIsbn(livro.getIsbn());
        if (livroExistente.isPresent()){
            throw new RuntimeException("O livro não pode ter um ISBN já cadastrado");
        }
        return repository.save(livro);

    }


}
