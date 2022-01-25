package se.Lexicon.model;

import se.Lexicon.security.*;

import java.util.Objects;

public class Person {

    private static int total;

    //fields
    private int  id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credential;

    public Person(String firstName, String lastName, String email, AppUser credential) {
        // increment the id and set it automatically
        total++;
        this.id = total;

        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setCredential(credential);
    }

    public void setFirstName(String firstName) {
        if (firstName==null)
            throw new IllegalArgumentException("Parameter: String firstName was null");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName==null)
            throw new IllegalArgumentException("Parameter: String lastName was null");
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if (email==null)
            throw new IllegalArgumentException("Parameter: String email was null");
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public AppUser getCredential() {
        return credential;
    }

    public void setCredential(AppUser credential) {
        if (credential==null)
            throw new IllegalArgumentException("Parameter: AppUser credential was null");
        this.credential = credential;
    }
    @Override
    public String toString() {
        return  "{id:"+ id+
                ", name: " +firstName+" "+lastName+
                ", email: "+ email+ "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getFirstName().equals(person.getFirstName())
                && getLastName().equals(person.getLastName())
                && getEmail().equals(person.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getEmail());
    }
}
