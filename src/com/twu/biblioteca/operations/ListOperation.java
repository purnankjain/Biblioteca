package com.twu.biblioteca.operations;

import com.twu.biblioteca.IUser;
import com.twu.biblioteca.LibrarySection;
import com.twu.biblioteca.view.IView;
import com.twu.biblioteca.view.LibrarianMenuView;
import com.twu.biblioteca.NextViewHandler;
import com.twu.biblioteca.view.View;

import java.util.ArrayList;


public class ListOperation implements Operation {
    LibrarySection librarySection;

    public ListOperation(LibrarySection librarySection) {
        this.librarySection = librarySection;
    }

    @Override
    public void execute(View view) {
        view.printToConsole(listItems());
    }

    @Override
    public IView nextView(LibrarianMenuView librarianMenuView) {
        return null;
    }

    @Override
    public IView nextView(NextViewHandler nextViewHandler, IUser user) {
        return nextViewHandler.nextViewOnSelection(this);
    }

    public String listItems() {
        ArrayList<String> arrayList = librarySection.getAllItems();
        String formattedOutput = "";
        for(String eachItemDetail : arrayList) {
            formattedOutput += eachItemDetail + "\n";
        }
        return formattedOutput;
    }
}
