package com.twu.biblioteca;

import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.user.User;

import java.util.ArrayList;


public class LibrarySection {
    private ArrayList<Item> availableItems;
    private ArrayList<Item> unAvailableItems;

    public LibrarySection(ArrayList<Item> availableItems, ArrayList<Item> unAvailableItems) {
        this.availableItems = availableItems;
        this.unAvailableItems = unAvailableItems;
    }

    public ArrayList<String> getAllAvailableItems() {
        ArrayList<String> tempList = new ArrayList<String>();
        for(Item item : availableItems) {
            tempList.add(item.toString());
        }
        return tempList;
    }

    public ArrayList<String> getAllCheckedOutItems() {
        ArrayList<String> tempList = new ArrayList<String>();
        for(Item item : unAvailableItems) {
            tempList.add(item.toString());
        }
        return tempList;
    }

    public boolean checkOutItem(String thatItem, User user) {
        for(Item item : availableItems) {
            if(item.isTitled(thatItem)) {
                swapItem(item, availableItems, unAvailableItems);
                item.assignTo(user);
                return true;
            }
        }
        return false;
    }

    public boolean returnThisItem(String item) {
        for(Item item1 : unAvailableItems) {
            if(item1.isTitled(item)) {
                swapItem(item1, unAvailableItems, availableItems);
                return true;
            }
        }
        return false;
    }

    private void swapItem(Item item, ArrayList<Item> fromThis, ArrayList<Item> toThis) {
        fromThis.remove(item);
        toThis.add(item);
    }
}
