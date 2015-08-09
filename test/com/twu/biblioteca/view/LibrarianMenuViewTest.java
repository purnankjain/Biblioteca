package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.view.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibrarianMenuViewTest {

    ListAvailableItemsView listAvailableItemsView;
    CheckOutView checkOutView;
    ReturnItemView returnItemView;
    InvalidOperationView invalidOperationView;
    InputView inputView;
    LibrarianMenuView librarianMenuView;
    User user;
    Controller controller;

    @Before
    public void initialise() {
        controller = mock(Controller.class);
        listAvailableItemsView = new ListAvailableItemsView(null);
        checkOutView = mock(CheckOutView.class);
        returnItemView = mock(ReturnItemView.class);
        invalidOperationView = mock(InvalidOperationView.class);
        inputView = mock(InputView.class);
        librarianMenuView = new LibrarianMenuView(inputView);
    }

    @Test
    public void shouldReturnViewAccordingToOperationSelected() {
        when(inputView.readInput()).thenReturn("List Books");
        when(controller.selectOperationView("List Books")).thenReturn(listAvailableItemsView);

        assertEquals(ListAvailableItemsView.class, librarianMenuView.renderView(controller, user).getClass());
    }
}
