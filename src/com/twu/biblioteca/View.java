package com.twu.biblioteca;

import java.util.ArrayList;


public class View {

    public void greetUser() {
        System.out.println("--WELCOME TO BIBLIOTECA--");
    }

    public void printBookNamesToConsole(ArrayList<String> bookList) {
        System.out.print(bookList);
    }

    public void printToConsole(String toPrint) {
        System.out.print(toPrint);
    }
}
