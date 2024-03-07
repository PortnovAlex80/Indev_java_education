import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.domain.Student;
import org.domain.Subject;
import org.domain.valueobjects.Age;
import org.domain.valueobjects.StudentName;
import org.ports.StudentRepository;
import org.usecases.AddNewStudentsGroupUseCase;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddNewStudentsGroupUseCaseTest {

    private StudentRepository studentRepository;
    private AddNewStudentsGroupUseCase useCase;

    @BeforeEach
    void setUp() {
        // Инициализация мок объекта StudentRepository
        studentRepository = mock(StudentRepository.class);
        useCase = new AddNewStudentsGroupUseCase(studentRepository);
    }

    @Test
    void addStudentAndSortByRatingDescending() {
        // Подготовка данных
        StudentName name1 = new StudentName("Ivan Ivanov");
        Age age1 = new Age(20);
        List<Subject> subjects1 = Arrays.asList(Subject.createSubjectWithRating("Math", 4.5));
        Student student1 = new Student(name1, age1);
        subjects1.forEach(student1::addSubjectToLearnSchedule);

        StudentName name2 = new StudentName("Maria Petrova");
        Age age2 = new Age(19);
        List<Subject> subjects2 = Arrays.asList(Subject.createSubjectWithRating("Math", 3.5));
        Student student2 = new Student(name2, age2);
        subjects2.forEach(student2::addSubjectToLearnSchedule);

        // Мокируем поведение метода findAll
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student1, student2));

        // Добавление студента через use case
        useCase.addStudent(name1, age1, subjects1);

        // Вызов и проверка результата
        List<Student> sortedStudents = useCase.getStudentsSortedByRatingDescending();
        assertNotNull(sortedStudents);
        assertEquals(2, sortedStudents.size()); // Проверяем, что в списке два студента
        assertEquals(name1.getName(), sortedStudents.get(0).getName().getName()); // Проверяем порядок сортировки

        // Проверка вызова метода save
        verify(studentRepository, times(1)).save(any(Student.class));
    }
}
