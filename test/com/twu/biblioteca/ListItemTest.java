package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListItemTest {

    ListItem listItem;

    @Before
    public void initialise() {
        listItem = new ListItem(1, "Harry");
    }

    @Test
    public void checkEquality() {
        ListItem otherListItem = new ListItem(1, "Harry");

        assertEquals(otherListItem, listItem);
    }
}
