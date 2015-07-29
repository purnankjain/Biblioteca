package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ViewTest {

    private ByteArrayOutputStream outContent;
    private PrintStream original;
    private View view;

    @Before
    public void setUpstream() {
        view =  new View();
        original = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void clearStream() {
        System.setOut(original);
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

        assertEquals(toPrint, outContent.toString());
    }
}
