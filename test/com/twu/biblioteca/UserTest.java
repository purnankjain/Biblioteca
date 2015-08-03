package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    User user;

    @Before
    public void initialise() {
        user = new User("Ram", "asd");
    }

    @Test
    public void shouldConfirmCredentials() {
        assertEquals(true, user.hasCredentials("Ram", "asd"));
    }
}
