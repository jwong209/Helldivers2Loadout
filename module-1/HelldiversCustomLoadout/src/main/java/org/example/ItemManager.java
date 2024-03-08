package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class ItemManager {

    // ----- Constructor -----
    public ItemManager() {
    }

    public abstract void printSubtypeList();

    public LoadoutItem selectItemWithSubtypes(String itemType, List<LoadoutItem> itemList, Scanner scanner) {
        while (true) {
            System.out.println("\n[ " + itemType + " Selection ]\n");

            // ----- Create List of subtype names to print -----
            System.out.println(itemType + " types: ");

            List<String> subTypeList = new ArrayList<>();

            for (LoadoutItem loadoutItem : itemList) {
                if (!subTypeList.contains(loadoutItem.getSubType())) {
                    subTypeList.add(loadoutItem.getSubType());
                }
            }
            for (int i = 0; i < subTypeList.size(); i++) {
                System.out.println((i + 1) + ") " + subTypeList.get(i));
            }

            // ----- User chooses a subtype -----
            System.out.print("\nSelect a type of " + itemType + " or enter '0' to reselect a type: ");
            String subtypeSelected = scanner.nextLine();

            try {
                int subtypeInt = Integer.parseInt(subtypeSelected);

                if (subtypeInt == 0) {        // reselection
                    continue;                 // resets options, keeps code from breaking
                }
                if (subtypeInt < 0 || subtypeInt > subTypeList.size()) {
                    System.out.println("Invalid input. Please select a number between 0 and " + subTypeList.size() + ".");
                    continue;
                }

                String selectedSubType = subTypeList.get(subtypeInt - 1);
                System.out.println("\nAvailable " + selectedSubType + ": ");

                // ----- Print available of that subtype  -----
//                System.out.println("  Name  |  Damage  |  Capacity  |  Recoil  |  Fire Rate  |  Weapon Traits");
//                System.out.println("----------------------------------------------------------------------------");
//                int itemCount = 1;
//
//                for (LoadoutItem loadoutItem : itemList) {
//                    if (loadoutItem.getSubType().equals(selectedSubType)) {
//                        System.out.println(itemCount + ") " + loadoutItem.getName() + "  |  " + loadoutItem.getDamage() + "  |  " + weapon.getCapacity() + "  |  " + weapon.getRecoil() + "  |  " + weapon.getFireRate() + "  |  " + weapon.getWeaponTraits());
//                        itemCount++;
//                    }
//                }
                printSubtypeList();

                // ----- User selects of chosen subtype -----
                System.out.print("\nSelect a " + itemType + " or enter '0' to reselect: ");
                String itemSelected = scanner.nextLine();
                int itemSelectedInt = Integer.parseInt(itemSelected);

                if (itemSelectedInt == 0) {
                    continue;
                }
                if (itemSelectedInt < 0 || itemSelectedInt > itemList.size()) {
                    System.out.println("Invalid input. Please enter number between 1 and " + itemList.size() + ".");
                    continue;
                }

//                System.out.println("Warning! This line shouldn't run if input is wrong");

                // -- Use temp counter to match with order List was printed for User --
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
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number.\n");
            }
        }
    }
}
