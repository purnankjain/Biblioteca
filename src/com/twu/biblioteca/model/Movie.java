package com.twu.biblioteca.model;


import com.twu.biblioteca.user.User;

public class Movie implements Item{
    private String title;
    private int year;
    private String director;
    private String rating;

    public Movie(String title, int year, String director, String rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public boolean isTitled(String toCheck) {
        return title.equals(toCheck);
    }

    @Override
    public String toString() {
        return String.format("%25s %6d %25s %10s", title, year, director, rating);
    }

    @Override
    public void assignTo(User user) {

    }

    @Override
    public void recoverFrom(User user) {

    }
}
