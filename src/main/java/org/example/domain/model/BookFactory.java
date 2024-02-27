package org.example.domain.model;

public interface BookFactory {
    Book createBook(String title, String author, int year, String genre);
}
