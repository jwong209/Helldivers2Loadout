package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StratagemPopulator {

    private List<Stratagem> stratagemsList;

    public StratagemPopulator() {
        stratagemsList = new ArrayList<>();
        loadStratagems();
    }

    public List<Stratagem> getStratagemsList() {
        return stratagemsList;
    }

    private void loadStratagems() {

        String filePath = "data/stratagems";
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNext()) {
                String lineOfText = scanner.nextLine();
                String[] splitLine = lineOfText.split("\\|");

                String name = splitLine[0];
                String callInTime = splitLine[1];
                String uses = splitLine[2];
                String cooldownTime = splitLine[3];
                String stratagemTraits = splitLine[4];
                Stratagem currentStratagem = new Stratagem(name, callInTime, uses, cooldownTime, stratagemTraits);

                stratagemsList.add(currentStratagem);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

    }
}
