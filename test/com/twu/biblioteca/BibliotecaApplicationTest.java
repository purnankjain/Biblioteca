package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;


public class BibliotecaApplicationTest {

    BibliotecaApplication bibliotecaApplication;
    @Test
    public void shouldGreetUser() {
        View mockView = mock(View.class);
        bibliotecaApplication = new BibliotecaApplication(mockView);
        bibliotecaApplication.start();
        verify(mockView, times(1)).greetUser();
    }
}
