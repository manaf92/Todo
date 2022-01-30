package se.Lexicon.DAOs;

import java.util.Collection;

public interface DAO<T,P> {
    T persist(T t);
    Collection<T> findAll();
    void remove(P p);
}
