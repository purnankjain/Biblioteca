package com.twu.biblioteca;

import com.twu.biblioteca.operations.ListOperation;
import com.twu.biblioteca.parser.Parser;
import com.twu.biblioteca.view.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LibrarianMenuViewTest {

    ListView listView;
    CheckOutView checkOutView;
    ReturnView returnView;
    InvalidOperationView invalidOperationView;
    Parser parser;
    InputView inputView;
    LibrarianMenuView librarianMenuView;
    ListOperation listOperation;
    IUser user;

    @Before
    public void initialise() {
        listOperation = mock(ListOperation.class);
        listView = new ListView();
        checkOutView = mock(CheckOutView.class);
        returnView = mock(ReturnView.class);
        invalidOperationView = mock(InvalidOperationView.class);
        inputView = mock(InputView.class);
        parser = mock(Parser.class);
        librarianMenuView = new LibrarianMenuView(inputView, listView, checkOutView,
                returnView, invalidOperationView, parser);
    }

    @Test
    public void shouldReturnViewAccordingToOperationSelected() {
        when(inputView.readInput()).thenReturn("List Books");
        when(parser.selectOperation("List Books")).thenReturn(listOperation);
        when(listOperation.nextView(librarianMenuView)).thenReturn(listView);

        assertEquals(ListView.class, librarianMenuView.renderView(user).getClass());
    }
}
