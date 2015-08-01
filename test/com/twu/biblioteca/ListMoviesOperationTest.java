package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListMoviesOperationTest {

    @Test
    public void shouldKnowItsName() {
        ListMoviesOperation listMoviesOperation = new ListMoviesOperation("List Movies", new MovieLibrary(new ArrayList<Movie>(), new ArrayList<Movie>()));

        assertEquals(true, listMoviesOperation.nameEquals("List Movies"));
    }

    @Test
    public void shouldReturnAllMovieDetails() {
        ArrayList<String> returnedList = new ArrayList<>();
        returnedList.add("Movie");
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        ListMoviesOperation listMoviesOperation = new ListMoviesOperation("List Movies", movieLibrary);

        when(movieLibrary.listAllAvailableMovies()).thenReturn(returnedList);

        assertEquals("Movie\n", listMoviesOperation.listMovies());
    }
}
