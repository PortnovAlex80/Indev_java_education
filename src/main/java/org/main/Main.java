package org.main;


import org.domain.Student;
import org.domain.Subject;
import org.domain.repository.InMemoryStudentRepository;
import org.domain.valueobjects.Age;
import org.domain.valueobjects.StudentName;
import org.ports.StudentRepository;
import org.usecases.AddNewStudentsGroupUseCase;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Инициализация репозитория
        StudentRepository studentRepository = new InMemoryStudentRepository();

        // Инициализация use case
        AddNewStudentsGroupUseCase addNewStudentsGroupUseCase = new AddNewStudentsGroupUseCase(studentRepository);

// Создание и добавление первого студента
        StudentName name1 = new StudentName("Ivan Ivanov");
        Age age1 = new Age(20);
        List<Subject> subjects1 = Arrays.asList(
                Subject.createSubjectWithRating("Mathematics", 4.0),
                Subject.createSubjectWithRating("Physics", 4.5),
                Subject.createSubjectWithRating("Chemistry", 3.8),
                Subject.createSubjectWithRating("Biology", 4.2),
                Subject.createSubjectWithRating("English", 4.1)
        );

// Создание и добавление второго студента
        StudentName name2 = new StudentName("Maria Petrova");
        Age age2 = new Age(19);
        List<Subject> subjects2 = Arrays.asList(
                Subject.createSubjectWithRating("Literature", 4.7),
                Subject.createSubjectWithRating("History", 4.8),
                Subject.createSubjectWithRating("Artico", 5.0),
                Subject.createSubjectWithRating("Geography", 4.4),
                Subject.createSubjectWithRating("Russian", 4.9)
        );

        addNewStudentsGroupUseCase.addStudent(name1, age1, subjects1);
        addNewStudentsGroupUseCase.addStudent(name2, age2, subjects2);

        // Вывод списка студентов, отсортированного по убыванию среднего балла
        List<Student> sortedStudents = addNewStudentsGroupUseCase.getStudentsSortedByRatingDescending();
        System.out.println("Students sorted by rating:");
        for (Student student : sortedStudents) {
            System.out.println(student.getName().getName() + ", Rating: " + student.getRating().getRatingValue());
        }
    }
}