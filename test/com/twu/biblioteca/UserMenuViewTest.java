package com.twu.biblioteca;

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
    Controller controller;
    User user;
    ListAvailableItemsView listAvailableItemsView;

    @Before
    public void initialise() {
        inputView = mock(InputView.class);
        listAvailableItemsView = new ListAvailableItemsView(null);
        controller = mock(Controller.class);
        userMenuView = new UserMenuView(inputView);
    }

    @Test
    public void shouldReturnNextView() {
        when(inputView.readInput()).thenReturn("List Books");
        when(controller.selectOperationView("List Books")).thenReturn(listAvailableItemsView);

        assertEquals(ListAvailableItemsView.class, userMenuView.renderView(controller, user).getClass());
    }
}
