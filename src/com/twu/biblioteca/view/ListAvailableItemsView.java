package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.LibrarySection;
import com.twu.biblioteca.user.User;

import java.util.ArrayList;

public class ListAvailableItemsView implements IView {

    LibrarySection librarySection;

    public ListAvailableItemsView(LibrarySection librarySection) {
        this.librarySection = librarySection;
    }

    @Override
    public IView renderView(Controller controller, User user) {
        ArrayList<String> list = librarySection.getAllAvailableItems();
        for(String str : list) {
            System.out.println(str);
        }
        return controller.menuView(user);
    }
}
