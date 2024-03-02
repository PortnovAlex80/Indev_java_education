package org.datastorage;

import org.datastorage.datastorage.DataStorage;

public class Main {
    public static void main(String[] args) {
        // Использование билдера для создания экземпляров DataStorage с ограничением размера
        DataStorage<String> stringDataStorage = DataStorage.<String>builder()
                .sizeLimit(10)
                .build();

        DataStorage<Integer> integerDataStorage = DataStorage.<Integer>builder()
                .sizeLimit(10)
                .build();

        DataStorage<Boolean> booleanDataStorage = DataStorage.<Boolean>builder()
                .sizeLimit(10)
                .build();

        // Демонстрация работы с хранилищем строк
        demonstrateStorage("String Data Storage", stringDataStorage, "Hello", " ", "World");

        // Демонстрация работы с хранилищем целых чисел
        demonstrateStorage("Integer Data Storage", integerDataStorage, 1, 2);

        // Демонстрация работы с хранилищем булевых значений
        demonstrateStorage("Boolean Data Storage", booleanDataStorage, true, false, false, true);
    }

    private static <T> void demonstrateStorage(String title, DataStorage<T> storage, T... items) {
        System.out.println("----- " + title + " -----");
        for (T item : items) {
            storage.add(item);
        }
        System.out.println("Элемент по индексу 0: " + storage.getByIndex(0));
        System.out.println("Все элементы: " + storage.getAll());
        System.out.println("Результат суммирования/конкатенации: " + storage.sum());
        System.out.println();
    }
}
