package com.twu.biblioteca;

public class Librarian implements IUser{

    String libraryNumber;
    String password;

    public Librarian(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean hasCredentials(String thatId, String thatPassword) {
        return (libraryNumber.equals(thatId) && password.equals(thatPassword));
    }
}
