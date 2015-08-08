package com.twu.biblioteca;

import com.twu.biblioteca.user.User;
import com.twu.biblioteca.view.LibrarianMenuView;
import com.twu.biblioteca.view.ListUnavailableItemsView;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListUnavailableItemsViewTest {

    ListUnavailableItemsView listUnavailableItemsView;
    LibrarySection mockLibrarySection;
    Controller mockController;
    User mockUser;
    LibrarianMenuView mockLibrarianView;

    @Before
    public void initialise() {
        mockUser = mock(User.class);
        mockLibrarianView = mock(LibrarianMenuView.class);
        mockController = mock(Controller.class);
        mockLibrarySection = mock(LibrarySection.class);
        listUnavailableItemsView = new ListUnavailableItemsView(mockLibrarySection, "");
    }

    @Test
    public void shouldReturnAView() {
        when(mockLibrarySection.getAllCheckedOutItemsWithOwnerDetails()).thenReturn(new ArrayList<String>());
        when(mockController.menuView(mockUser)).thenReturn(mockLibrarianView);

        assertEquals(mockLibrarianView, listUnavailableItemsView.renderView(mockController, mockUser));
    }
}
