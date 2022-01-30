package se.Lexicon.DAOs;

import se.Lexicon.model.Person;

import java.util.ArrayList;
import java.util.Collection;

public class PersonDAOCollection implements PersonDAO{

    Collection<Person> persons = new ArrayList<>();
    @Override
    public Object persist(Object person) {
        return persons.add((Person) person)? person : null;
    }

    @Override
    public Object findById(Object id) {
        return persons.stream()
                .filter(a-> a.getId()==(int)id)
                .findFirst()
                .get();
    }

    @Override
    public Collection findAll() {
        return new ArrayList<>(persons);
    }

    @Override
    public void remove(Object id) {
        persons.removeIf(p->p.getId()==(int)id);
    }

    @Override
    public Object findByEmail(Object email) {
        return persons.stream()
                .filter(a-> a.getEmail().equals((String) email))
                .findFirst()
                .get();
    }
    // Here is non-generic way
    {
//    Collection<Person> persons = new ArrayList<>();
//    @Override
//    public Person persist(Person person) {
//        return persons.add(person)? person : null;
//    }
//
//    @Override
//    public Person findById(int id) {
//        return persons.stream()
//                .filter(a-> a.getId()==id)
//                .findFirst()
//                .get();
//    }
//
//    @Override
//    public Person findByEmail(String email) {
//        return persons.stream()
//                .filter(a-> a.getEmail().equals(email))
//                .findFirst()
//                .get();
//    }
//
//    @Override
//    public Collection<Person> findAll() {
//        return new ArrayList<>(persons);
//    }
//
//    @Override
//    public void remove(int id) {
//        persons.removeIf(p->p.getId()==id);
//    }
    }
}
