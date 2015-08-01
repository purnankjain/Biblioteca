package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class CheckOutMovieOperationTest {

    View mockView;
    CheckOutMovieOperation checkOutMovieOperation;
    MovieLibrary mockMovieLibrary = mock(MovieLibrary.class);

    @Before
    public void initialise() {
        mockView = mock(View.class);
        checkOutMovieOperation = new CheckOutMovieOperation("Name", mockMovieLibrary);
    }

    @Test
    public void shouldCheckOutAMovieWhichUserInputs() {

        when(mockView.readUserInput()).thenReturn("Harry");
        checkOutMovieOperation.execute(mockView);

        verify(mockMovieLibrary).checkOutItem("Harry");
    }

    @Test
    public void shouldKnowItsName() {

        assertEquals(true, checkOutMovieOperation.nameEquals("Name"));
    }

    @Test
    public void shouldGetItsName() {
        assertEquals("Name", checkOutMovieOperation.getName());
    }
}
