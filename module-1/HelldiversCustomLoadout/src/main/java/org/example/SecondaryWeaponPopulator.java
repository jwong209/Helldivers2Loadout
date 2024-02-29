package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondaryWeaponPopulator {

    private List<Weapon> secondaryWeaponsList;

    public SecondaryWeaponPopulator() {
        secondaryWeaponsList = new ArrayList<>();
        loadSecondaries();
    }

    public List<Weapon> getSecondaryWeaponsList() {
        return secondaryWeaponsList;
    }

    public void loadSecondaries() {

        String filePath = "data/secondaryWeapons";
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String lineOfText = scanner.nextLine();
                String[] splitLine = lineOfText.split("\\|");

                String name = splitLine[0];
                String damage = splitLine[1];
                String capacity = splitLine[2];
                String recoil = splitLine[3];
                String fireRate = splitLine[4];
                String weaponTraits = splitLine[5];
                Weapon currentSecondary = new Weapon(name, damage, capacity, recoil, fireRate, weaponTraits);

                secondaryWeaponsList.add(currentSecondary);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

    }

}
