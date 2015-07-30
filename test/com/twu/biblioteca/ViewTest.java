package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ViewTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;
    private View view;
    private InputStream originalIn;
    private String toCheck;

    @Before
    public void setUpstream() {
        toCheck = "Hello";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(toCheck.getBytes());
        view =  new View(new BufferedReader(new InputStreamReader(byteArrayInputStream)));
        originalOut = System.out;
        originalIn = System.in;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void clearStream() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldGreetUserWithWelcomeMessage() {
        view.greetUser();

        assertEquals("--WELCOME TO BIBLIOTECA--\n", outContent.toString());
    }

    @Test
    public void shouldPrintAllBookNames() {
        ArrayList<String> bookList = new ArrayList<String>();
        bookList.add("The Alchemist");
        bookList.add("Harry Potter And the Half Blood Prince");
        bookList.add("White Tiger");

        view.printBookNamesToConsole(bookList);

        assertEquals(bookList.toString(), outContent.toString());
    }

    @Test
    public void shouldPassCorrectContentToPrint() {
        String toPrint = "Hello World";

        view.printToConsole(toPrint);

        assertEquals(toPrint + "\n", outContent.toString());
    }

    @Test
    public void shouldReturnUserInput() {
        String userInput = view.readUserInput();

        assertEquals(toCheck, userInput);
    }
}
