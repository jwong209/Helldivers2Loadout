package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrenadeManager {

    private List<Grenade> grenadesList = new ArrayList<>();

// ----- Constructor -----
    public GrenadeManager() {
        loadGrenades();
    }

// ----- Getters -----
    public List<Grenade> getGrenadesList() {
        return grenadesList;
    }

// ----- Methods -----
    private void loadGrenades() {

        String filePath = "data/grenades";
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String lineOfText = scanner.nextLine();
                String[] splitLine = lineOfText.split("\\|");

                String name = splitLine[0];
                String subType = splitLine[1];
                String damage = splitLine[2];
                String penetration = splitLine[3];
                String outerRadius = splitLine[4];
                String fuseTime = splitLine[5];
                Grenade currentGrenade = new Grenade(name, damage, penetration, outerRadius, fuseTime, subType);

                grenadesList.add(currentGrenade);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

    }

    public Grenade selectGrenade(List<Grenade> grenadeList, Scanner scanner) {

        while (true) {
            System.out.println("\n[ Grenade Selection ]\n");
            System.out.println("Grenades types: ");

            // ----- Create list of unique subtype names -----
            List<String> subTypeList = new ArrayList<>();

            for (Grenade grenade : grenadeList) {
                if (!subTypeList.contains(grenade.getSubType())) {
                    subTypeList.add(grenade.getSubType());
                }
            }

            for (int i = 0; i < subTypeList.size(); i++) {
                System.out.println((i + 1) + ") " + subTypeList.get(i));
            }

            // ----- User chooses a subtype -----
            System.out.print("\nSelect a type of Grenade or enter '0' to reselect a type: ");
            String subtypeSelected = scanner.nextLine();
            int subtypeInt = Integer.parseInt(subtypeSelected);

            if (subtypeInt == 0) {        // reselection
                continue;
            }
            if (subtypeInt < 0 || subtypeInt > subTypeList.size()) {
                System.out.println("Please enter number between 1 and " + subTypeList.size());
                continue;
            }

            String selectedSubType = subTypeList.get(subtypeInt - 1);
            System.out.println("\nAvailable " + selectedSubType);

            // ----- Print available of that subtype  -----
            System.out.println("  Name  |  Damage  |  Penetration  |  Outer Radius  |  Fuse Time");
            System.out.println("-------------------------------------------------------------------");

            int grenadeCount = 1;
            for (Grenade grenade : grenadeList) {
                if (grenade.getSubType().equals(selectedSubType)) {
                    System.out.println(grenadeCount + ") " + grenade.getName() + "  |  " + grenade.getDamage() + "  |  " + grenade.getPenetration() + "  |  " + grenade.getOuterRadius() + "  |  " + grenade.getFuseTime());
                    grenadeCount++;
                }
            }

            // ----- User selects of chosen subtype -----
            System.out.print("\nSelect a Grenade or enter '0' to reselect: ");
            String grenadeSelected = scanner.nextLine();
            int grenadeSelectInt = Integer.parseInt(grenadeSelected);

            if (grenadeSelectInt == 0) {
                continue;
            }
            if (grenadeSelectInt < 0 || grenadeSelectInt > grenadeList.size()) {
                System.out.println("Please enter number between 1 and " + grenadeList.size());
                continue;
            }

            // -- Use temp counter to match with order List was printed for User --
            int subtypeFoundCount = 1;
            for (Grenade grenade : grenadeList) {
                if (grenade.getSubType().equals(selectedSubType)) {
                    if (subtypeFoundCount == grenadeSelectInt) {
                        System.out.println(">> " + grenade.getName() + " selected <<");
                        System.out.println("\n------------------------------------------------------------------------");
                        return grenade;
                    }
                    subtypeFoundCount++;
                }
            }

        }

    }

}
