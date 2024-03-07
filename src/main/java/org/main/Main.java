package org.main;

import org.adapters.InFileStudentRepository;
import org.domain.Student;
import org.domain.Subject;
import org.domain.valueobjects.Age;
import org.domain.valueobjects.StudentName;
import org.main.utils.RandomDataGenerator;
import org.ports.StudentRepository;
import org.usecases.AddNewStudentsGroupUseCase;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new InFileStudentRepository("students.dat");
        AddNewStudentsGroupUseCase addNewStudentsGroupUseCase = new AddNewStudentsGroupUseCase(studentRepository);

        // Генерируем и добавляем студентов
        for (int i = 0; i < 10; i++) { // Cоздаем 10 студентов
            StudentName name = RandomDataGenerator.generateName();
            Age age = RandomDataGenerator.generateAge(18, 24);
            List<Subject> subjects = RandomDataGenerator.generateSubjects(5); // Каждому студенту назначаем 5 предметов
            addNewStudentsGroupUseCase.addStudent(name, age, subjects);
        }

        // Вывод списка студентов, отсортированного по убыванию среднего балла
        List<Student> sortedStudents = addNewStudentsGroupUseCase.getStudentsSortedByRatingDescending();
        System.out.println("Students sorted by rating:");
        for (Student student : sortedStudents) {
            System.out.println(student.getName().getName() + ", Rating: " + student.getRating().getRatingValue());
        }
    }
}
