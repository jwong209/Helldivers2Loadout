package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoosterPopulator {

    private List<Booster> boostersList;

    public BoosterPopulator() {
        boostersList = new ArrayList<>();
        loadBoosters();
    }

    public List<Booster> getBoostersList() {
        return boostersList;
    }

    private void loadBoosters() {

        String filePath = "data/boosters";
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String lineOfText = scanner.nextLine();
                String[] splitLine = lineOfText.split("\\|");

                String name = splitLine[0];
                String benefit = splitLine[1];
                Booster currentBooster = new Booster(name, benefit);

                boostersList.add(currentBooster);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

    }

}
