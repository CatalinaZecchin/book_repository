package com.bibliophile.book_repository.repository;

import com.bibliophile.book_repository.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
        List<Book> findByAuthor(String author);
}
