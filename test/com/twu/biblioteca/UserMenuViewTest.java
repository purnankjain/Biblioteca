package com.twu.biblioteca;

import com.twu.biblioteca.operations.ListOperation;
import com.twu.biblioteca.parser.Parser;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.view.InputView;
import com.twu.biblioteca.view.ListAvailableItemsView;
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
    Controller nextViewHandler;
    ListOperation listOperation;
    User user;
    ListAvailableItemsView listAvailableItemsView;

    @Before
    public void initialise() {
        inputView = mock(InputView.class);
        parser = mock(Parser.class);
        listAvailableItemsView = new ListAvailableItemsView();
        listOperation = mock(ListOperation.class);
        nextViewHandler = mock(Controller.class);
        userMenuView = new UserMenuView(inputView, parser, nextViewHandler);
    }

    @Test
    public void shouldReturnNextView() {
        when(inputView.readInput()).thenReturn("List Books");
        when(parser.selectOperation("List Books")).thenReturn(listOperation);
        when(listOperation.nextView(nextViewHandler, user)).thenReturn(listAvailableItemsView);

        assertEquals(ListAvailableItemsView.class, userMenuView.renderView(user).getClass());
    }
}
