package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrenadePopulator {

    private List<Grenade> grenadesList;

    // Constructor
    public GrenadePopulator() {
        grenadesList = new ArrayList<>();
        loadGrenades();
    }

    // Getter
    public List<Grenade> getGrenadesList() {
        return grenadesList;
    }

    // Methods
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

}
