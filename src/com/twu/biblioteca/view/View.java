package com.twu.biblioteca.view;

import java.io.BufferedReader;


public class View {
    BufferedReader bufferedReader;

    public View(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void greetUser() {
        System.out.println("--WELCOME TO BIBLIOTECA--");
    }

    public void printMenu() {
        String menu = "";
        menu += "=========================\n";
        menu += "          Menu\n";
        menu += "=========================\n";
        menu += "List Books\n";
        menu += "List Movies\n";
        menu += "CheckOut Book\n";
        menu += "CheckOut Movie\n";
        menu += "Return Book\n";
        menu += "Return Movie\n";
        menu += "Quit\n";
        menu += "=========================\n\n";
        menu += "Enter Choice : \n";
        printToConsole(menu);
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
