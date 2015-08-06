package com.twu.biblioteca;

import com.twu.biblioteca.operations.ListOperation;
import com.twu.biblioteca.parser.Parser;
import com.twu.biblioteca.user.IUser;
import com.twu.biblioteca.view.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibrarianMenuViewTest {

    ListAvailableItemsView listAvailableItemsView;
    CheckOutView checkOutView;
    ReturnView returnView;
    InvalidOperationView invalidOperationView;
    Parser parser;
    InputView inputView;
    LibrarianMenuView librarianMenuView;
    ListOperation listOperation;
    IUser user;
    Controller nextViewHandler;

    @Before
    public void initialise() {
        nextViewHandler = mock(Controller.class);
        listOperation = mock(ListOperation.class);
        listAvailableItemsView = new ListAvailableItemsView();
        checkOutView = mock(CheckOutView.class);
        returnView = mock(ReturnView.class);
        invalidOperationView = mock(InvalidOperationView.class);
        inputView = mock(InputView.class);
        parser = mock(Parser.class);
        librarianMenuView = new LibrarianMenuView(inputView, parser, nextViewHandler);
    }

    @Test
    public void shouldReturnViewAccordingToOperationSelected() {
        when(inputView.readInput()).thenReturn("List Books");
        when(parser.selectOperation("List Books")).thenReturn(listOperation);
        when(listOperation.nextView(nextViewHandler, user)).thenReturn(listAvailableItemsView);

        assertEquals(ListAvailableItemsView.class, librarianMenuView.renderView(user).getClass());
    }
}
