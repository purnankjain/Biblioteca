package com.twu.biblioteca;

import com.twu.biblioteca.view.LibrarianMenuView;
import com.twu.biblioteca.view.NullUserView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NextViewHandlerTest {

    NextViewHandler nextViewHandler;
    LibrarianMenuView librarianMenuView;
    IUser user;

    @Before
    public void initialise() {
        user = new User(null, null, null, null, null, null, UserRoles.ADMIN_ROLE);
        librarianMenuView = new LibrarianMenuView(null, null, null);
        nextViewHandler = new NextViewHandler(null, librarianMenuView, null, null,
                new NullUserView(),null , null , null, null);
    }

    @Test
    public void shouldReturnNullUserView() {
        NullUser nullUser = new NullUser();
        assertEquals(NullUserView.class, nextViewHandler.nextViewAfterLogin(nullUser).getClass());
    }

    @Test
    public void shouldReturnLibrarianMenuView() {
        assertEquals(LibrarianMenuView.class, nextViewHandler.nextViewAfterLogin(user).getClass());
    }
}
