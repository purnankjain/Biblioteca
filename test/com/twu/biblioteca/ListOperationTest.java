package com.twu.biblioteca;

import com.twu.biblioteca.operations.ListOperation;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class ListOperationTest {

    LibrarySection mockLibrarySection;
    ListOperation listOperation;
    ArrayList<String> allBookDetails;

    @Before
    public void initialise() {
        mockLibrarySection = mock(LibrarySection.class);
        listOperation = new ListOperation(mockLibrarySection);
        allBookDetails = new ArrayList<String>();
        allBookDetails.add("Book1");

    }

    @Test
    public void shouldReturnBookDetails() {

        when(mockLibrarySection.getAllItems()).thenReturn(allBookDetails);

        assertEquals("Book1\n", listOperation.listItems());
    }
}
