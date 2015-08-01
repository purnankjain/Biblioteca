package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;


public class CheckOutOperationTest {

    @Test
    public void shouldCallCheckOutOfBookLibrary() {
        Library mockLibrary = mock(Library.class);
        CheckOutOperation checkOutOperation = new CheckOutOperation("CheckOut", mockLibrary);
        View mockView = mock(View.class);

        when(mockView.readUserInput()).thenReturn("book");
        checkOutOperation.execute(mockView);

        verify(mockLibrary).checkOutItem("book");
    }
}
