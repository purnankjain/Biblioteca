package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ReturnItemOperationTest {

    @Test
    public void shouldReturnABook() {
        Library mockLibrary = mock(Library.class);
        ReturnItemOperation returnItemOperation = new ReturnItemOperation("Return Book", mockLibrary);
        View mockView = mock(View.class);

        when(mockView.readUserInput()).thenReturn("book");
        returnItemOperation.execute(mockView);

        verify(mockLibrary).returnThisItem("book");
    }
}
