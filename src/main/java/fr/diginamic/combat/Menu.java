package fr.diginamic.combat;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Main menu:");
        System.out.println("1. Create a character");
        System.out.println("2. Fight a creature");
        System.out.println("3. Take a potion");
        System.out.println("4. Show stats");
        System.out.println("5. Exit");
        System.out.println("=".repeat(40));
        System.out.print("Your choice: ");
    }

    public int readUserChoice() {
       try {
           return Integer.parseInt(scanner.nextLine());
       } catch (NumberFormatException e) {
           return -1;
       }
    }

    public int showPotionMenu(Inventory inventory) {
        System.out.println("Use a potion");
        inventory.showInventory();
        System.out.print("0. Go back to main menu");
        System.out.print("\nWhat potions do you want to use? ");

        return readUserChoice();
    }

    public void waitUser(){
        System.out.println("Press enter to continue...");
        scanner.nextLine();
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    public void showInfo(String message) {
        System.out.println(message);
    }

    public void showSuccess(String message) {
        System.out.println("Success: " + message);
    }

    public void close() {
        scanner.close();
    }
}
