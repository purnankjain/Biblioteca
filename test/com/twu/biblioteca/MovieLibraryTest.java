package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MovieLibraryTest {

    @Test
    public void shouldReturnListOfAllAvailableBooks() {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Harry", 2001, "yap", "3"));
        MovieLibrary movieLibrary = new MovieLibrary(movies, new ArrayList<Movie>());
        movies.add(new Movie("Harry", 2001, "yap", "3"));

        assertEquals(movies, movieLibrary.listAllAvailableMovies());
    }
}
