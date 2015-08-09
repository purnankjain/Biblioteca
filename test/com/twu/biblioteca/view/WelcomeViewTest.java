package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserDatabase;
import com.twu.biblioteca.view.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class WelcomeViewTest {

    WelcomeView welcomeView;
    LoginView loginView;
    User user;
    InputView inputView;
    UserDatabase userDatabase;
    Controller controller;

    @Before
    public void initialise() {
        controller = mock(Controller.class);
        userDatabase = mock(UserDatabase.class);
        loginView = new LoginView(inputView, userDatabase);
        welcomeView = new WelcomeView(loginView);
        user = mock(User.class);
    }

    @Test
    public void shouldReturnLoginView() {
        assertEquals(LoginView.class, welcomeView.renderView(controller, user).getClass());
    }

}
