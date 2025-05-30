package org.java;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

            GroceryList groceryList = new GroceryList();

            Scanner scanner = new Scanner(System.in);
            int opcao;

            do {
                System.out.println("=== Grocery list ===");
                System.out.println("1 - Add item");
                System.out.println("2 - List items");
                System.out.println("3 - Remove Itens");
                System.out.println("4 - Sair");
                System.out.print("choose: ");

                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Adding item... ");
                        System.out.print("Enter item name: ");
                        String itemName = scanner.next();
                        groceryList.addItem(itemName);
                        break;
                    case 2:
                        System.out.println("Listing");
                        groceryList.displayItems();
                        break;
                    case 3:
                        System.out.println("cHOOSE item to remove: ");
                        String itemToRemove = scanner.next();
                        groceryList.removeItem(itemToRemove);
                        break;
                    case 4:
                        System.out.println("exiting... ");
                        break;
                    default:
                        System.out.println("invalid option!");
                }

            } while (opcao != 4);
            scanner.close();
        }
    }