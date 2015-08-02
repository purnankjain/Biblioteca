package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operations.CheckOutOperation;
import com.twu.biblioteca.view.View;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class CheckOutOperationTest {

    @Test
    public void shouldCallCheckOutOfBookLibrary() {
        Library mockLibrary = mock(Library.class);
        CheckOutOperation checkOutOperation = new CheckOutOperation(mockLibrary);
        View mockView = mock(View.class);

        when(mockView.readUserInput()).thenReturn("book");
        checkOutOperation.execute(mockView);

        verify(mockLibrary).checkOutItem("book");
    }
}
