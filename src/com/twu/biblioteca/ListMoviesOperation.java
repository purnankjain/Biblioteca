package com.twu.biblioteca;

public class ListMoviesOperation implements Operation {
    private String name;
    private MovieLibrary movieLibrary;

    public ListMoviesOperation(String name, MovieLibrary movieLibrary) {
        this.name = name;
        this.movieLibrary = movieLibrary;
    }

    @Override
    public boolean execute(View view) {
        return false;
    }

    @Override
    public boolean nameEquals(String toCheck) {
        return name.equals(toCheck);
    }
}
