package org.example.usecases;

import org.example.domain.model.Book;
import org.example.domain.model.BookFactory;
import org.example.domain.model.Bookstore;

import java.util.Random;

public class FillBookstoreUseCase {
    private final BookFactory fictionBookFactory;
    private final BookFactory scientificBookFactory;
    private final Bookstore bookstore;

    private static final String[] fictionAuthors = {"Stephen King", "J.K. Rowling", "George Orwell", "Jane Austen", "Ernest Hemingway"};
    private static final String[][] fictionBooksByAuthor = {
            {"It", "The Shining", "Misery", "Pet Sematary", "Carrie"},
            {"Harry Potter and the Philosopher's Stone", "Harry Potter and the Chamber of Secrets", "Harry Potter and the Prisoner of Azkaban", "Harry Potter and the Goblet of Fire", "Harry Potter and the Order of the Phoenix"},
            {"1984", "Animal Farm", "The Road to Wigan Pier", "Down and Out in Paris and London", "Keep the Aspidistra Flying"},
            {"Pride and Prejudice", "Sense and Sensibility", "Emma", "Mansfield Park", "Northanger Abbey"},
            {"The Old Man and the Sea", "A Farewell to Arms", "For Whom the Bell Tolls", "The Sun Also Rises", "To Have and Have Not"}
    };

    private static final String[] scientificAuthors = {"Albert Einstein", "Marie Curie", "Isaac Newton", "Charles Darwin", "Galileo Galilei"};
    private static final String[][] scientificBooksByAuthor = {
            {"Relativity: The Special and General Theory", "The Meaning of Relativity", "The Evolution of Physics", "Ideas and Opinions", "The World As I See It"},
            {"Radioactive Substances", "The Discovery of Radium", "The Isolation of Pure Radium", "The Study of Radioactivity", "The Nobel Prize in Physics"},
            {"Mathematical Principles of Natural Philosophy", "Opticks", "Arithmetica Universalis", "The System of the World", "The Mathematical Principles of Natural Philosophy"},
            {"On the Origin of Species", "The Descent of Man", "The Expression of the Emotions in Man and Animals", "The Voyage of the Beagle", "The Formation of Vegetable Mould, through the Action of Worms"},
            {"Dialogues Concerning Two New Sciences", "Sidereus Nuncius", "The Starry Messenger", "The Assayer", "Letters on Sunspots"}
    };

    public FillBookstoreUseCase(BookFactory fictionBookFactory, BookFactory scientificBookFactory, Bookstore bookstore) {
        this.fictionBookFactory = fictionBookFactory;
        this.scientificBookFactory = scientificBookFactory;
        this.bookstore = bookstore;
    }

    public void fillBookstore(int numberOfFictionBooks, int numberOfScientificBooks) {
        Random random = new Random();

        for (int i = 0; i < numberOfFictionBooks; i++) {
            String author = fictionAuthors[random.nextInt(fictionAuthors.length)];
            String title = fictionBooksByAuthor[random.nextInt(fictionBooksByAuthor.length)][random.nextInt(fictionBooksByAuthor[0].length)];
            int year = 1900 + random.nextInt(122); // Генерация года издания от 1900 до 2021
            Book book = fictionBookFactory.createBook(title, author, year, "Fiction");
            bookstore.addBook(book);
        }

        for (int i = 0; i < numberOfScientificBooks; i++) {
            String author = scientificAuthors[random.nextInt(scientificAuthors.length)];
            String title = scientificBooksByAuthor[random.nextInt(scientificBooksByAuthor.length)][random.nextInt(scientificBooksByAuthor[0].length)];
            int year = 1900 + random.nextInt(122); // Генерация года издания от 1900 до 2021
            Book book = scientificBookFactory.createBook(title, author, year, "Science");
            bookstore.addBook(book);
        }
    }
}
