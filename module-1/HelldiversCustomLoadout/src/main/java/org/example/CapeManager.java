package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CapeManager {

    private List<Armor> capesList = new ArrayList<>();

// ----- Constructor -----
    public CapeManager() {
        loadCapes();
    }

// ----- Getters -----
    public List<Armor> getCapesList() {
        return capesList;
    }

// ----- Methods -----
    private void loadCapes() {

        String filePath = "data/capes";
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {

                String lineOfText = scanner.nextLine();
                String[] splitLine = lineOfText.split("\\|");

                String name = splitLine[0];
                String armorRating = splitLine[1];
                String speed = splitLine[2];
                String staminaRegen = splitLine[3];
                String armorPassive = splitLine[4];
                Armor currentCape = new Armor(name, armorRating, speed, staminaRegen, armorPassive);

                capesList.add(currentCape);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

    }

    public Armor selectCape(List<Armor> armorList, Scanner scanner) {

        System.out.println("\n[ Cape Selection ]\n");

        System.out.println("  Name  |  Armor Rating  |  Speed  |  Stamina Regen  |  Armor Passive");
        System.out.println("------------------------------------------------------------------------");

        for (int i = 0; i < armorList.size(); i++) {
            System.out.println((i + 1) + ") " + armorList.get(i).getName() + "  |  " + armorList.get(i).getArmorRating() + "  |  " + armorList.get(i).getSpeed() + "  |  " + armorList.get(i).getStaminaRegen() + "  |  " + armorList.get(i).getArmorPassive());
        }

        System.out.print("\nSelect a Cape: ");
        String selectionString = scanner.nextLine();
        int selectionInt = Integer.parseInt(selectionString);

        Armor selectedCape = armorList.get(selectionInt - 1);
        System.out.println(">> " + selectedCape.getName() + " selected <<");
        return selectedCape;
    }

}
