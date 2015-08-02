package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operations.ReturnItemOperation;
import com.twu.biblioteca.view.View;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ReturnItemOperationTest {

    @Test
    public void shouldReturnABook() {
        Library mockLibrary = mock(Library.class);
        ReturnItemOperation returnItemOperation = new ReturnItemOperation(mockLibrary);
        View mockView = mock(View.class);

        when(mockView.readUserInput()).thenReturn("book");
        returnItemOperation.execute(mockView);

        verify(mockLibrary).returnThisItem("book");
    }
}
