package com.twu.biblioteca;

import com.twu.biblioteca.view.LoginView;
import com.twu.biblioteca.view.WelcomeView;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WelcomeViewTest {

    WelcomeView welcomeView;
    LoginView loginView;
    User user;
    BufferedReader bufferedReader;
    UserDatabase userDatabase;

    @Before
    public void initialise() {
        userDatabase = mock(UserDatabase.class);
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        loginView = new LoginView(bufferedReader, userDatabase);
        welcomeView = new WelcomeView(loginView);
        user = mock(User.class);
    }

    @Test
    public void shouldReturnLoginView() {
        assertEquals(LoginView.class, welcomeView.renderView(user).getClass());
    }

}
