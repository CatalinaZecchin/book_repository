package com.bibliophile.book_repository.service;


import com.bibliophile.book_repository.dto.BookRequest;
import com.bibliophile.book_repository.model.Author;
import com.bibliophile.book_repository.model.Book;
import com.bibliophile.book_repository.repository.AuthorRepository;
import com.bibliophile.book_repository.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book addBook(BookRequest bookRequest) {
        Author author = authorRepository.findByName(bookRequest.getAuthorName())
                .orElseGet(() -> {
                    Author newAuthor = new Author();
                    newAuthor.setName(bookRequest.getAuthorName());
                    return authorRepository.save(newAuthor);
                });

        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(author);
        book.setYear(bookRequest.getYear());
        book.setGenre(bookRequest.getGenre());
        book.setRating(bookRequest.getRating());

        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setYear(updatedBook.getYear());
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<Book> getBooksByAuthor(Author author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getBooksByAuthorName(String name) {
        return bookRepository.findByAuthor_Name(name);
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getBooksByMinRating(double rating) {
        return bookRepository.findByRatingGreaterThanEqual(rating);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

