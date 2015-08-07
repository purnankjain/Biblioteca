package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.LibrarySection;
import com.twu.biblioteca.user.User;

public class ReturnItemView implements IView {

    LibrarySection librarySection;
    InputView inputView;
    String successMessage;
    String unsuccessfulMessage;

    public ReturnItemView(LibrarySection librarySection, InputView inputView, String successMessage, String unsuccessfulMessage) {
        this.librarySection = librarySection;
        this.inputView = inputView;
        this.successMessage = successMessage;
        this.unsuccessfulMessage = unsuccessfulMessage;
    }

    @Override
    public IView renderView(Controller controller, User user) {
        String itemName = inputView.readInput();
        if(librarySection.returnThisItem(itemName)) {
            System.out.println(successMessage);
        }
        else {
            System.out.println(unsuccessfulMessage);
        }
        return controller.nextViewAfterLogin(user);
    }
}
