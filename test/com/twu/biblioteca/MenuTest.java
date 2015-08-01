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
    QuitOperation mockQuitOperation;
    InvalidOperation mockInvalidMenuOption;
    ListBooksOperation mockListBooksOperation;
    ArrayList<Operation> operations;

    @Before
    public void initialise() {
        mockView = mock(View.class);
        mockQuitOperation = mock(QuitOperation.class);
        mockInvalidMenuOption = mock(InvalidOperation.class);
        mockBookLibrary = mock(BookLibrary.class);
        mockListBooksOperation = mock(ListBooksOperation.class);
        operations = new ArrayList<Operation>();
        menu = new Menu(operations, mockInvalidMenuOption);
    }

    @Test
    public void shouldReturnListBooksOption() {
        ArrayList<Book> books = new ArrayList<Book>();
        BookLibrary bookLibrary  = new BookLibrary(books, new ArrayList<Book>());
        ListBooksOperation listBooksOperation = new ListBooksOperation("List Books", bookLibrary);
        ArrayList<Operation> operations = new ArrayList<Operation>();
        operations.add(listBooksOperation);
        operations.add(mockQuitOperation);
        menu = new Menu(operations, mockInvalidMenuOption);

        assertEquals(ListBooksOperation.class, menu.selectItem("List Books").getClass());
    }

    @Test
    public void shouldReturnQuitOption() {
        QuitOperation quitOperation = new QuitOperation("Quit");
        ArrayList<Operation> operations = new ArrayList<Operation>();
        operations.add(mockListBooksOperation);
        operations.add(quitOperation);
        menu = new Menu(operations, mockInvalidMenuOption);

        assertEquals(QuitOperation.class, menu.selectItem("Quit").getClass());
    }

    @Test
    public void shouldReturnInvalidMenuOption() {
        operations.add(mockListBooksOperation);
        operations.add(mockQuitOperation);
        menu = new Menu(operations, new InvalidOperation());

        assertEquals(InvalidOperation.class, menu.selectItem("Blah").getClass());
    }

    @Test
    public void shouldReturnCheckOutOption() {
        operations.add(new CheckOutBookOperation("CheckOut", mockBookLibrary));
        menu = new Menu(operations, new InvalidOperation());

        assertEquals(CheckOutBookOperation.class, menu.selectItem("CheckOut").getClass());
    }

    @Test
    public void shouldReturnReturnOption() {
        operations.add(new ReturnBookOperation("Return", mockBookLibrary));
        menu = new Menu(operations, new InvalidOperation());

        assertEquals(ReturnBookOperation.class, menu.selectItem("Return").getClass());
    }
}
