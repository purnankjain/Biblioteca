package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

        assertEquals("--WELCOME TO BIBLIOTECA--\n", outContent.toString());
    }
}
