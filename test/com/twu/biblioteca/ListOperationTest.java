package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class ListOperationTest {

    @Test
    public void shouldReturnBookDetails() {
        Library mockLibrary = mock(Library.class);
        ListOperation listOperation = new ListOperation("List Books", mockLibrary);
        ArrayList<String> allBookDetails = new ArrayList<String>();
        allBookDetails.add("Book1");

        when(mockLibrary.getAllItems()).thenReturn(allBookDetails);

        assertEquals("Book1\n", listOperation.listItems());
    }

    @Test
    public void shouldReturnOperationName() {
        Library mockLibrary = mock(Library.class);
        ListOperation listOperation = new ListOperation("List Books", mockLibrary);
        ArrayList<String> allBookDetails = new ArrayList<String>();
        allBookDetails.add("Book1");

        assertEquals("List Books", listOperation.getName());
    }
}
