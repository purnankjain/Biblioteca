package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class MenuTest {

    Menu menu;
    View mockView;
    Library mockLibrary;
    QuitOperation mockQuitOperation;
    InvalidOperation mockInvalidMenuOption;
    ListOperation mockListOperation;
    ArrayList<Operation> operations;

    @Before
    public void initialise() {
        mockView = mock(View.class);
        mockQuitOperation = mock(QuitOperation.class);
        mockInvalidMenuOption = mock(InvalidOperation.class);
        mockLibrary = mock(Library.class);
        mockListOperation = mock(ListOperation.class);
        operations = new ArrayList<Operation>();
        menu = new Menu(operations, mockInvalidMenuOption);
    }

    @Test
    public void shouldReturnListBooksOption() {
        ArrayList<Item> books = new ArrayList<Item>();
        Library library = new Library("Item", books, new ArrayList<Item>());
        ListOperation listOperation = new ListOperation("List Books", library);
        ArrayList<Operation> operations = new ArrayList<Operation>();
        operations.add(listOperation);
        operations.add(mockQuitOperation);
        menu = new Menu(operations, mockInvalidMenuOption);

        assertEquals(ListOperation.class, menu.selectItem("List Books").getClass());
    }

    @Test
    public void shouldReturnQuitOption() {
        QuitOperation quitOperation = new QuitOperation("Quit");
        ArrayList<Operation> operations = new ArrayList<Operation>();
        operations.add(mockListOperation);
        operations.add(quitOperation);
        menu = new Menu(operations, mockInvalidMenuOption);

        assertEquals(QuitOperation.class, menu.selectItem("Quit").getClass());
    }

    @Test
    public void shouldReturnInvalidMenuOption() {
        operations.add(mockListOperation);
        operations.add(mockQuitOperation);
        menu = new Menu(operations, new InvalidOperation());

        assertEquals(InvalidOperation.class, menu.selectItem("Blah").getClass());
    }

    @Test
    public void shouldReturnCheckOutOption() {
        operations.add(new CheckOutOperation("CheckOut", mockLibrary));
        menu = new Menu(operations, new InvalidOperation());

        assertEquals(CheckOutOperation.class, menu.selectItem("CheckOut").getClass());
    }

    @Test
    public void shouldReturnReturnOption() {
        operations.add(new ReturnItemOperation("Return", mockLibrary));
        menu = new Menu(operations, new InvalidOperation());

        assertEquals(ReturnItemOperation.class, menu.selectItem("Return").getClass());
    }
}
