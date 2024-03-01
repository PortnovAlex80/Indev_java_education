package org.datastorage;

import org.datastorage.datastorage.DataStorage;

public class main {
    public static void main(String[] args) {
        DataStorage<String> stringDataStorage = new DataStorage<>();
        DataStorage<Integer> integerDataStorage = new DataStorage<>();
        DataStorage<Boolean> booleanDataStorage = new DataStorage<>();

        // Добавление строк в хранилище и демонстрация работы
        stringDataStorage.add("Hello");
        stringDataStorage.add(" ");
        stringDataStorage.add("World");
        System.out.println("Элемент по индексу 0: " + stringDataStorage.getByIndex(0));
        System.out.println("Все элементы: " + stringDataStorage.getAll());
        System.out.println("Сумма (конкатенация) всех строк: " + stringDataStorage.sum());

        // Добавление чисел в хранилище и демонстрация работы
        integerDataStorage.add(1);
        integerDataStorage.add(2);
        System.out.println("Элемент по индексу 1: " + integerDataStorage.getByIndex(1));
        System.out.println("Все элементы: " + integerDataStorage.getAll());
        System.out.println("Сумма всех чисел: " + integerDataStorage.sum());

        // Добавление булевых значений в хранилище и демонстрация работы
        booleanDataStorage.add(true);
        booleanDataStorage.add(false);
        booleanDataStorage.add(false);
        booleanDataStorage.add(true);
        System.out.println("Элемент по индексу 1: " + booleanDataStorage.getByIndex(1));
        System.out.println("Все элементы: " + booleanDataStorage.getAll());

        // Дополнительные действия, если требуется
    }
}
