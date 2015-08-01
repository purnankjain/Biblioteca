package com.twu.biblioteca;

import java.util.ArrayList;

public class ListMoviesOperation implements Operation {
    private String name;
    private MovieLibrary movieLibrary;

    public ListMoviesOperation(String name, MovieLibrary movieLibrary) {
        this.name = name;
        this.movieLibrary = movieLibrary;
    }

    @Override
    public boolean execute(View view) {
        view.printMovieToConsole(listMovies());
        return true;
    }

    public String listMovies() {
        ArrayList<String> arrayList = movieLibrary.listAllAvailableMovies();
        String formattedOutput = "";
        for(String eachMovieDetail : arrayList) {
            formattedOutput += eachMovieDetail + "\n";
        }
        return formattedOutput;

    }

    @Override
    public boolean nameEquals(String toCheck) {
        return name.equals(toCheck);
    }

    public String getName() {
        return name;
    }
}
