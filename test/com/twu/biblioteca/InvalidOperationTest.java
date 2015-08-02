package com.twu.biblioteca;

import com.twu.biblioteca.operations.InvalidOperation;
import com.twu.biblioteca.view.View;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class InvalidOperationTest {

    @Test
    public void shouldCallViewPrintToConsole() {
        View mockView = mock(View.class);
        InvalidOperation invalidMenuOption = new InvalidOperation();

        invalidMenuOption.execute(mockView);

        verify(mockView).printToConsole("Select a valid option!");
    }
}
