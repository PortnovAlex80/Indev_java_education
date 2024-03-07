package org.adapters.dto;

import org.domain.Student;
import org.domain.Subject;
import org.domain.valueobjects.Age;
import org.domain.valueobjects.StudentName;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private List<SubjectDTO> subjectList;
    private double rating;

    public StudentDTO(Student student) {
        this.name = student.getName().getName();
        this.age = student.getAge().getAge();
        this.subjectList = student.getSubjectList().stream()
                .map(SubjectDTO::new)
                .collect(Collectors.toList());
        this.rating = student.getRating().getRatingValue();
    }

    public Student toDomainObject() {
        List<Subject> subjects = this.subjectList.stream()
                .map(SubjectDTO::toDomainObject)
                .collect(Collectors.toList());
        Student student = new Student(new StudentName(this.name), new Age(this.age));
        subjects.forEach(student::addSubjectToLearnSchedule);
        return student;
    }

}

