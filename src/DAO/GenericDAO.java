package DAO;

import java.util.List;

public interface GenericDAO<T> {
    boolean create(T t);
    T get(int id);
    List<T> getAll();
    boolean update(T t);
    boolean delete(int id);
}
