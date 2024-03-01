package org.datastorage.datastorage;

import org.datastorage.interfaces.CrudRepositoty;

import java.util.ArrayList;
import java.util.List;


public class DataStorage<T> implements CrudRepositoty<T> {
    private List<T> storage = new ArrayList<T>();
    @Override
    public void add(T item) {
        storage.add(item);
    }

    @Override
    public T getByIndex(int index) {
        if (index >= 0 && index < storage.size()) {
            return storage.get(index);
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public T sum() {
        if (storage.isEmpty()) return null;

        Object sumResult = null;
        for (Object item : storage) {
            if (item instanceof String) {
                if (sumResult == null) {
                    sumResult = item;
                } else {
                    sumResult = ((String) sumResult) + (String) item;
                }
            } else if (item instanceof Number) {
                if (sumResult == null) {
                    sumResult = ((Number) item).doubleValue();
                } else {
                    sumResult = ((Number) sumResult).doubleValue() + ((Number) item).doubleValue();
                }
            } else {
                // Обработка других типов или выброс исключения
                throw new IllegalArgumentException("Unsupported type: " + item.getClass().getName());
            }
        }

        // Возвращаем sumResult как тип T, но это может потребовать приведения типов и не всегда безопасно
        @SuppressWarnings("unchecked")
        T result = (T) sumResult;
        return result;
    }

}
