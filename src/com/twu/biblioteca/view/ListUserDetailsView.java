package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.user.User;

public class ListUserDetailsView implements IView{
    String userDetailMessage;

    public ListUserDetailsView(String userDetailMessage) {
        this.userDetailMessage = userDetailMessage;
    }

    @Override
    public IView renderView(Controller controller, User user) {
        System.out.println(userDetailMessage);
        System.out.println(user.toString());
        return controller.menuView(user);
    }
}
