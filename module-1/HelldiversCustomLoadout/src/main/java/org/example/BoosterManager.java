package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoosterManager {

    private List<Booster> boostersList = new ArrayList<>();

// ----- Constructors -----
    public BoosterManager() {
        loadBoosters();
    }

// ----- Getters -----
    public List<Booster> getBoostersList() {
        return boostersList;
    }

// ----- Methods -----
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

    public Booster selectBooster(List<Booster> boosterList, Scanner scanner) {

        System.out.println("\n[ Booster Selection ]\n");

        System.out.println("  Name  |  Benefit");
        System.out.println("---------------------");
        for (int i = 0; i < boosterList.size(); i++) {
            System.out.println((i + 1) + ") " + boosterList.get(i).getName() + "  |  " + boosterList.get(i).getBenefit());
        }

        System.out.print("\nSelect a Booster: ");
        String selectionString = scanner.nextLine();
        int selectionInt = Integer.parseInt(selectionString);

        Booster selectedBooster = boosterList.get(selectionInt - 1);
        System.out.println(">> " +selectedBooster.getName() + " selected <<");

        System.out.println("\n------------------------------------------------------------------------");
        return selectedBooster;
    }

}
