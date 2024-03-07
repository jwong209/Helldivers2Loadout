package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArmorManager {

    private List<Armor> helmetsList = new ArrayList<>();
    private List<Armor> bodyArmorList = new ArrayList<>();

// ----- Constructor -----
    public ArmorManager() {
        loadArmor("data/helmets", helmetsList);
        loadArmor("data/bodyArmor", bodyArmorList);
    }

// ----- Getters -----
    public List<Armor> getHelmetList() {
        return helmetsList;
    }

    public List<Armor> getBodyArmorList() {
        return bodyArmorList;
    }

// ----- Methods -----
//    @Override
//    public void loadItemsList(String filePath, List<Armor> armorList) {
//        File file = new File(filePath);
//
//        try (Scanner scanner = new Scanner(file)) {
//
//            while (scanner.hasNextLine()) {
//                String lineOfText = scanner.nextLine();
//                String[] splitLine = lineOfText.split("\\|");
//
//                String name = splitLine[0];
//                String subType = splitLine[1];
//                String armorRating = splitLine[2];
//                String speed = splitLine[3];
//                String staminaRegen = splitLine[4];
//                String armorPassive = splitLine[5];
//                Armor currentArmor = new Armor(name, armorRating, speed, staminaRegen, armorPassive, subType);
//
//                armorList.add(currentArmor);
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found: " + filePath);
//        }
//    }

    private void loadArmor(String filePath, List<Armor> armorList) {

        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String lineOfText = scanner.nextLine();
                String[] splitLine = lineOfText.split("\\|");

                String name = splitLine[0];
                String subType = splitLine[1];
                String armorRating = splitLine[2];
                String speed = splitLine[3];
                String staminaRegen = splitLine[4];
                String armorPassive = splitLine[5];
                Armor currentArmor = new Armor(name, armorRating, speed, staminaRegen, armorPassive, subType);

                armorList.add(currentArmor);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

    }

    public Armor selectArmor(String armorType, List<Armor> armorList, Scanner scanner) {

        while (true) {
            System.out.println("\n[ " + armorType + " Selection ]\n");
            System.out.println("" + armorType + " types: ");

            // ----- Create list of unique subtype names -----
            List<String> subTypeList = new ArrayList<>();

            for (Armor armor : armorList) {
                if (!subTypeList.contains(armor.getSubType())) {
                    subTypeList.add(armor.getSubType());
                }
            }

            for (int i = 0; i < subTypeList.size(); i++) {
                System.out.println((i + 1) + ") " + subTypeList.get(i));
            }

        // ----- User chooses a subtype -----
            System.out.print("\nSelect a type of " + armorType + " or enter '0' to reselect a type: ");
            String subtypeSelected = scanner.nextLine();

            try {
                int subtypeInt = Integer.parseInt(subtypeSelected);

                if (subtypeInt == 0) {
                    continue;
                }
                if (subtypeInt < 0 || subtypeInt > subTypeList.size()) {
                    System.out.println("Invalid input. Please select a number between 0 and " + subTypeList.size() + ".");
                    continue;
                }

                String selectedSubType = subTypeList.get(subtypeInt - 1);
                System.out.println("\nAvailable " + selectedSubType);

            // ----- Print available of that subtype  -----
                System.out.println("  Name  |  Armor Rating  |  Speed  |  Stamina Regen  |  Armor Passive");
                System.out.println("------------------------------------------------------------------------");

                int armorCount = 1;
                for (Armor armor : armorList) {
                    if (armor.getSubType().equals(selectedSubType)) {
                        System.out.println(armorCount + ") " + armor.getName() + "  |  " + armor.getArmorRating() + "  |  " + armor.getSpeed() + "  |  " + armor.getStaminaRegen() + "  |  " + armor.getArmorPassive());
                        armorCount++;
                    }
                }


            // ----- User selects of chosen subtype -----
                System.out.println("\nSelect a " + armorType + " or enter '0' to reselect: ");
                String armorSelected = scanner.nextLine();
                int armorSelectedInt = Integer.parseInt(armorSelected);

                if (armorSelectedInt == 0) {
                    continue;
                }
                if (armorSelectedInt < 0 || armorSelectedInt > armorList.size()) {
                    System.out.println("Invalid input. Please enter number between 1 and " + armorList.size() + ".");
                    continue;
                }

            // -- Use temp counter to match with order List was printed for User --
                int subtypeFoundCount = 1;
                for (Armor armor : armorList) {
                    if (armor.getSubType().equals(selectedSubType)) {
                        if (subtypeFoundCount == armorSelectedInt) {
                            System.out.println(">> " + armor.getName() + " selected <<");
                            System.out.println("\n------------------------------------------------------------------------");
                            return armor;
                        }
                        subtypeFoundCount++;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number.\n");
            }

        }


    }


//    @Override
//    public Armor selectRandomItem(List<Armor> itemList) {
//        return Selectable.super.selectRandomItem(itemList);
//    }
}
