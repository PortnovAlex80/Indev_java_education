package org.datastorage.interfaces;

import java.util.List;

public interface CrudRepositoty<T> {
  void add(T item);
  T getByIndex(int index);
  List<T> getAll();
  T sum();
}
