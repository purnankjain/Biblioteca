package com.twu.biblioteca;

import java.io.BufferedReader;
import java.util.ArrayList;


public class View {
    BufferedReader bufferedReader;

    public View(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void greetUser() {
        System.out.println("--WELCOME TO BIBLIOTECA--");
    }

    public void printBookNamesToConsole(ArrayList<String> bookList) {
        bookList.add(String.format("%30s %30s %6s", "Title", "Author", "Year"));
        bookList.add(String.format("%30s %30s %6s", "-----", "------", "----"));
        System.out.print(bookList);
    }

    public void printToConsole(Object toPrint) {
        System.out.println(toPrint);
    }

    public String readUserInput() {
        try {
            return bufferedReader.readLine();
        }
        catch (Exception e) {

        }
        return null;
    }
}
