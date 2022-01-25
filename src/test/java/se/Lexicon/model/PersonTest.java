package se.Lexicon.model;

import org.junit.*;
import org.junit.Test;
import se.Lexicon.security.AppRole;
import se.Lexicon.security.AppUser;

import static org.junit.Assert.*;

public class PersonTest {
    private Person testObject;
    private AppUser user;

    @Before
    public  void setup() throws Exception{
         user =new AppUser("todo1","p3", AppRole.ROLE_APP_ADMIN);

        testObject = new Person("Admin","Admin","Admin@example.com",user);


    }
    @Test
    public void test_Get_FirstName_After_Build_It_Using_The_Constructor() {
        //Arrange
        String expected= "Admin";
        String actual="";

        //Act
        actual = testObject.getFirstName();

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void test_Equals_Method_Should_Return_true() {
        boolean expect = true;
        boolean actual = testObject.equals((new Person("Admin","Admin","Admin@example.com",user)));

        assertEquals(expect,actual);
    }

    @Test
    public void test_Equals_Method_Should_Return_False() {
        boolean expect = false;
        boolean actual = testObject.equals(new Person("ff","ss","ff",user));

        assertEquals(expect,actual);
    }

    @Test
    public void test_hashCode_Method_Should_Return_False() {
        boolean expect = false;
        boolean actual = testObject.hashCode()==(new Person("ff","ss","ff",user).hashCode());

        assertEquals(expect,actual);
    }

    @Test
    public void test_hashCode_Method_Should_Return_True() {
        boolean expect = true;
        boolean actual = testObject.hashCode()==new Person("Admin","Admin","Admin@example.com",user).hashCode();

        assertEquals(expect,actual);
    }

    @Test
    public void getLastName() {
    }

    @Test
    public void getEmail() {
    }
}