package org.example.usecases;

import org.example.domain.model.Bookstore;

import java.util.Scanner;

public class FillAndDisplayBookstoreUseCase {
    private final FillBookstoreUseCase fillBookstoreUseCase;
    private final Bookstore bookstore;

    public FillAndDisplayBookstoreUseCase(FillBookstoreUseCase fillBookstoreUseCase, Bookstore bookstore) {
        this.fillBookstoreUseCase = fillBookstoreUseCase;
        this.bookstore = bookstore;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество художественных книг: ");
        int numberOfFictionBooks = scanner.nextInt();

        System.out.print("Введите количество научных книг: ");
        int numberOfScientificBooks = scanner.nextInt();

        fillBookstoreUseCase.fillBookstore(numberOfFictionBooks, numberOfScientificBooks);
        bookstore.displayBooks();
    }
}
