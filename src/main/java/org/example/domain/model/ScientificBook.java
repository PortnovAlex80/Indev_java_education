package org.example.domain.model;

public class ScientificBook extends Book {
    private String fieldOfStudy;

    public ScientificBook(String title, String author, int year, String fieldOfStudy) {
        super(title, author, year);
        this.fieldOfStudy = fieldOfStudy;
    }

    // Getter and setter for fieldOfStudy
    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    @Override
    public short displayInfo() {
        System.out.println("Scientific Book: " + getTitle() + " by " + getAuthor() + ", Field of Study: " + fieldOfStudy + ", Year: " + getYear());
        return 0;
    }
}
