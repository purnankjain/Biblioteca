package com.twu.biblioteca;

import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserRoles;
import com.twu.biblioteca.view.LibrarianMenuView;
import com.twu.biblioteca.view.NullUserView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControllerTest {

    Controller controller;
    LibrarianMenuView librarianMenuView;
    User user;
    NullUserView nullUserView;

    @Before
    public void initialise() {
        user = new User("", "" ,"", "", "", null, UserRoles.ADMIN_ROLE);
        librarianMenuView = new LibrarianMenuView(null);
        nullUserView = new NullUserView("");
        controller = new Controller(librarianMenuView, null, nullUserView, null, null, null, user);
    }

    @Test
    public void shouldReturnNullUserView() {
        User nullUser = new User();
        controller = new Controller(librarianMenuView, null, nullUserView, null, null, null, nullUser);
        assertEquals(NullUserView.class, controller.menuView(nullUser).getClass());
    }

    @Test
    public void shouldReturnLibrarianMenuView() {
        assertEquals(LibrarianMenuView.class, controller.menuView(user).getClass());
    }
}
