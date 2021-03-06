package com.twu.biblioteca;

import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.user.User;

import java.util.ArrayList;
import java.util.HashMap;


public class LibrarySection {
    private ArrayList<Item> availableItems;
    private ArrayList<Item> unAvailableItems;
    private HashMap<String, String> itemOwner;

    public LibrarySection(ArrayList<Item> availableItems, ArrayList<Item> unAvailableItems, HashMap<String, String> itemOwner) {
        this.availableItems = availableItems;
        this.unAvailableItems = unAvailableItems;
        this.itemOwner = itemOwner;
    }

    public ArrayList<String> getAllAvailableItems() {
        ArrayList<String> tempList = new ArrayList<String>();
        for(Item item : availableItems) {
            tempList.add(item.toString());
        }
        return tempList;
    }

    public ArrayList<String> getAllCheckedOutItemsWithOwnerDetails() {
        ArrayList<String> tempList = new ArrayList<String>();
        for(Item item : unAvailableItems) {
            tempList.add(item.toString() + "  Owner : " + itemOwner.get(item.toString()));
        }
        return tempList;
    }

    public boolean checkOutItem(String thatItem, User user) {
        for(Item item : availableItems) {
            if(item.isTitled(thatItem)) {
                swapItem(item, availableItems, unAvailableItems);
                item.assignTo(user);
                addToItemOwner(user, item);
                return true;
            }
        }
        return false;
    }

    private void addToItemOwner(User user, Item item) {
        itemOwner.put(item.toString(), user.toString());
    }

    public boolean returnThisItem(String thatItem, User user) {
        for(Item item : unAvailableItems) {
            if(item.isTitled(thatItem)) {
                if(item.isWithUser(user)) {
                    swapItem(item, unAvailableItems, availableItems);
                    item.recoverFrom(user);
                    removeFromItemOwner(item);
                    return true;
                }
            }
        }
        return false;
    }

    private void removeFromItemOwner(Item item) {
        itemOwner.remove(item.toString());
    }

    private void swapItem(Item item, ArrayList<Item> fromThis, ArrayList<Item> toThis) {
        fromThis.remove(item);
        toThis.add(item);
    }
}
