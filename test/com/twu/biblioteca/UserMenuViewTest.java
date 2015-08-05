package com.twu.biblioteca;

import com.twu.biblioteca.operations.ListOperation;
import com.twu.biblioteca.parser.Parser;
import com.twu.biblioteca.view.InputView;
import com.twu.biblioteca.view.ListView;
import com.twu.biblioteca.view.UserMenuView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserMenuViewTest {

    UserMenuView userMenuView;
    InputView inputView;
    Parser parser;
    NextViewHandler nextViewHandler;
    ListOperation listOperation;
    User user;
    ListView listView;

    @Before
    public void initialise() {
        inputView = mock(InputView.class);
        parser = mock(Parser.class);
        listView = new ListView();
        listOperation = mock(ListOperation.class);
        nextViewHandler = mock(NextViewHandler.class);
        userMenuView = new UserMenuView(inputView, parser, nextViewHandler);
    }

    @Test
    public void shouldReturnNextView() {
        when(inputView.readInput()).thenReturn("List Books");
        when(parser.selectOperation("List Books")).thenReturn(listOperation);
        when(listOperation.nextView(nextViewHandler, user)).thenReturn(listView);

        assertEquals(ListView.class, userMenuView.renderView(user).getClass());
    }
}
