package com.twu.biblioteca;

import com.twu.biblioteca.operations.ReturnItemOperation;
import com.twu.biblioteca.view.View;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ReturnItemOperationTest {

    @Test
    public void shouldReturnABook() {
        LibrarySection mockLibrarySection = mock(LibrarySection.class);
        ReturnItemOperation returnItemOperation = new ReturnItemOperation(mockLibrarySection);
        View mockView = mock(View.class);

        when(mockView.readUserInput()).thenReturn("book");
        returnItemOperation.execute(mockView);

        verify(mockLibrarySection).returnThisItem("book");
    }
}
