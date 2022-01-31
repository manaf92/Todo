package se.Lexicon.DAOs;

import se.Lexicon.model.Person;

public interface PersonDAO extends GenericDao<Person,Integer> {
    Person findByEmail(String email);
}
