package org.java;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

        public static void main(String[] args) {
            GroceryList groceryList = new GroceryList();
            groceryList.addItem("soda");
            groceryList.addItem("beef");
            groceryList.addItem("bread");
            groceryList.addItem("beer");
            groceryList.addItem("milk");
            groceryList.addItem("eggs");
            groceryList.addItem("chicken");
            groceryList.addItem("fish");
            groceryList.addItem("vegetables");
            groceryList.displayItems();

            System.out.println("items in list: " + groceryList.getItemCount());
        }
    }