package se.Lexicon.DAOs;

import se.Lexicon.model.Person;
import se.Lexicon.security.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonDAOCollection implements PersonDAO{

    private Collection<Person> persons;


    // Singleton
    public static PersonDAOCollection INSTANCE;

    public static PersonDAOCollection getInstance(){
        if (INSTANCE==null) INSTANCE = new PersonDAOCollection();
        return INSTANCE;
    }

    public static PersonDAOCollection getTestInstance(List<Person> persons){
        return new PersonDAOCollection(persons);
    }

    private PersonDAOCollection() {
        this.persons = new ArrayList<>();
    }


    private PersonDAOCollection(Collection<Person> persons) {
        this.persons = persons;
    }





    @Override
    public Person persist(Person person) {
        return persons.add( person)? person : null;
    }

    @Override
    public Person findById(Integer id) {
        return persons.stream()
                .filter(a-> a.getId()==id)
                .findFirst()
                .get();
    }

    @Override
    public Collection<Person> findAll() {
        return new ArrayList<>(persons);
    }

    @Override
    public void remove(Integer id) {
        persons.removeIf(p->p.getId()==id);
    }

    @Override
    public Person findByEmail(String email) {
        return persons.stream()
                .filter(a-> a.getEmail().equals(email))
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
