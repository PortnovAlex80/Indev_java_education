package org.usecases;

import org.domain.Student;
import org.domain.Subject;
import org.domain.valueobjects.Age;
import org.domain.valueobjects.StudentName;
import org.ports.StudentRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AddNewStudentsGroupUseCase {
    private StudentRepository studentRepository;

    public AddNewStudentsGroupUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(StudentName name, Age age, List<Subject> subjects) {
        Student newStudent = new Student(name, age);
        subjects.forEach(newStudent::addSubjectToLearnSchedule);
        // Предполагаем, что рейтинг пересчитывается внутри метода addSubjectToLearnSchedule
        studentRepository.save(newStudent); // Сохраняем студента в репозиторий
    }

    public List<Student> getStudentsSortedByRatingDescending() {
        List<Student> students = studentRepository.findAll();
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // Сравниваем double значения рейтингов напрямую
                return Double.compare(s2.getRating().getRatingValue(), s1.getRating().getRatingValue());
            }
        });
        return students;
    }

}
