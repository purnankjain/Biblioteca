package com.twu.biblioteca;

import com.twu.biblioteca.operations.ReturnItemOperation;
import com.twu.biblioteca.view.View;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class ReturnItemOperationTest {

    ConfirmationHandler confirmationHandler;

    @Before
    public void initialise() {
        confirmationHandler = mock(ConfirmationHandler.class);
    }

    @Test
    public void shouldReturnABook() {
        LibrarySection mockLibrarySection = mock(LibrarySection.class);
        ReturnItemOperation returnItemOperation = new ReturnItemOperation("", mockLibrarySection, confirmationHandler);
        View mockView = mock(View.class);

        when(mockView.readUserInput()).thenReturn("Book");
        when(mockLibrarySection.returnThisItem("Book")).thenReturn(true);
        returnItemOperation.execute(mockView);

        verify(confirmationHandler).validateReturn("", true);
    }
}
