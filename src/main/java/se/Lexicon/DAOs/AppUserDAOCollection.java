package se.Lexicon.DAOs;

import se.Lexicon.security.AppUser;

import java.util.ArrayList;
import java.util.Collection;

public class AppUserDAOCollection implements  AppUserDAO{
     Collection<AppUser> appUsers = new ArrayList<>();
    @Override
    public Object persist(Object o) {
        return appUsers.add((AppUser) o)? o : null;
    }

    @Override
    public Object findByUserName(Object o) {
        return appUsers.stream()
                .filter(a-> a.getUserName().equals((String) o))
                .findFirst()
                .get();
    }

    @Override
    public Collection findAll() {
        return new ArrayList<>(appUsers);
    }

    @Override
    public void remove(Object o) {
        appUsers.removeIf(a->a.getUserName().equals((String) o));
    }

}
