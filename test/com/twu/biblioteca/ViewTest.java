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

    @Before
    public void setUpstream() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void clearStream() {
        System.setOut(null);
    }

    @Test
    public void shouldGreetUserWithWelcomeMessage() {
        View view =  new View();
        view.greetUser();

        assertEquals("--WELCOME TO BIBLIOTECA--", outContent.toString());
    }

    @Test
    public void shouldPrintAllBookNames() {
        View view =  new View();
        ArrayList<String> bookList = new ArrayList<String>();
        bookList.add("The Alchemist");
        bookList.add("Harry Potter And the Half Blood Prince");
        bookList.add("White Tiger");

        view.printBookNamesToConsole(bookList);

        assertEquals(bookList, outContent.toString());
    }
}
