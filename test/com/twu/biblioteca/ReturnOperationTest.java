package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ReturnOperationTest {

    @Test
    public void shouldReturnABook() {
        BookLibrary mockBookLibrary = mock(BookLibrary.class);
        ReturnOperation returnOperation = new ReturnOperation("Return Book", mockBookLibrary);
        View mockView = mock(View.class);

        when(mockView.readUserInput()).thenReturn("book");
        returnOperation.execute(mockView);

        verify(mockBookLibrary).returnThisItem("book");
    }
}
