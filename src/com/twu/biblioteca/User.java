package com.twu.biblioteca;

public class User {
    private String id;
    private String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public boolean hasCredentials(String thatId, String thatPassword) {
        return (id.equals(thatId) && password.equals(thatPassword));
    }
}
