package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class BibliotecaApplicationTest {

    BibliotecaApplication bibliotecaApplication;
    View mockView;
    Menu mockMenu;

    @Before
    public void initialise() {
        mockView = mock(View.class);
        mockMenu = mock(Menu.class);
        bibliotecaApplication = new BibliotecaApplication(mockView, mockMenu);
    }

    @Test
    public void shouldGreetUser() {
        bibliotecaApplication.start();

        verify(mockView, times(1)).greetUser();
    }

    @Test
    public void shouldInvokeMenuRender() {
        bibliotecaApplication.start();

        verify(mockMenu).renderMenu(mockView);
    }
}
