package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.LibrarySection;
import com.twu.biblioteca.user.User;

import java.util.ArrayList;

public class ListUnavailableItemsView implements IView {

    LibrarySection librarySection;
    String message;

    public ListUnavailableItemsView(LibrarySection librarySection, String message) {
        this.librarySection = librarySection;
        this.message = message;
    }

    @Override
    public IView renderView(Controller controller, User user) {
        System.out.println(message);
        ArrayList<String> list = librarySection.getAllCheckedOutItemsWithOwnerDetails();
        for(String str : list) {
            System.out.println(str);
        }
        return controller.menuView(user);
    }
}

