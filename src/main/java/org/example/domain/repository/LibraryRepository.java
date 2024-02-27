package org.example.domain.repository;

import org.example.domain.model.Book;

import java.util.List;

public interface LibraryRepository {
    void addBook(Book book);

    List<Book> searchBooksByAuthor(String author);

    List<Book> searchBooksByTitle(String title);

    void displayBooks();
}
