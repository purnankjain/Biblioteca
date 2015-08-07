package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class LibrarySectionTest {

    LibrarySection librarySection;
    ArrayList<Item> bookList;
    Book book1,book2;

    @Before
    public void initialise() {
        bookList = new ArrayList<Item>();
        book1 = new Book("The Alchemist", "Poelo Coehlo", 2005);
        book2 = new Book("Harry Potter", "J.K Rowling", 2005);
        bookList.add(book1);
        bookList.add(book2);
        librarySection = new LibrarySection(bookList, new ArrayList<Item>());
    }

    @Test
    public void shouldReturnAllBooksInLibrary() {
        ArrayList<String> expectedBookList = new ArrayList<String>();
        expectedBookList.add(String.format("%25s %25s %6s","The Alchemist", "Poelo Coehlo", "2005"));
        expectedBookList.add(String.format("%25s %25s %6s","Harry Potter", "J.K Rowling", "2005"));

        assertEquals(expectedBookList, librarySection.getAllAvailableItems());
    }

    @Test
    public void shouldReturnListOfAllAvailableBooks() {
        ArrayList<Item> movieList = new ArrayList<>();
        movieList.add(new Movie("Harry", 2001, "yap", "3"));
        librarySection = new LibrarySection(movieList, new ArrayList<Item>());
        ArrayList<String> expectedMovies = new ArrayList<>();
        expectedMovies.add(String.format("%25s %6d %25s %10s", "Harry", 2001, "yap", "3"));

        assertEquals(expectedMovies, librarySection.getAllAvailableItems());
    }

    @Test
    public void shouldReturnListOfAllCheckedOutItems() {
        ArrayList<Item> movieList = new ArrayList<>();
        movieList.add(new Movie("Harry", 2001, "yap", "3"));
        librarySection = new LibrarySection(new ArrayList<Item>(), movieList);
        ArrayList<String> expectedMovies = new ArrayList<>();
        expectedMovies.add(String.format("%25s %6d %25s %10s", "Harry", 2001, "yap", "3"));

        assertEquals(expectedMovies, librarySection.getAllCheckedOutItems());
    }

    @Test
    public void shouldCheckOutAnItem() {
        bookList = new ArrayList<Item>();
        Book mockBook = mock(Book.class);
        bookList.add(mockBook);
        librarySection = new LibrarySection(bookList, new ArrayList<Item>());

        when(mockBook.isTitled("Hello")).thenReturn(true);

        assertEquals(true, librarySection.checkOutItem("Hello", new User()));
    }

    @Test
    public void shouldNotCheckOutAnItemWhenNotAvailable() {
        bookList = new ArrayList<Item>();
        Book mockBook = mock(Book.class);
        bookList.add(mockBook);
        librarySection = new LibrarySection(bookList, new ArrayList<Item>());

        when(mockBook.isTitled("Hello")).thenReturn(false);

        assertEquals(false, librarySection.checkOutItem("Hello", new User()));
    }

    @Test
    public void shouldReturnAnItemWhichIsCheckedOut() {
        bookList = new ArrayList<Item>();
        Book mockBook = mock(Book.class);
        bookList.add(mockBook);
        librarySection = new LibrarySection(new ArrayList<Item>(), bookList);

        when(mockBook.isTitled("Hello")).thenReturn(true);

        assertEquals(true, librarySection.returnThisItem("Hello"));
    }

    @Test
    public void shouldNotReturnAnItemWhichIsNotCheckedOut() {
        bookList = new ArrayList<Item>();
        Book mockBook = mock(Book.class);
        bookList.add(mockBook);
        librarySection = new LibrarySection(bookList, new ArrayList<Item>());

        when(mockBook.isTitled("Hello")).thenReturn(true);

        assertEquals(false, librarySection.returnThisItem("Hello"));
    }
}
