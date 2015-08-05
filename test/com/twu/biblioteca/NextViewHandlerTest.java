package com.twu.biblioteca;

import com.twu.biblioteca.view.NextViewHandler;
import com.twu.biblioteca.view.NullUserView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NextViewHandlerTest {

    NullUser nullUser;
    NextViewHandler nextViewHandler;

    @Before
    public void initialise() {
        nextViewHandler = new NextViewHandler(null, null, null, null, new NullUserView(), null , null);
    }

    @Test
    public void shouldReturnNullUserView() {
        assertEquals(NullUserView.class, nextViewHandler.nextViewAfterLogin(nullUser).getClass());
    }
}
