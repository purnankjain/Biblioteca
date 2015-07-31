package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;


public class CheckOutOptionTest {

    @Test
    public void shouldCallCheckOutOfBookLibrary() {
        BookLibrary mockBookLibrary = mock(BookLibrary.class);
        CheckOutOption checkOutOption = new CheckOutOption("CheckOut", mockBookLibrary);
        View mockView = mock(View.class);

        when(mockView.readUserInput()).thenReturn("book");
        checkOutOption.execute(mockView);

        verify(mockBookLibrary).checkOutItem("book");
    }
}
