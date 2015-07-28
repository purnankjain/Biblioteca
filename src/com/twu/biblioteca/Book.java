package com.twu.biblioteca;

public class Book {
    String name;
    String author;
    int publishYear;

    public Book(String name, String author, int publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }

    public boolean isTitled(String nameToCheck) {
        return (name.equals(nameToCheck));
    }

    @Override
    public String toString() {
        return name + ", " + author + ", " + publishYear;
    }
}
