package se.Lexicon.DAOs;

import se.Lexicon.security.AppUser;

import java.util.Collection;

public interface AppUserDAO<T,P> extends DAO{
    T findByUserName(P p);
}
