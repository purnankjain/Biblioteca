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
    QuitOption mockQuitOption;
    InvalidMenuOption mockInvalidMenuOption;

    @Before
    public void initialise() {
        mockView = mock(View.class);
        mockQuitOption = mock(QuitOption.class);
        mockInvalidMenuOption = mock(InvalidMenuOption.class);
        mockBookLibrary = mock(BookLibrary.class);
        menu = new Menu(mockBookLibrary, mockQuitOption, mockInvalidMenuOption);
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
        menu = new Menu(bookLibrary, mockQuitOption, mockInvalidMenuOption);

        assertEquals(BookLibrary.class, menu.selectItem("List Books").getClass());
    }

    @Test
    public void shouldReturnQuit() {
        QuitOption quitOption = new QuitOption();
        menu = new Menu(mockBookLibrary, quitOption, mockInvalidMenuOption);

        assertEquals(QuitOption.class, menu.selectItem("Quit").getClass());
    }

    @Test
    public void shouldReturnInvalidMenuItem() {
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption();
        menu = new Menu(mockBookLibrary, mockQuitOption, invalidMenuOption);

        assertEquals(InvalidMenuOption.class, menu.selectItem("Blah").getClass());
    }
}
