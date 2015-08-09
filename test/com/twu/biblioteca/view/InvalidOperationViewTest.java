package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.user.User;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class InvalidOperationViewTest {

    InvalidOperationView invalidOperationView;

    @Test
    public void shouldExecute() {
        User mockUser = mock(User.class);
        invalidOperationView = new InvalidOperationView("Invalid");
        Controller mockController = mock(Controller.class);

        invalidOperationView.renderView(mockController, mockUser);

        verify(mockUser).nextViewOnInvalidSelection(mockController);
    }
}
