package org.java;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GroceryList {

    private String[] items;
    private int itemCount = 0;
    private String name;

    public GroceryList(String name) {
        this.name = name;
    }

    public GroceryList(String name, int maxItems) {
        this.name = name;
        this.items = new String[maxItems];
        this.itemCount = 0;
    }

    public void addItem(String item) {
            items = new String[items == null ? 10 : items.length + 1];
            items[itemCount] = item;
            itemCount++;
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
