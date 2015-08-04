package com.twu.biblioteca;

import com.twu.biblioteca.view.LoginView;
import com.twu.biblioteca.view.WelcomeView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WelcomeViewTest {

    WelcomeView welcomeView;
    LoginView loginView;
    User user;

    @Before
    public void initialise() {
        loginView = new LoginView();
        welcomeView = new WelcomeView(loginView);
        user = mock(User.class);
    }

    @Test
    public void shouldReturnLoginView() {
        assertEquals(LoginView.class, welcomeView.renderView(user).getClass());
    }

}
