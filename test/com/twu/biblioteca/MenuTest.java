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
    public void shouldReturnListBooksOption() {
        ArrayList<Book> books = new ArrayList<Book>();
        BookLibrary bookLibrary  = new BookLibrary(books, new ArrayList<Book>());
        ListBooksOption listBooksOption = new ListBooksOption("List Books", bookLibrary);
        ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>();
        menuOptions.add(listBooksOption);
        menuOptions.add(mockQuitOption);
        menu = new Menu(menuOptions, mockInvalidMenuOption);

        assertEquals(ListBooksOption.class, menu.selectItem("List Books").getClass());
    }

    @Test
    public void shouldReturnQuitOption() {
        QuitOption quitOption = new QuitOption("Quit");
        ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>();
        menuOptions.add(mockListBooksOption);
        menuOptions.add(quitOption);
        menu = new Menu(menuOptions, mockInvalidMenuOption);

        assertEquals(QuitOption.class, menu.selectItem("Quit").getClass());
    }

    @Test
    public void shouldReturnInvalidMenuOption() {
        menuOptions.add(mockListBooksOption);
        menuOptions.add(mockQuitOption);
        menu = new Menu(menuOptions, new InvalidMenuOption());

        assertEquals(InvalidMenuOption.class, menu.selectItem("Blah").getClass());
    }

    @Test
    public void shouldReturnCheckOutOption() {
        menuOptions.add(new CheckOutOption("CheckOut", mockBookLibrary));
        menu = new Menu(menuOptions, new InvalidMenuOption());

        assertEquals(CheckOutOption.class, menu.selectItem("CheckOut").getClass());
    }

    @Test
    public void shouldReturnReturnOption() {
        menuOptions.add(new ReturnOption("Return", mockBookLibrary));
        menu = new Menu(menuOptions, new InvalidMenuOption());

        assertEquals(ReturnOption.class, menu.selectItem("Return").getClass());
    }
}
