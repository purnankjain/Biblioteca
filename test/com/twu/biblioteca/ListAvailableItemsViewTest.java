package com.twu.biblioteca;

import com.twu.biblioteca.user.User;
import com.twu.biblioteca.view.LibrarianMenuView;
import com.twu.biblioteca.view.ListAvailableItemsView;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListAvailableItemsViewTest {

    ListAvailableItemsView listAvailableItemsView;
    LibrarySection librarySection;
    User user;
    Controller controller;
    LibrarianMenuView librarianMenuView;

    @Before
    public void initialise() {
        librarySection = mock(LibrarySection.class);
        user = new User();
        librarianMenuView = new LibrarianMenuView(null);
        controller = mock(Controller.class);
        listAvailableItemsView = new ListAvailableItemsView(librarySection);
    }

    @Test
    public void shouldReturnTheNextView() {
        when(librarySection.getAllAvailableItems()).thenReturn(new ArrayList<String>());
        when(controller.nextViewAfterLogin(user)).thenReturn(librarianMenuView);

        assertEquals(LibrarianMenuView.class, listAvailableItemsView.renderView(controller, user).getClass());
    }
}
