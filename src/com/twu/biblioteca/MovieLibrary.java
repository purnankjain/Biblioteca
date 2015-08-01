package com.twu.biblioteca;

import java.util.ArrayList;


public class MovieLibrary {
    ArrayList<Movie> availableMovies;
    ArrayList<Movie> unAvailableMovies;

    public MovieLibrary(ArrayList<Movie> availableMovies, ArrayList<Movie> unAvailableMovies) {
        this.availableMovies = availableMovies;
        this.unAvailableMovies = unAvailableMovies;
    }

    public ArrayList<Movie> listAllAvailableMovies() {
        return availableMovies;
    }
}
