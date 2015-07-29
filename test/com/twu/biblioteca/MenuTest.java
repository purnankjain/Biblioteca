package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MenuTest {

    Menu menu;
    View mockView;
    BookLibrary mockBookLibrary;

    @Before
    public void initialise() {
        mockView = mock(View.class);
        mockBookLibrary = mock(BookLibrary.class);
        menu = new Menu(mockBookLibrary);
    }

    @Test
    public void shouldCallPrintOfView() {
        menu.renderMenu(mockView);
        verify(mockView, atLeastOnce()).printToConsole("===========================");
        verify(mockView, times(1)).printToConsole("Book List");
    }

    @Test
    public void shouldReturnBookLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        BookLibrary bookLibrary  = new BookLibrary(books);
        menu = new Menu(bookLibrary);
        assertEquals(BookLibrary.class, menu.selectItem("List Books").getClass());
    }
}
