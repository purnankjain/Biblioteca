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
    NextViewHandler nextViewHandler;

    @Before
    public void initialise() {
        inputView = mock(InputView.class);
        userDatabase = mock(UserDatabase.class);
        librarianMenuView = new LibrarianMenuView(inputView, listView, checkOutView, returnView, invalidOperationView, parser);
        userMenuView = mock(UserMenuView.class);
        mockUser = new User("", "", "", "", "", null, UserRoles.ADMIN_ROLE);
        nullUserView = mock(NullUserView.class);
        nextViewHandler = mock(NextViewHandler.class);
        loginView = new LoginView(inputView, userDatabase, nextViewHandler);
    }

    @Test
    public void shouldReturnAnIView() {
        when(inputView.readInput()).thenReturn("asd").thenReturn("asd");
        when(userDatabase.login("asd", "asd")).thenReturn(mockUser);
        when(nextViewHandler.nextViewAfterLogin(mockUser)).thenReturn(librarianMenuView);

        assertEquals(LibrarianMenuView.class, loginView.renderView(mockUser).getClass());
    }
}
