package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class BibliotecaApplicationTest {

    BibliotecaApplication bibliotecaApplication;
    BookLibrary mockLibrary;
    View mockView;

    @Before
    public void initialise() {
        mockView = mock(View.class);
        mockLibrary = mock(BookLibrary.class);
        bibliotecaApplication = new BibliotecaApplication(mockView, mockLibrary);
    }

    @Test
    public void shouldGreetUser() {
        bibliotecaApplication.start();
        verify(mockView, times(1)).greetUser();
    }

    @Test
    public void shouldInvokeBookLibraryAfterGreeting() {
        ArrayList<String> bookList = new ArrayList<String>();
        bookList.add("Harry Potter");
        bookList.add("White Tiger");
        when(mockLibrary.getAllBooks()).thenReturn(bookList);
        bibliotecaApplication.start();
        verify(mockView, times(1)).greetUser();
        verify(mockView, times(1)).printBookNamesToConsole(bookList);
    }
}
