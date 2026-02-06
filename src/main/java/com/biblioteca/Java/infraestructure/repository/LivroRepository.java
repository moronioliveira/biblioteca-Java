package com.biblioteca.Java.infraestructure.repository;

import com.biblioteca.Java.infraestructure.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface LivroRepository extends JpaRepository<Livro, Long>  {
    Optional<Livro> findByIsbn(String isbn);
}
