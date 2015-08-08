package com.twu.biblioteca.model;


import com.twu.biblioteca.user.User;

public class Book implements Item{
    private String name;
    private String author;
    private int publishYear;

    public Book(String name, String author, int publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }

    @Override
    public boolean isTitled(String nameToCheck) {
        return (name.equals(nameToCheck));
    }

    @Override
    public String toString() {
        return String.format("%25s %25s %6s",name, author, publishYear);
    }

    @Override
    public void assignTo(User user) {
        user.addBookToUserBookList(this);
    }

    @Override
    public void recoverFrom(User user) {
        user.removeFromUserBookList(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (publishYear != book.publishYear) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        return !(author != null ? !author.equals(book.author) : book.author != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + publishYear;
        return result;
    }
}
