package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserDatabase;
import com.twu.biblioteca.user.UserRoles;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginViewTest {

    LoginView loginView;
    InputView inputView;
    UserDatabase userDatabase;
    LibrarianMenuView librarianMenuView;
    UserMenuView userMenuView;
    NullUserView nullUserView;
    User mockUser;
    Controller controller;

    @Before
    public void initialise() {
        inputView = mock(InputView.class);
        userDatabase = mock(UserDatabase.class);
        librarianMenuView = new LibrarianMenuView(inputView);
        userMenuView = mock(UserMenuView.class);
        mockUser = new User("", "", "", "", "", null, null, UserRoles.ADMIN_ROLE);
        nullUserView = mock(NullUserView.class);
        controller = mock(Controller.class);
        loginView = new LoginView(inputView, userDatabase);
    }

    @Test
    public void shouldReturnAnIView() {
        when(inputView.readInput()).thenReturn("asd").thenReturn("asd");
        when(userDatabase.login("asd", "asd")).thenReturn(mockUser);
        when(controller.menuView(mockUser)).thenReturn(librarianMenuView);

        assertEquals(LibrarianMenuView.class, loginView.renderView(controller, mockUser).getClass());
    }
}
