package org.adapters;

import org.adapters.dto.StudentDTO;
import org.domain.Student;
import org.ports.StudentRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InFileStudentRepository implements StudentRepository {
    private static final String DB_DIRECTORY = "file_db";
    private final String filePath;

    public InFileStudentRepository(String fileName) {
        this.filePath = Paths.get(DB_DIRECTORY, fileName).toString();
        ensureDirectoryExists(DB_DIRECTORY);
    }

    @Override
    public void save(Student student) {
        // Загружаем текущий список студентов, конвертируем в DTO, добавляем нового студента, сохраняем обратно
        List<Student> students = findAll();
        students.add(student);
        List<StudentDTO> studentDTOs = students.stream()
                .map(StudentDTO::new) // Предполагается, что у вас есть конструктор StudentDTO(Student student)
                .collect(Collectors.toList());
        saveStudentsToFile(studentDTOs); // Сохраняем список DTO
    }

    @Override
    public List<Student> findAll() {
        List<StudentDTO> studentDTOs = loadStudentsFromFile();
        return studentDTOs.stream()
                .map(StudentDTO::toDomainObject) // Предполагается метод конвертации обратно в доменный объект
                .collect(Collectors.toList());
    }

    private void saveStudentsToFile(List<StudentDTO> studentDTOs) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(studentDTOs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private List<StudentDTO> loadStudentsFromFile() {
        File file = new File(filePath);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<StudentDTO>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void ensureDirectoryExists(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            try {
                Files.createDirectories(Paths.get(directoryPath));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Не удалось создать директорию для базы данных: " + directoryPath);
            }
        }
    }
}
