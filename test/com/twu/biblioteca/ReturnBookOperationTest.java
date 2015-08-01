package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ReturnBookOperationTest {

    @Test
    public void shouldReturnABook() {
        BookLibrary mockBookLibrary = mock(BookLibrary.class);
        ReturnBookOperation returnBookOperation = new ReturnBookOperation("Return Book", mockBookLibrary);
        View mockView = mock(View.class);

        when(mockView.readUserInput()).thenReturn("book");
        returnBookOperation.execute(mockView);

        verify(mockBookLibrary).returnThisItem("book");
    }
}
