package org.example.domain.model;
public class FictionBook extends Book {
    private String genre;

    public FictionBook(String title, String author, int year , String genre) {
        super(title, author, year);
        this.genre = genre;
    }

    // Getter and setter for genre
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public short displayInfo() {
        System.out.println("Fiction Book: " + getTitle() + " by " + getAuthor() + ", Genre: " + genre + ", Year: " + getYear());
        return 0;
    }
}
