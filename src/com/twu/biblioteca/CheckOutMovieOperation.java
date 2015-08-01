package com.twu.biblioteca;


public class CheckOutMovieOperation implements Operation{

    private String name;
    private MovieLibrary movieLibrary;

    public CheckOutMovieOperation(String name, MovieLibrary movieLibrary) {
        this.name = name;
        this.movieLibrary = movieLibrary;
    }

    @Override
    public boolean execute(View view) {
        view.printToConsole("Enter Movie to CheckOut : ");
        view.printToConsole(movieLibrary.checkOutItem(view.readUserInput()));
        return true;
    }

    @Override
    public boolean nameEquals(String toCheck) {
        return name.equals(toCheck);
    }

    @Override
    public String getName() {
        return null;
    }
}
