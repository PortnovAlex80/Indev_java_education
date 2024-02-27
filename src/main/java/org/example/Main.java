package org.example;

import org.example.domain.model.BookFactory;
import org.example.domain.model.Bookstore;
import org.example.usecases.FillAndDisplayBookstoreUseCase;
import org.example.usecases.FillBookstoreUseCase;
import org.example.domain.model.FictionBookFactory;
import org.example.domain.model.ScientificBookFactory;

public class Main {
    public static void main(String[] args) {
        // Создаем фабрики книг
        BookFactory fictionBookFactory = new FictionBookFactory();
        BookFactory scientificBookFactory = new ScientificBookFactory();

        // Создаем магазин книг
        Bookstore bookstore = new Bookstore();

        // Создаем use case для заполнения магазина книгами и их вывода
        FillBookstoreUseCase fillBookstoreUseCase = new FillBookstoreUseCase(fictionBookFactory, scientificBookFactory, bookstore);
        FillAndDisplayBookstoreUseCase fillAndDisplayBookstoreUseCase = new FillAndDisplayBookstoreUseCase(fillBookstoreUseCase, bookstore);

        // Запускаем use case
        fillAndDisplayBookstoreUseCase.execute();
    }
}
