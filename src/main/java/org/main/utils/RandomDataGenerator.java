package org.main.utils;

import org.domain.Subject;
import org.domain.valueobjects.Age;
import org.domain.valueobjects.StudentName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDataGenerator {

    private static final Random random = new Random();
    private static final String[] names = {"Ivan", "Maria", "Petr", "Anna", "Dmitry", "Elena"};
    private static final String[] surnames = {"Ivanov", "Petrova", "Sidorov", "Smirnova", "Kuznetsov", "Popova"};
    private static final String[] subjects = {"Mathematics", "Physics", "Chemistry", "Biology", "English", "Literature", "History", "Geography", "Russian"};

    public static StudentName generateName() {
        String name = names[random.nextInt(names.length)];
        String surname = surnames[random.nextInt(surnames.length)];
        return new StudentName(name + " " + surname);
    }

    public static Age generateAge(int min, int max) {
        return new Age(random.nextInt(max - min + 1) + min);
    }

    public static List<Subject> generateSubjects(int numberOfSubjects) {
        List<Subject> subjectList = new ArrayList<>();
        for (int i = 0; i < numberOfSubjects; i++) {
            String subject = subjects[random.nextInt(subjects.length)];
            double rating = 2 + random.nextDouble() * 3; // Генерируем оценки от 2.0 до 5.0
            subjectList.add(Subject.createSubjectWithRating(subject, Math.round(rating * 10.0) / 10.0)); // Округляем до одного десятичного знака
        }
        return subjectList;
    }
}
