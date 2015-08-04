package com.twu.biblioteca.view;

import java.io.BufferedReader;

public class InputView {

    BufferedReader bufferedReader;

    public InputView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String readInput() {
        try {
            return bufferedReader.readLine();
        }
        catch(Exception e) {

        }
        return "";
    }


}
