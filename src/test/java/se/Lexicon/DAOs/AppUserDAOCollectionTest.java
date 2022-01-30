package se.Lexicon.DAOs;

import org.junit.Before;
import org.junit.Test;
import se.Lexicon.model.Person;
import se.Lexicon.security.AppRole;
import se.Lexicon.security.AppUser;

import java.util.Collection;

import static org.junit.Assert.*;

public class AppUserDAOCollectionTest {
    AppUserDAOCollection testObject = new AppUserDAOCollection();
    private AppUser user1;
    private AppUser user2;
    private AppUser user3;
    private AppUser user4;

    @Before
    public void setUp() throws Exception {

        user1 =new AppUser("todo1","p1", AppRole.ROLE_APP_User);
        user2 =new AppUser("todo2","p2", AppRole.ROLE_APP_ADMIN);
        user3 =new AppUser("todo3","p3", AppRole.ROLE_APP_User);
        user4 =new AppUser("todo4","p4", AppRole.ROLE_APP_ADMIN);

        testObject.appUsers.add(user1);
        testObject.appUsers.add(user2);
        testObject.appUsers.add(user3);
        testObject.appUsers.add(user4);


    }

    @Test
    public void test_persist() {
        int expect = (int)testObject.appUsers.stream().count()+1;
        int actual = 0;
        testObject.persist(new AppUser("test","testPass",AppRole.ROLE_APP_User));
        actual = (int)testObject.appUsers.stream().count();
        assertEquals(expect,actual);
    }

    @Test
    public void test_findByUserName() {
        AppUser expect = user1;
        AppUser actual ;
         actual = (AppUser) testObject.findByUserName(user1.getUserName());
        assert(actual.equals(expect));
    }

    @Test
    public void findAll() {
        int expect = testObject.appUsers.size();
        int actual;
        ;
        actual = testObject.findAll().size();
        assert(expect==actual);
    }

    @Test
    public void test_remove() {
        int expect = testObject.appUsers.size() -1;
        int actual;
        testObject.remove(user1.getUserName());
        actual = testObject.appUsers.size();
        assert(expect==actual);
    }
}