package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BodyArmorPopulator {

    private List<Armor> bodyArmorList;

    public BodyArmorPopulator() {
        bodyArmorList = new ArrayList<>();
        loadBodyArmor();
    }

    public List<Armor> getBodyArmorList() {
        return bodyArmorList;
    }

    private void loadBodyArmor() {

        String filePath = "data/bodyArmor";
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
                Armor currentBodyArmor = new Armor(name, armorRating, speed, staminaRegen, armorPassive);

                bodyArmorList.add(currentBodyArmor);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

    }
}
