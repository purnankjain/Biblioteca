package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MovieLibraryTest {

    MovieLibrary movieLibrary;

    @Before
    public void initialise() {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Harry", 2001, "yap", "3"));
         movieLibrary = new MovieLibrary(movies, new ArrayList<Movie>());

    }

    @Test
    public void shouldReturnListOfAllAvailableBooks() {
        ArrayList<String> expectedMovies = new ArrayList<>();
        expectedMovies.add(String.format("%25s %6d %25s %10s", "Harry", 2001, "yap", "3"));

        assertEquals(expectedMovies, movieLibrary.listAllAvailableMovies());
    }

    @Test
    public void shouldCheckoutAnAvailableMovie() {

        assertEquals("Thank you! Enjoy the movie.", movieLibrary.checkOutItem("Harry"));
    }

    @Test
    public void shouldConfirmAnUnsuccessfulCheckout() {

        assertEquals("That movie is not available.", movieLibrary.checkOutItem("Dave"));
    }
}
