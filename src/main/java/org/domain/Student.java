package org.domain;

import org.domain.valueobjects.Age;
import org.domain.valueobjects.Rating;
import org.domain.valueobjects.StudentName;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private StudentName name;
    private Age age;
    private List<Subject> subjectList = new ArrayList<>();
    private Rating rating;

    // Конструктор
    public Student(StudentName name, Age age) {
        this.name = name;
        this.age = age;
        ratingCalculation();
        // Инициализация списка предметов происходит выше
    }

    // Публичный метод для добавления предмета
    public void addSubjectToLearnSchedule(Subject subject) {
        if (subject != null) {
            this.subjectList.add(subject);
            ratingCalculation(); // Пересчитываем рейтинг после добавления нового предмета
        }
    }

    // Расчет среднего балла студента
    private void ratingCalculation() {
        if (subjectList.isEmpty()) {
            this.rating = new Rating(0.0); // Если предметов нет, считаем рейтинг равным 0
        } else {
            double sum = subjectList.stream()
                    .mapToDouble(Subject::getRatingValue) // Предполагается, что в классе Subject есть метод getRatingValue, возвращающий double
                    .sum();
            double average = sum / subjectList.size();
            this.rating = new Rating(average);
        }
    }

    // Геттеры
    public Rating getRating() {
        return rating;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public StudentName getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }
}
