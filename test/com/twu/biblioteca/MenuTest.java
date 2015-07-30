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
    ListBooksOption mockListBooksOption;

    @Before
    public void initialise() {
        mockView = mock(View.class);
        mockQuitOption = mock(QuitOption.class);
        mockInvalidMenuOption = mock(InvalidMenuOption.class);
        mockBookLibrary = mock(BookLibrary.class);
        mockListBooksOption = mock(ListBooksOption.class);
        menu = new Menu(mockListBooksOption, mockQuitOption, mockInvalidMenuOption);
    }

    @Test
    public void shouldCallPrintOfView() {
        menu.renderMenu(mockView);

        verify(mockView, atLeastOnce()).printToConsole("===========================");
        verify(mockView, times(1)).printToConsole("List Books");
    }

    @Test
    public void shouldReturnListBooksOption() {
        ArrayList<Book> books = new ArrayList<Book>();
        BookLibrary bookLibrary  = new BookLibrary(books);
        ListBooksOption listBooksOption = new ListBooksOption(bookLibrary);
        menu = new Menu(listBooksOption, mockQuitOption, mockInvalidMenuOption);

        assertEquals(ListBooksOption.class, menu.selectItem("List Books").getClass());
    }

    @Test
    public void shouldReturnQuit() {
        QuitOption quitOption = new QuitOption();
        menu = new Menu(mockListBooksOption, quitOption, mockInvalidMenuOption);

        assertEquals(QuitOption.class, menu.selectItem("Quit").getClass());
    }

    @Test
    public void shouldReturnInvalidMenuItem() {
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption();
        menu = new Menu(mockListBooksOption, mockQuitOption, invalidMenuOption);

        assertEquals(InvalidMenuOption.class, menu.selectItem("Blah").getClass());
    }
}
