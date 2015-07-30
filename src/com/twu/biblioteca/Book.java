package com.twu.biblioteca;

public class Book extends ListItem{
    String author;
    int publishYear;
    boolean isCheckedOut;

    public Book(int id, String name, String author, int publishYear) {
        super(id, name);
        this.author = author;
        this.publishYear = publishYear;
        isCheckedOut = false;
    }

    public boolean isTitled(String nameToCheck) {
        return (name.equals(nameToCheck));
    }

    public boolean checkout() {
        if(!isCheckedOut) {
            isCheckedOut = true;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + ", " + author + ", " + publishYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Book book = (Book) o;

        if (publishYear != book.publishYear) return false;
        return !(author != null ? !author.equals(book.author) : book.author != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + publishYear;
        return result;
    }
}
