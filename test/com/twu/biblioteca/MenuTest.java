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
    ArrayList<MenuOption> menuOptions;

    @Before
    public void initialise() {
        mockView = mock(View.class);
        mockQuitOption = mock(QuitOption.class);
        mockInvalidMenuOption = mock(InvalidMenuOption.class);
        mockBookLibrary = mock(BookLibrary.class);
        mockListBooksOption = mock(ListBooksOption.class);
        menuOptions = new ArrayList<MenuOption>();
        menu = new Menu(menuOptions, mockInvalidMenuOption);
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
        ListBooksOption listBooksOption = new ListBooksOption("List Books", bookLibrary);
        ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>();
        menuOptions.add(listBooksOption);
        menuOptions.add(mockQuitOption);
        menu = new Menu(menuOptions, mockInvalidMenuOption);

        assertEquals(ListBooksOption.class, menu.selectItem("List Books").getClass());
    }

    @Test
    public void shouldReturnQuit() {
        QuitOption quitOption = new QuitOption("Quit");
        ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>();
        menuOptions.add(mockListBooksOption);
        menuOptions.add(quitOption);
        menu = new Menu(menuOptions, mockInvalidMenuOption);

        assertEquals(QuitOption.class, menu.selectItem("Quit").getClass());
    }

    @Test
    public void shouldReturnInvalidMenuItem() {
        menuOptions.add(mockListBooksOption);
        menuOptions.add(mockQuitOption);
        menu = new Menu(menuOptions, new InvalidMenuOption());

        assertEquals(InvalidMenuOption.class, menu.selectItem("Blah").getClass());
    }

    @Test
    public void shouldReturnCheckOutItem() {
        menuOptions.add(new CheckOutOption("CheckOut"));
        menu = new Menu(menuOptions, new InvalidMenuOption());

        assertEquals(CheckOutOption.class, menu.selectItem("CheckOut").getClass());
    }
}
