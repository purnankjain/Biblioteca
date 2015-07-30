package com.twu.biblioteca;

public class Book implements ListItem{
    private String name;
    private String author;
    private int publishYear;
    boolean isCheckedOut;

    public Book(String name, String author, int publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.isCheckedOut = false;
    }

    public boolean isTitled(String nameToCheck) {
        return (name.equals(nameToCheck));
    }

    @Override
    public boolean checkOutThis() {
        if(!isCheckedOut) {
            isCheckedOut = true;
            return true;
        }
        return false;
    }

    public boolean returnThis() {
        if(isCheckedOut) {
            isCheckedOut = false;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + ", " + author + ", " + publishYear;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        if (!super.equals(otherObject)) return false;
        Book otherBook = (Book) otherObject;
        if (publishYear != otherBook.publishYear) return false;
        return !(author != null ? !author.equals(otherBook.author) : otherBook.author != null);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + publishYear;
        return result;
    }
}
