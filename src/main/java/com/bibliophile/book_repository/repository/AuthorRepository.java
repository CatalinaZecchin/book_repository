package com.bibliophile.book_repository.repository;

import com.bibliophile.book_repository.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
    Optional<Author> findByNameIgnoreCase(String name);
}
