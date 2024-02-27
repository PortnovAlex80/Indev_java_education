import org.example.domain.model.Book;
import org.example.domain.model.FictionBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        Book book = new FictionBook("Title", "Author", 2022, "Genre");

        // Act
        book.setTitle("New Title");
        book.setAuthor("New Author");
        book.setYear(2023);

        // Assert
        assertEquals("New Title", book.getTitle());
        assertEquals("New Author", book.getAuthor());
        assertEquals(2023, book.getYear());
    }

}
