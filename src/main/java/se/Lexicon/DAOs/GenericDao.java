package se.Lexicon.DAOs;

import java.util.Collection;

public interface GenericDao<T,ID> {
    T persist(T t);
    T findById(ID id);
    Collection<T> findAll();
    void remove(ID id);
}
