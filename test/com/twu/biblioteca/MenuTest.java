package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MenuTest {

    Menu menu;
    View mockView;

    @Before
    public void initialise() {
        mockView = mock(View.class);
        menu = new Menu();
    }

    @Test
    public void shouldCallPrintOfView() {
        menu.renderMenu(mockView);
        verify(mockView, atLeastOnce()).printToConsole("===========================");
        verify(mockView, times(1)).printToConsole("Book List");
    }
}
