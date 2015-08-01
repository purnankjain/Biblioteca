package com.twu.biblioteca;


public interface Operation {
    boolean execute(View view);
    boolean nameEquals(String toCheck);
    String getName();
}
