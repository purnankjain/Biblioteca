package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.LibrarySection;
import com.twu.biblioteca.user.User;

public class ListUnavailableItemsView implements IView {

    LibrarySection librarySection;

    public ListUnavailableItemsView(LibrarySection librarySection) {
        this.librarySection = librarySection;
    }

    @Override
    public IView renderView(Controller controller, User user) {
        return null;
    }
}

