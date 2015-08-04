package com.twu.biblioteca;

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
    LibrarianMenuView librarianMenuView;
    UserMenuView userMenuView;
    NullUserView nullUserView;

    @Before
    public void initialise() {
        userDatabase = mock(UserDatabase.class);
        loginView = new LoginView(inputView, userDatabase, librarianMenuView, userMenuView, nullUserView);
        welcomeView = new WelcomeView(loginView);
        user = mock(User.class);
    }

    @Test
    public void shouldReturnLoginView() {
        assertEquals(LoginView.class, welcomeView.renderView(user).getClass());
    }

}
