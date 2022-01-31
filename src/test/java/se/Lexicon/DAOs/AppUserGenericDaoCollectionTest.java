package se.Lexicon.DAOs;

import org.junit.Before;
import org.junit.Test;
import se.Lexicon.security.AppRole;
import se.Lexicon.security.AppUser;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppUserGenericDaoCollectionTest {
    AppUserDAOCollection testObject ;
    List<AppUser> initList;
    private AppUser user1;
    private AppUser user2;
    private AppUser user3;
    private AppUser user4;
    private AppUser user5;

    @Before
    public void setUp() throws Exception {

        user1 =new AppUser("todo1","p1", AppRole.ROLE_APP_User);
        user2 =new AppUser("todo2","p2", AppRole.ROLE_APP_ADMIN);
        user3 =new AppUser("todo3","p3", AppRole.ROLE_APP_User);
        user4 =new AppUser("todo4","p4", AppRole.ROLE_APP_ADMIN);
        user5 =new AppUser("todo5","p5", AppRole.ROLE_APP_User);


        initList = new ArrayList<>();
        initList.add(user1);
        initList.add(user2);
        initList.add(user3);
        initList.add(user4);
        initList.add(user5);

        testObject = AppUserDAOCollection.getTestInstance(initList);

    }

    @Test
    public void test_persist() {
        int expect = (int)initList.stream().count()+1;
        int actual = 0;

        testObject.persist(new AppUser("test","testPass",AppRole.ROLE_APP_User));
        actual = (int)initList.stream().count();
        assertEquals(expect,actual);
    }

    @Test
    public void test_findByUserName() {
        AppUser expect = user1;
        AppUser actual ;
         actual = (AppUser) testObject.findById(user1.getUserName());
        assert(actual.equals(expect));
    }

    @Test
    public void findAll() {
        int expect = initList.size();
        int actual;

        actual = testObject.findAll().size();
        assert(expect==actual);
    }

    @Test
    public void test_remove() {
        int expect = initList.size() -1;
        int actual;

        testObject.remove(user1.getUserName());
        actual = initList.size();
        assert(expect==actual);
    }
}