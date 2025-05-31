package org.java;

public class GroceryList {

    private String[] items;
    private int itemCount;
    private static final int MAX_ITEMS = 100;
    public GroceryList() {
        items = new String[MAX_ITEMS];
        itemCount = 0;
    }

    public void addItem(String item) {
        if (itemCount < MAX_ITEMS) {
            items[itemCount] = item;
            itemCount++;
        } else {
            System.out.println("grocery list is full");
        }
    }

    public void removeItem(String item) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].equals(item)) {
                items[i] = items[itemCount - 1];
                items[itemCount - 1] = null;
                itemCount--;
                return;
            }
        }
        System.out.println("item not found");
    }

    public void displayItems() {
        if (itemCount == 0) {
            System.out.println("list is empty.");
            return;
        }
        for (int i = 0; i < itemCount; i++) {
            System.out.println("- " + items[i]);
        }
    }
}
