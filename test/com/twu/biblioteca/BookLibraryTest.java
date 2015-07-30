package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class BookLibraryTest {

    BookLibrary bookLibrary;
    ArrayList<Book> bookList;
    Book book1,book2;

    @Before
    public void initialiseBookList() {
        bookList = new ArrayList<Book>();
        book1 = new Book("The Alchemist", "Poelo Coehlo", 2005);
        book2 = new Book("Harry Potter And the Half Blood Prince", "J.K Rowling", 2005);
        bookList.add(book1);
        bookList.add(book2);
        bookLibrary = new BookLibrary(bookList, new ArrayList<Book>());
    }

    @Test
    public void shouldReturnAllBooksInLibrary() {
        ArrayList<String> expectedBookList = new ArrayList<String>();
        expectedBookList.add("The Alchemist, Poelo Coehlo, 2005");
        expectedBookList.add("Harry Potter And the Half Blood Prince, J.K Rowling, 2005");

        assertEquals(expectedBookList, bookLibrary.getAllBooks());
    }

    @Test
    public void shouldCheckOutABook() {
        bookList = new ArrayList<Book>();
        Book mockBook = mock(Book.class);
        bookList.add(mockBook);
        bookLibrary = new BookLibrary(bookList, new ArrayList<Book>());

        when(mockBook.isTitled("Hello")).thenReturn(true);

        assertEquals("Thank you! Enjoy the book", bookLibrary.checkOutItem("Hello"));
    }

    @Test
    public void shouldNotCheckOutABookWhenNotAvailable() {
        bookList = new ArrayList<Book>();
        Book mockBook = mock(Book.class);
        bookList.add(mockBook);
        bookLibrary = new BookLibrary(bookList, new ArrayList<Book>());

        when(mockBook.isTitled("Hello")).thenReturn(false);

        assertEquals("That book is not available.", bookLibrary.checkOutItem("Hello"));
    }

    @Test
    public void shouldReturnABookWhichIsCheckedOut() {
        bookList = new ArrayList<Book>();
        Book mockBook = mock(Book.class);
        bookList.add(mockBook);
        bookLibrary = new BookLibrary(new ArrayList<Book>(), bookList);

        when(mockBook.isTitled("Hello")).thenReturn(true);

        assertEquals("Thank you for returning the book.", bookLibrary.returnThisItem("Hello"));
    }

    @Test
    public void shouldNotReturnABookWhichIsNotCheckedOut() {
        bookList = new ArrayList<Book>();
        Book mockBook = mock(Book.class);
        bookList.add(mockBook);
        bookLibrary = new BookLibrary(bookList, new ArrayList<Book>());

        when(mockBook.isTitled("Hello")).thenReturn(true);

        assertEquals("That is not a valid book to return.", bookLibrary.returnThisItem("Hello"));
    }
}
