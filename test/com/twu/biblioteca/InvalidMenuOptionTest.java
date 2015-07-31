package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;


public class InvalidMenuOptionTest {

    @Test
    public void shouldCallViewPrintToConsole() {
        View mockView = mock(View.class);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption();

        invalidMenuOption.execute(mockView);

        verify(mockView).printToConsole("Select a valid option!");
    }
}
