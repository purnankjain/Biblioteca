package com.twu.biblioteca;

import java.util.ArrayList;


public class ListOperation implements Operation {
    String name;
    Library library;

    public ListOperation(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    @Override
    public boolean execute(View view) {
        view.printToConsole(listItems());
        return true;
    }

    @Override
    public boolean nameEquals(String toCheck) {
        return name.equals(toCheck);
    }

    public String listItems() {
        ArrayList<String> arrayList = library.getAllItems();
        String formattedOutput = "";
        for(String eachItemDetail : arrayList) {
            formattedOutput += eachItemDetail + "\n";
        }
        return formattedOutput;
    }

    public String getName() {
        return name;
    }
}
