import org.domain.Student;
import org.domain.Subject;
import org.domain.valueobjects.Age;
import org.domain.valueobjects.StudentName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @Test
    void testAddSubjectAndCalculateRating() {
        // Подготовка
        StudentName name = new StudentName("Test Student");
        Age age = new Age(20);
        Student student = new Student(name, age);

        // Имитируем предметы с оценками
        Subject math = Subject.createSubjectWithRating("Mathematics", 4.0);
        Subject literature = Subject.createSubjectWithRating("Literature", 5.0);

        // Действие
        student.addSubjectToLearnSchedule(math);
        student.addSubjectToLearnSchedule(literature);

        // Проверка
        assertEquals(2, student.getSubjectList().size(), "Количество предметов должно быть 2");
        assertEquals(4.5, student.getRating().getRatingValue(), "Средний балл должен быть 4.5");
    }

    @Test
    void testRatingCalculationWithNoSubjects() {
        // Подготовка
        StudentName name = new StudentName("Test Student");
        Age age = new Age(20);
        Student student = new Student(name, age);

        // Действие и Проверка

        assertEquals(0.0, student.getRating().getRatingValue(), "Средний балл должен быть 0.0 при отсутствии предметов");
    }
}