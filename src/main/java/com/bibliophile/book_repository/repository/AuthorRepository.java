package com.bibliophile.book_repository.repository;

import com.bibliophile.book_repository.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
