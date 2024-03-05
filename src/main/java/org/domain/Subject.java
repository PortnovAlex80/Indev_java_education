package org.domain;

import org.domain.common.Entity;

public class Subject extends Entity {
    private String subject;
    private Double rating;

    // Приватный конструктор
    private Subject(String subject, Double rating) {
        if (subject == null || subject.length() <= 4 || subject.length() >= 50 || containsNumbersOrSymbols(subject)) {
            throw new IllegalArgumentException("Subject name must be between 5 and 49 characters and contain no numbers or special symbols.");
        }
        if (rating < 0.0 || rating > 5.0) {
            throw new IllegalArgumentException("Rating must be between 0.0 and 5.0.");
        }
        this.subject = subject;
        this.rating = rating;
    }

    // Фабричный метод для создания предмета без начальной оценки
    public static Subject createSubjectWithoutRating(String subject) {
        return new Subject(subject, 0.00);
    }

    // Фабричный метод для создания предмета с начальной оценкой
    public static Subject createSubjectWithRating(String subject, Double rating) {
        return new Subject(subject, rating);
    }

    private boolean containsNumbersOrSymbols(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    // Геттеры и сеттеры
    public Double getRatingValue() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getSubject() {
        return subject;
    }
}
