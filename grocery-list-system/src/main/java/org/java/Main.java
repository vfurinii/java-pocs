package org.java;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String name;
    int opcao;
    List<GroceryList> groceryLists = new java.util.ArrayList<>(Collections.emptyList());

    do {
        System.out.println("=== Grocery list system ===");
        System.out.println("1 - Create new grocery list");
        System.out.println("2 - Use existing grocery list");
        System.out.println("3 - List all grocery lists");
        System.out.println("4 - mark done");
        System.out.println("5 - remove a grocery list");
        System.out.println("6 - exit system");
        System.out.print("Choose: ");

        opcao = scanner.nextInt();


        switch (opcao) {
            case 1:
                scanner.nextLine();
                System.out.print("Enter the name for the new grocery list: ");
                name = scanner.nextLine();
                groceryLists.add(new GroceryList("List ".concat(name)));
                System.out.println("New grocery list created: " +  name);
                break;
            case 2:
                if (groceryLists.isEmpty()) {
                    System.out.println("no grocery lists available. Please create one first.");
                } else {
                    scanner.nextLine();
                    System.out.println("choose a grocery list to use (0 to " + (groceryLists.size() - 1) + "):");
                    for(int i = 0; i < groceryLists.size(); i++) {
                        System.out.println(i + " - " + groceryLists.get(i).getName());
                    }
                    opcao = scanner.nextInt();
                    if (opcao < 0 || opcao >= groceryLists.size()) {
                        System.out.println("invalid option! Please choose a valid grocery list.");
                        break;
                    }
                    GroceryList actualGroceryList = groceryLists.get(opcao);
                    System.out.println(actualGroceryList.getName());

                    callUseGroceryList(actualGroceryList, scanner);
                }
                break;
            case 3:
                System.out.println("list all grocery lists...");
                groceryLists.forEach(groceryList -> System.out.println(groceryList.getName()));
                break;
            case 4:
                System.out.println("remove a grocery lists...");
                removeGroceryList(groceryLists, scanner.nextInt());
                break;
            case 5:
                System.out.println("mark done a grocery list...");
                markDone(groceryLists, scanner.nextInt());
                break;
            case 6:
                System.out.println("exiting...");
                break;
            default:
                System.out.println("invalid option newbie!");
        }
    } while (opcao != 5);
    scanner.close();
//
}

    private static void markDone(List<GroceryList> groceryLists, int i) {
        if (i < 0 || i >= groceryLists.size()) {
            System.out.println("invalid index");
            return;
        }
        GroceryList groceryList = groceryLists.get(i);
        System.out.println("grocery list " + groceryList.getName() + " marked as done.");
        groceryLists.get(i).setName(groceryList.getName() + " - done");
    }

    private static void callUseGroceryList(GroceryList actualGroceryList, Scanner scanner) {
    int opcao;
    do {
        System.out.println("=== Grocery list ===");
        System.out.println("1 - add item");
        System.out.println("2 - listar itens");
        System.out.println("3 - remover itens");
        System.out.println("4 - Voltar ao menu principal");
        System.out.print("choose: ");

        opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Adding item... ");
                System.out.print("Enter item name: ");
                String itemName = scanner.next();
                actualGroceryList.addItem(itemName);
                break;
            case 2:
                System.out.println("Listing");
                actualGroceryList.displayItems();
                break;
            case 3:
                System.out.println("cHOOSE item to remove: ");
                String itemToRemove = scanner.next();
                actualGroceryList.removeItem(itemToRemove);
                break;
            case 4:
                System.out.println("exiting... ");
                break;
            default:
                System.out.println("invalid option!");
            }

        } while (opcao != 4);
    System.out.println("Returning to main menu...");
    }

    private static void removeGroceryList(List<GroceryList> groceryLists, int index) {
        if (index < 0 || index >= groceryLists.size()) {
            System.out.println("invalid index");
            return;
        }
        groceryLists.remove(index);
        System.out.println("grocery list removed");
    }
}