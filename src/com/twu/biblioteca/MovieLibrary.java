package com.twu.biblioteca;

import java.util.ArrayList;


public class MovieLibrary {
    ArrayList<Movie> availableMovies;
    ArrayList<Movie> unAvailableMovies;

    public MovieLibrary(ArrayList<Movie> availableMovies, ArrayList<Movie> unAvailableMovies) {
        this.availableMovies = availableMovies;
        this.unAvailableMovies = unAvailableMovies;
    }

    public ArrayList<String> listAllAvailableMovies() {
        ArrayList<String> temp = new ArrayList<>();
        for (Movie movie : availableMovies) {
            temp.add(movie.toString());
        }
        return temp;
    }

    public String ckecoutItem(String item) {
        for(Movie movie : availableMovies) {
            if(movie.isTitled(item)) {
                swapMovie(movie, availableMovies, unAvailableMovies);
                return "Thank you! Enjoy the movie.";
            }
        }
        return null;
    }

    private void swapMovie(Movie movie, ArrayList<Movie> fromList, ArrayList<Movie> toList) {
        fromList.remove(movie);
        toList.add(movie);
    }
}
