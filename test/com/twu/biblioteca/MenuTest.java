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
    Quit mockQuit;
    @Before
    public void initialise() {
        mockView = mock(View.class);
        mockQuit = mock(Quit.class);
        mockBookLibrary = mock(BookLibrary.class);
        menu = new Menu(mockBookLibrary, mockQuit);
    }

    @Test
    public void shouldCallPrintOfView() {
        menu.renderMenu(mockView);
        verify(mockView, atLeastOnce()).printToConsole("===========================");
        verify(mockView, times(1)).printToConsole("List Books");
    }

    @Test
    public void shouldReturnBookLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        BookLibrary bookLibrary  = new BookLibrary(books);
        menu = new Menu(bookLibrary, mockQuit);
        assertEquals(BookLibrary.class, menu.selectItem("List Books").getClass());
    }

    @Test
    public void shouldReturnQuit() {
        Quit quit = new Quit();
        menu = new Menu(mockBookLibrary, quit);
        assertEquals(Quit.class, menu.selectItem("Quit").getClass());
    }
}
