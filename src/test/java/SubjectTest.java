import org.domain.Subject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubjectTest {

    @Test
    void createSubjectWithoutRating() {
        Subject subject = Subject.createSubjectWithoutRating("Mathematics");
        assertNotNull(subject, "Subject должен быть создан");
        assertEquals("Mathematics", subject.getSubject(), "Название предмета должно быть Math");
        assertEquals(0.00, subject.getRatingValue(), "Рейтинг должен быть 0.00");
    }

    @Test
    void createSubjectWithRating() {
        Subject subject = Subject.createSubjectWithRating("Physics", 4.5);
        assertNotNull(subject, "Subject должен быть создан");
        assertEquals("Physics", subject.getSubject(), "Название предмета должно быть Physics");
        assertEquals(4.5, subject.getRatingValue(), "Рейтинг должен быть 4.5");
    }

    @Test
    void subjectNameValidation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Subject.createSubjectWithoutRating("A@");
        });
        assertTrue(exception.getMessage().contains("Subject name must be between 5 and 49 characters and contain no numbers or special symbols"), "Должно быть выброшено исключение о невалидном названии предмета");
    }

    @Test
    void subjectRatingValidation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Subject.createSubjectWithRating("Biology", -1.0);
        });
        assertTrue(exception.getMessage().contains("Rating must be between 0.0 and 5.0"), "Должно быть выброшено исключение о невалидном значении рейтинга");
    }
}
