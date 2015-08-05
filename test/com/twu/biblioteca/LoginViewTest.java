package com.twu.biblioteca;

import com.twu.biblioteca.parser.Parser;
import com.twu.biblioteca.view.*;
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
    ListView listView;
    CheckOutView checkOutView;
    ReturnView returnView;
    InvalidOperationView invalidOperationView;
    Parser parser;

    @Before
    public void initialise() {
        inputView = mock(InputView.class);
        userDatabase = mock(UserDatabase.class);
        librarianMenuView = new LibrarianMenuView(inputView, listView, checkOutView, returnView, invalidOperationView, parser);
        userMenuView = mock(UserMenuView.class);
        mockUser = mock(User.class);
        nullUserView = mock(NullUserView.class);
        loginView = new LoginView(inputView, userDatabase, librarianMenuView, userMenuView, nullUserView);
    }

    @Test
    public void shouldReturnAnIView() {
        when(inputView.readInput()).thenReturn("asd").thenReturn("asd");
        when(userDatabase.login("asd", "asd")).thenReturn(mockUser);
        when(mockUser.nextView(loginView)).thenReturn(librarianMenuView);

        assertEquals(LibrarianMenuView.class, loginView.renderView(mockUser).getClass());
    }
}
