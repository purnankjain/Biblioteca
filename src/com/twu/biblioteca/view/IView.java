package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.user.User;

public interface IView {
    IView renderView(Controller controller, User user);
}
