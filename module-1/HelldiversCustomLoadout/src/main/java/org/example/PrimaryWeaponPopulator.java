package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PrimaryWeaponPopulator {

    private List<Weapon> primaryWeaponsList;

    //Constructor
    public PrimaryWeaponPopulator() {
        primaryWeaponsList = new ArrayList<>();
        loadPrimaries();
    }

    public List<Weapon> getPrimaryWeaponsList() {
        return primaryWeaponsList;
    }

    //Methods
    public void loadPrimaries() {

        // Assign filepath to file from data folder, convert that string into a File, new Scanner to read this File
        String filePath = "data/primaryWeapons";  // path from content root
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) { // loop through all available line
                String lineOfText = scanner.nextLine();
                String[] splitLine = lineOfText.split("\\|");

                String name = splitLine[0]; // name
                String subType = splitLine[1];  // subType
                String damage = splitLine[2]; // damage
                String capacity = splitLine[3];  // capacity
                String recoil = splitLine[4];  // recoil
                String fireRate = splitLine[5];  // fireRate
                String weaponTraits = splitLine[6];  // weaponTraits
                Weapon currentPrimary = new Weapon(name, damage, capacity, recoil, fireRate, weaponTraits, subType);

                primaryWeaponsList.add(currentPrimary);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

    }

}
