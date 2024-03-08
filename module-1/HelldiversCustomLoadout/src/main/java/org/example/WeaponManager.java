package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeaponManager {

    private List<Weapon> primaryWeaponsList = new ArrayList<>();
    private List<Weapon> secondaryWeaponsList = new ArrayList<>();

// ----- Constructor -----
    public WeaponManager() {
        loadWeapons("data/primaryWeapons", primaryWeaponsList);
        loadWeapons("data/secondaryWeapons", secondaryWeaponsList);
    }

// ----- Getters  -----
    public List<Weapon> getPrimaryWeaponsList() {
        return primaryWeaponsList;
    }

    public List<Weapon> getSecondaryWeaponsList() {
        return secondaryWeaponsList;
    }

// ----- Methods -----
    private void loadWeapons(String filePath, List<Weapon> weaponsList) {

        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String lineOfText = scanner.nextLine();
                String[] splitLine = lineOfText.split("\\|");

                String name = splitLine[0];
                String subType = splitLine[1];
                String damage = splitLine[2];
                String capacity = splitLine[3];
                String recoil = splitLine[4];
                String fireRate = splitLine[5];
                String weaponTraits = splitLine[6];
                Weapon currentWeapon = new Weapon(name, damage, capacity, recoil, fireRate, weaponTraits, subType);

                weaponsList.add(currentWeapon);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

    }

    public Weapon selectWeapon(String weaponType, List<Weapon> weaponsList, Scanner scanner) {

        while (true) {
            System.out.println("\n[ " + weaponType + " Selection ]\n");

        // ----- Create List of subtype names to print -----
            System.out.println(weaponType + " types: ");

            List<String> subTypeList = new ArrayList<>();

            for (Weapon weapon : weaponsList) {
                if (!subTypeList.contains(weapon.getSubType())) {
                    subTypeList.add(weapon.getSubType());
                }
            }
            for (int i = 0; i < subTypeList.size(); i++) {
                System.out.println((i + 1) + ") " + subTypeList.get(i));
            }

        // ----- User chooses a subtype -----
            System.out.print("\nSelect a type of " + weaponType + " or enter '0' to reselect a type: ");
            String subtypeSelected = scanner.nextLine();

            try {
                int subtypeInt = Integer.parseInt(subtypeSelected);

                if (subtypeInt == 0) {        // reselection
                    continue;                 // resets options
                }
                if (subtypeInt < 0 || subtypeInt > subTypeList.size()) {
                    System.out.println("Invalid input. Please select a number between 1 and " + subTypeList.size() + ".");
                    continue;
                }

                String selectedSubType = subTypeList.get(subtypeInt - 1);

            // ----- Print available of that subtype  -----
                System.out.println("\n" + weaponType + " - " + selectedSubType + " choices: ");
                System.out.println("  Name  |  Damage  |  Capacity  |  Recoil  |  Fire Rate  |  Weapon Traits");
                System.out.println("----------------------------------------------------------------------------");
                int weaponCount = 1;

                for (Weapon weapon : weaponsList) {
                    if (weapon.getSubType().equals(selectedSubType)) {
                        System.out.println(weaponCount + ") " + weapon.getName() + "  |  " + weapon.getDamage() + "  |  " + weapon.getCapacity() + "  |  " + weapon.getRecoil() + "  |  " + weapon.getFireRate() + "  |  " + weapon.getWeaponTraits());
                        weaponCount++;
                    }
                }

            // ----- User selects of chosen subtype -----
                System.out.print("\nSelect a " + weaponType + " or enter '0' to reselect: ");
                String weaponSelected = scanner.nextLine();
                int weaponSelectedInt = Integer.parseInt(weaponSelected);

                if (weaponSelectedInt == 0) {
                    continue;
                }
                if (weaponSelectedInt < 0 || weaponSelectedInt > (weaponCount - 1)) {
                    System.out.println("Invalid input. Please enter number between 1 and " + (weaponCount - 1) + ".");
                    continue;
                }

//                System.out.println("Warning! This line shouldn't run if user input is wrong"); //debug

            // -- Use temp counter to match with order List was printed for User --
                int subtypeFoundCount = 1;
                for (Weapon weapon : weaponsList) {
                    if (weapon.getSubType().equals(selectedSubType)) {
                        if (subtypeFoundCount == weaponSelectedInt) {
                            System.out.println(">> " + weapon.getName() + " selected <<");
                            System.out.println("\n------------------------------------------------------------------------");
                            return weapon;
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
