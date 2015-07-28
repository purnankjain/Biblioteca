package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class BookLibraryTest {

    ArrayList<String> bookList;

    @Before
    public void initialiseBookList() {
        bookList = new ArrayList<String>();
        bookList.add("The Alchemist");
        bookList.add("Harry Potter And the Half Blood Prince");
        bookList.add("White Tiger");
    }

    @Test
    public void shouldReturnAllBooksInLibrary() {
        BookLibrary bookLibrary = new BookLibrary(bookList);
        ArrayList<String> expectedBookList = new ArrayList<String>();
        expectedBookList.add("The Alchemist");
        expectedBookList.add("Harry Potter And the Half Blood Prince");
        expectedBookList.add("White Tiger");

        assertEquals(expectedBookList, bookLibrary.getAllBooks());
    }

}
