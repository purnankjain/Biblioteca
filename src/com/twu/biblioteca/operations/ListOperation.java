package com.twu.biblioteca.operations;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

import java.util.ArrayList;


public class ListOperation implements Operation {
    Library library;

    public ListOperation(Library library) {
        this.library = library;
    }

    @Override
    public boolean execute(View view) {
        view.printToConsole(listItems());
        return true;
    }
    public String listItems() {
        ArrayList<String> arrayList = library.getAllItems();
        String formattedOutput = "";
        for(String eachItemDetail : arrayList) {
            formattedOutput += eachItemDetail + "\n";
        }
        return formattedOutput;
    }
}
