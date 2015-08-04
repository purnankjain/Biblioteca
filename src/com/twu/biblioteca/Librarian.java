package com.twu.biblioteca;

public class Librarian {

    String id;
    String password;

    public Librarian(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public boolean hasCredentials(String thatId, String thatPassword) {
        return (id.equals(thatId) && password.equals(thatPassword));
    }
}
