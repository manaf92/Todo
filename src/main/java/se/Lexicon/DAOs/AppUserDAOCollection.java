package se.Lexicon.DAOs;

import se.Lexicon.model.TodoItem;
import se.Lexicon.security.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDAOCollection implements  AppUserDAO{
     private Collection<AppUser> appUsers;

    // Singleton
    public static AppUserDAOCollection INSTANCE ;

    public static AppUserDAOCollection getInstance(){
        if (INSTANCE==null) INSTANCE= new AppUserDAOCollection();
        return INSTANCE;
    }

    public static AppUserDAOCollection getTestInstance(List<AppUser> appUsers){
        return new AppUserDAOCollection(appUsers);
    }

    private AppUserDAOCollection() {
        this.appUsers = new ArrayList<>();
    }


    private AppUserDAOCollection(Collection<AppUser> appUsers) {
        this.appUsers = appUsers;
    }




    @Override
    public AppUser persist(AppUser o) {
        return appUsers.add((AppUser) o)? o : null;
    }

    @Override
    public AppUser findById(String username) {
        return appUsers.stream()
                .filter(a-> a.getUserName().equals(username))
                .findFirst()
                .get();
    }

    @Override
    public Collection findAll() {
        return new ArrayList<>(appUsers);
    }

    @Override
    public void remove(String username) {
        appUsers.removeIf(a->a.getUserName().equals(username));
    }

}
