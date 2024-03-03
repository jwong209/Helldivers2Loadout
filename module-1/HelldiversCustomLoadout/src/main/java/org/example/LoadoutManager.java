package org.example;

import java.util.Scanner;

public class LoadoutManager {

    private static LoadoutApp loadoutApp;
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        loadoutApp = new LoadoutApp();
        run();
    }

    private static void run() {

        while (true) {
            // Main Menu options
            System.out.println("\nWelcome Super Citizen!");
            System.out.println("1: Create custom loadout");
            System.out.println("2: View item info");
            System.out.println("0: Exit");

            int menuSelection = promptMenuSelection("\nPlease choose an option: ");

            if (menuSelection == 1) {
                loadoutApp.createLoadout();
            } else if (menuSelection == 2) {
                // View created loadouts
            } else if (menuSelection == 0) {
                break;
            }



        }

    }

    private static int promptMenuSelection(String prompt) {
        System.out.println(prompt);
        int userSelection = 0;
        try {
            userSelection = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            userSelection = -1;
        }
        return userSelection;
    }

    private static void viewItemInformation() {

    }

}
