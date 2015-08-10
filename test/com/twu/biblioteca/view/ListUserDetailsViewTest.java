package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.user.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListUserDetailsViewTest {

    ListUserDetailsView listUserDetailsView;

    @Test
    public void shouldExecute() {
        User mockUser = mock(User.class);
        Controller mockController = mock(Controller.class);
        listUserDetailsView = new ListUserDetailsView("");
        InputView mockInputView = mock(InputView.class);
        LibrarianMenuView librarianMenuView = new LibrarianMenuView(mockInputView);

        when(mockController.menuView(mockUser)).thenReturn(librarianMenuView);

        assertEquals(LibrarianMenuView.class, listUserDetailsView.renderView(mockController, mockUser).getClass());
    }
}
