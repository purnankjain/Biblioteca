package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class CheckOutMovieOperationTest {

    View mockView;
    CheckOutMovieOperation checkOutMovieOperation;
    MovieLibrary mockMovieLibrary = mock(MovieLibrary.class);

    @Before
    public void initialise() {
        mockView = mock(View.class);
        checkOutMovieOperation = new CheckOutMovieOperation(mockMovieLibrary);
    }

    @Test
    public void shouldCheckOutAMovieWhichUserInputs() {

        when(mockView.readUserInput()).thenReturn("Harry");
        checkOutMovieOperation.execute(mockView);

        verify(mockMovieLibrary).checkOutItem("Harry");
    }
}
