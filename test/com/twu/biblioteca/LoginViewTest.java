package com.twu.biblioteca;

import com.twu.biblioteca.parser.Parser;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserDatabase;
import com.twu.biblioteca.user.UserRoles;
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
    ListAvailableItemsView listAvailableItemsView;
    CheckOutView checkOutView;
    ReturnView returnView;
    InvalidOperationView invalidOperationView;
    Parser parser;
    Controller nextViewHandler;

    @Before
    public void initialise() {
        inputView = mock(InputView.class);
        userDatabase = mock(UserDatabase.class);
        librarianMenuView = new LibrarianMenuView(inputView, parser, nextViewHandler);
        userMenuView = mock(UserMenuView.class);
        mockUser = new User("", "", "", "", "", null, UserRoles.ADMIN_ROLE);
        nullUserView = mock(NullUserView.class);
        nextViewHandler = mock(Controller.class);
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
