package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class UserDatabaseTest {

    UserDatabase userDatabase;
    ArrayList<IUser> users;
    User user;

    @Before
    public void initialise() {
        user = mock(User.class);
        users = new ArrayList<IUser>();
        users.add(user);
        userDatabase = new UserDatabase(users);
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
