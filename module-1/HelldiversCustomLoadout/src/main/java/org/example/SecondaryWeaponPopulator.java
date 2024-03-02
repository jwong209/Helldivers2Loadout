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

                String name = splitLine[0]; // name
                String subType = splitLine[1];  // subType
                String damage = splitLine[2]; // damage
                String capacity = splitLine[3];  // capacity
                String recoil = splitLine[4];  // recoil
                String fireRate = splitLine[5];  // fireRate
                String weaponTraits = splitLine[6];  // weaponTraits
                Weapon currentSecondary = new Weapon(name, damage, capacity, recoil, fireRate, weaponTraits, subType);

                secondaryWeaponsList.add(currentSecondary);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

    }

}
