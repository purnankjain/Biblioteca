package com.twu.biblioteca;


public class CheckOutMovieOperation implements Operation{

    private MovieLibrary movieLibrary;

    public CheckOutMovieOperation(MovieLibrary movieLibrary) {
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
        return false;
    }

    @Override
    public String getName() {
        return null;
    }
}
