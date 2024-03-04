package org.datastorage.datastorage;

import org.datastorage.interfaces.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class DataStorage<T> implements CrudRepository<T> {
    private static final Logger LOGGER = Logger.getLogger(DataStorage.class.getName());


    private List<T> storage;
    private Integer sizeLimit; // Опциональное ограничение размера

    // Приватный конструктор, используемый билдером
    private DataStorage(List<T> storage, Integer sizeLimit) {
        this.storage = storage;
        this.sizeLimit = sizeLimit;
        LOGGER.info("DataStorage instance created with size limit: " + sizeLimit);
    }
    @Override
    public void add(T item) {
        if (sizeLimit == null || storage.size() < sizeLimit) {
            storage.add(item); LOGGER.info("Item added: " + item);
        } else {
            LOGGER.warning("Attempted to add item to full storage: " + item);
        }
    }

    // Статический метод создания билдера
    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    // Внутренний статический класс Builder
    public static class Builder<T> {
        private List<T> storage = new ArrayList<>();
        private Integer sizeLimit;

        public Builder<T> sizeLimit(Integer sizeLimit) {
            this.sizeLimit = sizeLimit;
            return this;
        }

        public DataStorage<T> build() {
            return new DataStorage<>(storage, sizeLimit);
        }
    }
    @Override
    public T getByIndex(int index) {
        if (index >= 0 && index < storage.size()) {
            T item = storage.get(index);
            LOGGER.info("Item retrieved by index " + index + ": " + item);
            return item;
        }
        LOGGER.warning("Attempted to access item with invalid index: " + index);
        return null;
    }

    @Override
    public List<T> getAll() {
        LOGGER.info("All items retrieved. Total items: " + storage.size());
        return new ArrayList<>(storage);
    }

    @Override
    public T sum() {
        if (storage.isEmpty()) return null;

        // Инициализация sumResult в зависимости от типа первого элемента
        Object sumResult = null;
        boolean isStringType = storage.get(0) instanceof String;
        boolean isNumberType = storage.get(0) instanceof Number;

        for (Object item : storage) {
            if (isStringType) {
                sumResult = sumResult == null ? item : ((String) sumResult) + item;
            } else if (isNumberType) {
                sumResult = sumResult == null ? ((Number) item).doubleValue() : ((Number) sumResult).doubleValue() + ((Number) item).doubleValue();
            } else {
                System.out.println("Type is not supporting");
                return null;
            }
        }

        return (T) sumResult;

    }
}
