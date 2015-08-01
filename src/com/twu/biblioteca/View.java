package com.twu.biblioteca;

import java.io.BufferedReader;


public class View {
    BufferedReader bufferedReader;

    public View(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void greetUser() {
        System.out.println("--WELCOME TO BIBLIOTECA--");
    }

    public void printBookNamesToConsole(String bookList) {
        System.out.println(String.format("%25s %25s %6s", "Title", "Author", "Year"));
        System.out.println(String.format("%25s %25s %6s", "-----", "------", "----"));
        System.out.print(bookList);
    }

    public void printMovieToConsole(String movieList) {
        System.out.println(String.format("%25s %6s %25s %10s", "Title", "Year", "Director", "Rating"));
        System.out.println(String.format("%25s %6s %25s %10s", "-----", "----", "--------", "------"));
        System.out.println(movieList);
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
