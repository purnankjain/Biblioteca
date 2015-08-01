package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;


public class CheckOutMovieOperationTest {

    @Test
    public void shouldCallCheckOutOfBookLibrary() {
        BookLibrary mockBookLibrary = mock(BookLibrary.class);
        CheckOutMovieOperation checkOutMovieOperation = new CheckOutMovieOperation("CheckOut", mockBookLibrary);
        View mockView = mock(View.class);

        when(mockView.readUserInput()).thenReturn("book");
        checkOutMovieOperation.execute(mockView);

        verify(mockBookLibrary).checkOutItem("book");
    }
}
