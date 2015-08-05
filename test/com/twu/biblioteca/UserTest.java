package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class UserTest {

    User user;
    ArrayList<Book> books;

    @Before
    public void initialise() {
        user = new User("Ram", "asd", "Ajay", "ajaygupta@yahoo.com", "9999", new ArrayList<Book>(), UserRoles.ADMIN_ROLE);
        books = new ArrayList<Book>();
        books.add(new Book("Harry", "JK", 2001));
    }

    @Test
    public void shouldConfirmCredentials() {
        assertEquals(true, user.hasCredentials("Ram", "asd"));
    }

    @Test
    public void shouldAddBookToUserBookList() {
        user.addBookToUserBookList(new Book("Harry", "JK", 2001));
        assertEquals(books, user.getAllBooks());
    }

    @Test
    public void checkWhetherUserHasBookOrNot() {
        user = new User("Ram", "asd", "Ajay", "ajaygupta@yahoo.com", "9999", books, UserRoles.NORMAL_USER);
        assertEquals(true, user.hasBook(new Book("Harry", "JK", 2001)));
    }

    @Test
    public void shouldRemoveABookFromBookList() {
        user = new User("Ram", "asd", "Ajay", "ajaygupta@yahoo.com", "9999", books, UserRoles.ADMIN_ROLE);
        assertEquals(true, user.hasBook(new Book("Harry", "JK", 2001)));
        user.removeBook(new Book("Harry", "JK", 2001));
        assertEquals(false, user.hasBook(new Book("Harry", "JK", 2001)));
    }

    @Test
    public void shouldReturnUserDetails() {
        String expected = "Ajay ajaygupta@yahoo.com 9999";

        assertEquals(expected, user.toString());
    }

    @Test
    public void shouldCheckEqualityOfTwoUsers() {
        User user2 = new User("Ram", "asd", "Ajay", "ajaygupta@yahoo.com", "9999", new ArrayList<Book>(), UserRoles.NORMAL_USER);

        assertEquals(user2, user);
    }

    @Test
    public void shouldConfirmUserRole() {
        assertEquals(true, user.hasRole(UserRoles.ADMIN_ROLE));
    }
}
