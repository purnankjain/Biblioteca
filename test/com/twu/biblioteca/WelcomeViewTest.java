package com.twu.biblioteca;

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
    Controller nextViewHandler;

    @Before
    public void initialise() {
        nextViewHandler = mock(Controller.class);
        userDatabase = mock(UserDatabase.class);
        loginView = new LoginView(inputView, userDatabase, nextViewHandler);
        welcomeView = new WelcomeView(loginView);
        user = mock(User.class);
    }

    @Test
    public void shouldReturnLoginView() {
        assertEquals(LoginView.class, welcomeView.renderView(user).getClass());
    }

}
