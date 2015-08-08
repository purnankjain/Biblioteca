package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.user.User;

public class UserMenuView implements IView {

    InputView inputView;

    public UserMenuView(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public IView renderView(Controller controller, User user) {
        printUserMenu();
        String input = inputView.readInput();
        return controller.selectOperationView(input);
    }

    private void printUserMenu() {
        System.out.println("==========USER=============");
        System.out.println("List Books");
        System.out.println("List Movies");
        System.out.println("CheckOut Book");
        System.out.println("CheckOut Movie");
        System.out.println("Return Book");
        System.out.println("Return Movie");
        System.out.println("Logout");
        System.out.println("Quit");
        System.out.println("=======================");
        System.out.println("Enter Choice : ");
    }
}
