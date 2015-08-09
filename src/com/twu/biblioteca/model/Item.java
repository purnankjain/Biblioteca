package com.twu.biblioteca.model;


import com.twu.biblioteca.user.User;

public interface Item {
    boolean isTitled(String toCheck);
    String toString();
    void assignTo(User user);
    void recoverFrom(User user);

    boolean isWithUser(User user);
}
