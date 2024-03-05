package org.adapters;

import org.domain.Student;
import org.ports.StudentRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryStudentRepository implements StudentRepository {
    private final List<Student> students = new ArrayList<>();

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students); // Возвращаем копию списка, чтобы предотвратить его изменение
    }

    // Дополнительный метод для получения списка студентов, упорядоченного по убыванию среднего балла
    public List<Student> findAllSortedByRatingDescending() {
        return students.stream()
                .sorted(Comparator.comparingDouble(s -> -s.getRating().getRatingValue())) // Используем минус, чтобы сортировать по убыванию
                .collect(Collectors.toList());
    }
}
