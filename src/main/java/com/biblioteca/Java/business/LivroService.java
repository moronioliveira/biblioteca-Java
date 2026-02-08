package com.biblioteca.Java.business;

import com.biblioteca.Java.infraestructure.entity.Livro;
import com.biblioteca.Java.infraestructure.repository.LivroRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
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
    public List<Livro> listarTodos(){
        return repository.findAll();
    }
    public Livro atualizarLivro(Long id, Livro livro){
        Optional<Livro> idExistente = repository.findById(id);
        if (idExistente.isEmpty()){
            throw new RuntimeException("Livro não encontrado para atualizar");
        }
        livro.setId(id);
        return repository.save(livro);
    }
    public void deletarLivro(Long id){
        Optional<Livro> livroDeletado = repository.findById(id);
        if (livroDeletado.isEmpty()){
            throw new RuntimeException("Esse livro bão existe");
        }
        repository.deleteById(id);
    }

}
