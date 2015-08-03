package com.twu.biblioteca;

import com.twu.biblioteca.operations.CheckOutOperation;
import com.twu.biblioteca.view.View;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class CheckOutOperationTest {

    ConfirmationHandler confirmationHandler;

    @Before
    public void initialise() {
        confirmationHandler = mock(ConfirmationHandler.class);
    }

    @Test
    public void shouldCallCheckOutOfBookLibrary() {
        LibrarySection mockLibrarySection = mock(LibrarySection.class);
        CheckOutOperation checkOutOperation = new CheckOutOperation("", mockLibrarySection, confirmationHandler);
        View mockView = mock(View.class);

        when(mockView.readUserInput()).thenReturn("Book");
        when(mockLibrarySection.checkOutItem("Book")).thenReturn(true);
        checkOutOperation.execute(mockView);

        verify(confirmationHandler).validateCheckOut("", true);
    }
}
