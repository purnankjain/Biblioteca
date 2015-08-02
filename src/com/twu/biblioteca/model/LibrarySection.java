package com.twu.biblioteca.model;

import java.util.ArrayList;


public class LibrarySection {
    private String sectionObject;
    private ArrayList<Item> availableItems;
    private ArrayList<Item> unAvailableItems;

    public LibrarySection(String sectionObject, ArrayList<Item> availableItems, ArrayList<Item> unAvailableItems) {
        this.sectionObject = sectionObject;
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
                return "Thank you! Enjoy the " + sectionObject + ".";
            }
        }
        return "That " + sectionObject + " is not available.";
    }

    public String returnThisItem(String item) {
        for(Item item1 : unAvailableItems) {
            if(item1.isTitled(item)) {
                swapItem(item1, unAvailableItems, availableItems);
                return "Thank you for returning the " + sectionObject + ".";
            }
        }
        return "That is not a valid " + sectionObject + " to return.";
    }

    private void swapItem(Item item, ArrayList<Item> fromThis, ArrayList<Item> toThis) {
        fromThis.remove(item);
        toThis.add(item);
    }
}
