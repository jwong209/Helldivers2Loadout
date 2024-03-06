package org.example;

import java.util.Scanner;

public class LoadoutManager {

    private static LoadoutApp loadoutApp;
    private static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        loadoutApp = new LoadoutApp();
        run();
    }

    private static void run() {

        while (true) {
        // Main Menu print options
            System.out.println("\nWelcome Super Citizen!");
            System.out.println("[ Please enter the corresponding number of your choice or appropriate letter (Y/N) when prompted. ]");
            System.out.println("1: Create custom loadout");
            System.out.println("2: View created loadouts");
            System.out.println("0: Quit application");

            int menuSelection = promptSelection("\nSelect an option: ");

        // Main Menu Selection
            if (menuSelection == 1) {
                loadoutApp.createLoadout();
            } else if (menuSelection == 2) {
                viewCreatedLoadouts(); // View created loadouts
            } else if (menuSelection == 0) {
                break;
            }
        }

    }

    private static int promptSelection(String prompt) {
        System.out.print(prompt);
        int userSelection = 0;
        while (true) {
            try {
                userSelection = Integer.parseInt(userInput.nextLine());
                return userSelection;
            } catch (NumberFormatException e) {
                System.out.print("\nInvalid input. Please enter a number: ");
            }
        }

    }

    private static void viewCreatedLoadouts() {

        if (loadoutApp.getLoadouts().size() == 0) {                                           // If no loadouts created or in list
            System.out.println("\nNo loadouts currently exist. Please select [1] from the main menu to create a loadout.");
        } else {
            for (Loadout loadout : loadoutApp.getLoadouts()) {
                System.out.println("");
                System.out.println("[   Loadout: " + loadout.getName() + "   ]");
                System.out.println("Primary Weapon: " + loadout.getPrimaryWeapon().getName());
                System.out.println("Secondary Weapon: " + loadout.getSecondaryWeapon().getName());
                System.out.println("Grenade: " + loadout.getGrenade().getName());
                System.out.println("Helmet: " + loadout.getHelmet().getName());
                System.out.println("Body Armor: " + loadout.getBodyArmor().getName());
                System.out.println("Cape: " + loadout.getCape().getName());
                System.out.println("Stratagems: ");

                for (Stratagem stratagem : loadout.getStratagems()) {
                    System.out.println("- " + stratagem.getName());
                }

                System.out.println("Booster: " + loadout.getBooster().getName());
                System.out.println("\n----------------------------------------------");
            }
        }

    }

}
