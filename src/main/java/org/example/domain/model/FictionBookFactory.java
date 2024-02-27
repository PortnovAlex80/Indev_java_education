package org.example.domain.model;

public class FictionBookFactory implements BookFactory {
    @Override
    public Book createBook(String title, String author, int year, String genre) {
        return new FictionBook(title, author, year, genre);
    }
}
