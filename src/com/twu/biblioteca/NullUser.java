package com.twu.biblioteca;

public class NullUser implements IUser{

    @Override
    public boolean hasCredentials(String thatId, String thatPassword) {
        return false;
    }
}
