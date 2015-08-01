package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {
    private String section;
    private ArrayList<Item> availableItems;
    private ArrayList<Item> unAvailableItems;

    public Library(String section, ArrayList<Item> availableItems, ArrayList<Item> unAvailableItems) {
        this.section = section;
        this.availableItems = availableItems;
        this.unAvailableItems = unAvailableItems;
    }

    public ArrayList<String> getAllItems() {
        ArrayList<String> tempList = new ArrayList<String>();
        for(Item item : availableItems) {
            tempList.add(item.toString());
        }
        return tempList;
    }

    public String checkOutItem(String item) {
        for(Item item1 : availableItems) {
            if(item1.isTitled(item)) {
                swapItem(item1, availableItems, unAvailableItems);
                return "Thank you! Enjoy the " + section + ".";
            }
        }
        return "That " + section + " is not available.";
    }

    public String returnThisItem(String item) {
        for(Item item1 : unAvailableItems) {
            if(item1.isTitled(item)) {
                swapItem(item1, unAvailableItems, availableItems);
                return "Thank you for returning the " + section + ".";
            }
        }
        return "That is not a valid " + section + " to return.";
    }

    private void swapItem(Item item, ArrayList<Item> fromThis, ArrayList<Item> toThis) {
        fromThis.remove(item);
        toThis.add(item);
    }
}
