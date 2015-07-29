package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class InvalidMenuItemTest {

    @Test
    public void shouldCallViewPrintToConsole() {
        View mockView = mock(View.class);
        InvalidMenuItem invalidMenuItem = new InvalidMenuItem();

        invalidMenuItem.execute(mockView);

        verify(mockView).printToConsole("Select a valid option!");
    }
}
