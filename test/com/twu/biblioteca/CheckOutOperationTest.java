package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;


public class CheckOutOperationTest {

    @Test
    public void shouldCallCheckOutOfBookLibrary() {
        BookLibrary mockBookLibrary = mock(BookLibrary.class);
        CheckOutOperation checkOutOperation = new CheckOutOperation("CheckOut", mockBookLibrary);
        View mockView = mock(View.class);

        when(mockView.readUserInput()).thenReturn("book");
        checkOutOperation.execute(mockView);

        verify(mockBookLibrary).checkOutItem("book");
    }
}
