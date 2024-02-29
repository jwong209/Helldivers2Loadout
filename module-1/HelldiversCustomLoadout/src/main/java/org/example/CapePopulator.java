package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CapePopulator {

    private List<Armor> capesList;

    public CapePopulator() {
        capesList = new ArrayList<>();
        loadCapes();
    }

    public List<Armor> getCapesList() {
        return capesList;
    }

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
}
