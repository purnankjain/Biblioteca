package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class BookLibraryTest {

    BookLibrary bookLibrary;
    ArrayList<Book> bookList;

    @Before
    public void initialiseBookList() {
        bookList = new ArrayList<Book>();
        Book book1 = new Book(1, "The Alchemist", "Poelo Coehlo", 2005);
        Book book2 = new Book(2, "Harry Potter And the Half Blood Prince", "J.K Rowling", 2005);
        bookList.add(book1);
        bookList.add(book2);
        bookLibrary = new BookLibrary(bookList);
    }

    @Test
    public void shouldReturnAllBooksInLibrary() {
        ArrayList<String> expectedBookList = new ArrayList<String>();
        expectedBookList.add("The Alchemist, Poelo Coehlo, 2005");
        expectedBookList.add("Harry Potter And the Half Blood Prince, J.K Rowling, 2005");

        assertEquals(expectedBookList, bookLibrary.getAllBooks());
    }

    @Test
    public void checkForEquality() {
        BookLibrary bookLibrary1 = new BookLibrary(bookList);

        assertEquals(bookLibrary1, bookLibrary);
    }

}
