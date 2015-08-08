package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.user.User;

public class ListUserDetails implements IView{
    String userDetailMessage;

    public ListUserDetails(String userDetailMessage) {
        this.userDetailMessage = userDetailMessage;
    }

    @Override
    public IView renderView(Controller controller, User user) {
        System.out.println(userDetailMessage);
        System.out.println(user.toString());
        return user.menuView(controller);
    }
}
