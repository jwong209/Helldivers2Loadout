package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class HelmetPopulator {

    private List<Armor> helmetsList;

    public List<Armor> getHelmetsList() {
        return helmetsList;
    }

    public HelmetPopulator() {
        helmetsList = new ArrayList<>();
        loadHelmets();
    }

    private void loadHelmets() {

        String filePath = "data/helmets";
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

                helmetsList.add(currentArmor);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

    }
}
