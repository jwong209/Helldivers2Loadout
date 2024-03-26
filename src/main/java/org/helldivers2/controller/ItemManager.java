package org.helldivers2.controller;

import org.helldivers2.model.LoadoutItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class ItemManager {

    // ----- Constructor -----
    public ItemManager() {
    }

    // ----- Methods -----

    public LoadoutItem selectItemFromSubtype(String itemType, List<LoadoutItem> itemList, Scanner scanner) {
        while (true) {

            System.out.println("\n[ " + itemType + " Selection ]\n");

        // ----- Create List of subtype names to print -----
            List<String> subTypeList = createSubtypeList(itemType, itemList);

        // ----- User chooses a subtype -----
            System.out.print("\nSelect a type of " + itemType + " or enter '0' to reselect a type: ");
            String subtypeSelected = scanner.nextLine();

            try {
                int subtypeInt = Integer.parseInt(subtypeSelected);

                if (subtypeInt == 0) {        // reselection
                    continue;                 // resets options, keeps code from breaking
                }
                if (subtypeInt < 0 || subtypeInt > subTypeList.size()) {
                    System.out.println("Invalid input. Please select a number between 1 and " + subTypeList.size() + ".");
                    continue;
                }

                String selectedSubType = subTypeList.get(subtypeInt - 1);
                System.out.println("\nAvailable " + selectedSubType + ": ");

            // ----- Print available of that subtype  -----
                int itemCount = 1;
                printSubtypeList(itemList, itemType, selectedSubType);

            // ----- User selects of chosen subtype -----
                System.out.print("\nSelect a " + itemType + " or enter '0' to reselect: ");
                String itemSelected = scanner.nextLine();
                int itemSelectedInt = Integer.parseInt(itemSelected);

                if (itemSelectedInt == 0) {
                    continue;
                }
                if (itemSelectedInt < 0 || itemSelectedInt > (itemCount - 1)) {
                    System.out.println("Invalid input. Please enter number between 1 and " + (itemCount - 1) + ".");
                    continue;
                }

            // -- Use temp counter to match with order List was printed for User --
                LoadoutItem selectedItem = findItemOfSubtype(itemList, selectedSubType, itemSelectedInt);
                return selectedItem;

            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number.\n");
            }
        }

    }

    public List<String> createSubtypeList(String itemType, List<LoadoutItem> itemList) {
        System.out.println(itemType + " types: ");

        List<String> subTypeList = new ArrayList<>();

        for (LoadoutItem loadoutItem : itemList) {
            if (!itemList.contains(loadoutItem.getSubType())) {
                subTypeList.add(loadoutItem.getSubType());
            }
        }
        for (int i = 0; i < subTypeList.size(); i++) {
            System.out.println((i + 1) + ") " + subTypeList.get(i));
        }

        return subTypeList;
    }

    public abstract void printSubtypeList(List<LoadoutItem> itemList, String itemType, String selectedSubType);


    public LoadoutItem findItemOfSubtype(List<LoadoutItem> itemList, String selectedSubType, int itemSelectedInt) {
        int subtypeFoundCount = 1;

        for (LoadoutItem loadoutItem : itemList) {
            if (loadoutItem.getSubType().equals(selectedSubType)) {
                if (subtypeFoundCount == itemSelectedInt) {
                    System.out.println(">> " + loadoutItem.getName() + " selected <<");
                    System.out.println("\n------------------------------------------------------------------------");
                    return loadoutItem;
                }
                subtypeFoundCount++;
            }
        }
        return null;   // just needs a return statement
    }

}
