package org.example.domain.model;

public class ScientificBookFactory implements BookFactory {
    @Override
    public Book createBook(String title, String author, int year, String fieldOfStudy) {
        return new ScientificBook(title, author, year, fieldOfStudy);
    }
}
