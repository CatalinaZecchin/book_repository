package com.bibliophile.book_repository.repository;

import com.bibliophile.book_repository.model.Author;
import com.bibliophile.book_repository.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
        List<Book> findByAuthor(Author author);
        List<Book> findByAuthor_Name(String name);
        List<Book> findByTitleContainingIgnoreCase(String title);
        List<Book> findByGenre(String genre);
        List<Book> findByRatingGreaterThanEqual(int rating);
}
