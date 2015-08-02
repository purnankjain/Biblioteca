package com.twu.biblioteca;

import com.twu.biblioteca.model.LibrarySection;
import com.twu.biblioteca.operations.CheckOutOperation;
import com.twu.biblioteca.view.View;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class CheckOutOperationTest {

    @Test
    public void shouldCallCheckOutOfBookLibrary() {
        LibrarySection mockLibrarySection = mock(LibrarySection.class);
        CheckOutOperation checkOutOperation = new CheckOutOperation(mockLibrarySection);
        View mockView = mock(View.class);

        when(mockView.readUserInput()).thenReturn("book");
        checkOutOperation.execute(mockView);

        verify(mockLibrarySection).checkOutItem("book");
    }
}
