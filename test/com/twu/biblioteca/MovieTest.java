package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void shouldKnowItsTitle() {
        Movie movie = new Movie("Name", 2011, "Director", "1");

        assertEquals(true, movie.isTitled("Name"));
    }
}
