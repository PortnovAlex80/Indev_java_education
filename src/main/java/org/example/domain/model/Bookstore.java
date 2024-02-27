package org.example.domain.model;

import org.example.common.AggregateRoot;

import java.util.ArrayList;
import java.util.List;

public class Bookstore implements AggregateRoot {
    private final List<Book> books;

    public Bookstore() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void displayBooks() {
        System.out.println("Books in the bookstore:");
        for (Book book : books) {
            book.displayInfo();
        }
    }
}