package se.Lexicon.DAOs;

import se.Lexicon.model.Person;

import java.util.Collection;

public interface PersonDAO<T,P> extends DAO{

    T findById(P p);
    T findByEmail(P p);
}
