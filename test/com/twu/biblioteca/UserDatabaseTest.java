package com.twu.biblioteca;

import com.twu.biblioteca.user.IUser;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserDatabase;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class UserDatabaseTest {

    UserDatabase userDatabase;
    ArrayList<IUser> users;
    User user;
    IUser loggedInUser;

    @Before
    public void initialise() {
        user = mock(User.class);
        users = new ArrayList<IUser>();
        users.add(user);
        loggedInUser = mock(User.class);
        userDatabase = new UserDatabase(users, loggedInUser);
    }

    @Test
    public void shouldConfirmUserCredentials() {
        when(user.hasCredentials("Har", "asd")).thenReturn(true);

        assertEquals(true, userDatabase.checkCredentials("Har", "asd"));
    }

    @Test
    public void shouldReturnUserWithGivenCredentials() {
        when(user.hasCredentials("Har", "asd")).thenReturn(true);

        assertEquals(user, userDatabase.login("Har", "asd"));
    }
}
