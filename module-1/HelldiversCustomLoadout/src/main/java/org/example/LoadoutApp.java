package org.example;

import java.util.*;

public class LoadoutApp {
    private static final Scanner userInput = new Scanner(System.in);

    // ----- Populate lists from files, create obj from classes that handle this -----
    static PrimaryWeaponPopulator primaryWeaponPopulator = new PrimaryWeaponPopulator();
    static SecondaryWeaponPopulator secondaryWeaponPopulator = new SecondaryWeaponPopulator();
    static GrenadePopulator grenadePopulator = new GrenadePopulator();
    static HelmetPopulator helmetPopulator = new HelmetPopulator();
    static BodyArmorPopulator bodyArmorPopulator = new BodyArmorPopulator();
    static CapePopulator capePopulator = new CapePopulator();
    static StratagemPopulator stratagemPopulator = new StratagemPopulator();
    static BoosterPopulator boosterPopulator = new BoosterPopulator();

    // ----- From populators, create lists to house available items for each category -----
    static List<Weapon> availablePrimaryWeapons = primaryWeaponPopulator.getPrimaryWeaponsList();
    static List<Weapon> availableSecondaryWeapons = secondaryWeaponPopulator.getSecondaryWeaponsList();
    static List<Grenade> availableGrenades = grenadePopulator.getGrenadesList();
    static List<Armor> availableHelmets = helmetPopulator.getHelmetsList();
    static List<Armor> availableBodyArmor = bodyArmorPopulator.getBodyArmorList();
    static List<Armor> availableCapes = capePopulator.getCapesList();
    static List<Stratagem> availableStratagems = stratagemPopulator.getStratagemsList();
    static List<Booster> availableBoosters = boosterPopulator.getBoostersList();
    static List<Loadout> loadouts = new ArrayList<>();    // Store created loadouts here

    public static void main(String[] args) {

        System.out.println("\nWelcome Super Citizen!");

        while (true) {
            System.out.print("\nEnter name for custom loadout: ");
            String loadoutName = userInput.nextLine();

            Weapon selectedPrimary = selectWeapon("Primary Weapon", availablePrimaryWeapons, userInput);
            Weapon selectedSecondary = selectWeapon("Secondary Weapon", availableSecondaryWeapons, userInput);
            Grenade selectedGrenade = selectGrenade(availableGrenades, userInput);
            Armor selectedHelmet = selectArmor("Helmet", availableHelmets, userInput);
            Armor selectedBodyArmor = selectArmor("Body Armor", availableBodyArmor, userInput);
            Armor selectedCape = selectArmor("Cape", availableCapes, userInput);
            Booster selectedBooster = selectBooster(availableBoosters, userInput);
            Set<Stratagem> selectedStratagems = selectStratagems(availableStratagems, userInput);

            Loadout customLoadout = new Loadout(loadoutName, selectedPrimary, selectedSecondary, selectedGrenade, selectedHelmet, selectedBodyArmor, selectedCape, selectedBooster, selectedStratagems);
            loadouts.add(customLoadout);
        }

    }

    private static Weapon selectWeapon(String weaponType, List<Weapon> weaponsList, Scanner scanner) {

        while (true) {
            System.out.println("\n[ " + weaponType + " Selection ]");
            System.out.println("--------------------");

            // get the types but have to be unique collection, print off types with # selections, Set --> List
            Set<String> subTypeSet = new HashSet<>();   // temporary Set to store subType, unique means less code

            for (Weapon weapon : weaponsList) {
                subTypeSet.add(weapon.getSubType());
            }

            List<String> subTypeList = new ArrayList<>(subTypeSet);  // convert back to temporary List to make it easier. how to iterate through Set w/ordered numbers listing?

            for (int i = 0; i < subTypeList.size(); i++) {
                System.out.println((i + 1) + ") " + subTypeList.get(i));
            }

            System.out.print("Enter a number selection to view a list of the subtype of " + weaponType + " or enter '0' to reselect: ");
            String subtypeSelected = scanner.nextLine();
            int subtypeNumber = Integer.parseInt(subtypeSelected);

            if (subtypeNumber == 0) {        // reselection, want to continue the loop so don't 'break'
                continue;
            }

            String selectedSubType = subTypeList.get(subtypeNumber - 1);
            System.out.println("\nAvailable " + selectedSubType);

            // using List of subtype names, loop through to find matching subType from each Weapon, print those
            int weaponCount = 1;
            for (Weapon weapon : weaponsList) {
                if (weapon.getSubType().equals(selectedSubType)) {
                    System.out.println(weaponCount + ") " + weapon.getName());
                    weaponCount++;
                }
            }

            // user selects from the List of subType names
            System.out.println("\nEnter a " + weaponType + " or enter '0' to reselect: ");
            String weaponSelected = scanner.nextLine();
            int weaponNumber = Integer.parseInt(weaponSelected);

            if (weaponNumber == 0) {
                continue;
            }

            int count = 1;
            for (Weapon weapon : weaponsList) {
                if (weapon.getSubType().equals(selectedSubType)) {
                    if (count == weaponNumber) {
                        return weapon;
                    }
                    count++;
                }
            }

        }

    }


    private static Grenade selectGrenade(List<Grenade> grenadeList, Scanner scanner) {

        while (true) {
            System.out.println("\n[ Grenade Selection ]");
            System.out.println("--------------------");

            // get the types but have to be unique collection, print off types with # selections, Set --> List
            Set<String> subTypeSet = new HashSet<>();   // temporary Set to store subType, unique means less code

            for (Grenade grenade : grenadeList) {
                subTypeSet.add(grenade.getSubType());
            }

            List<String> subTypeList = new ArrayList<>(subTypeSet);  // convert back to temporary List to make it easier. how to iterate through Set w/ordered numbers listing?

            for (int i = 0; i < subTypeList.size(); i++) {
                System.out.println((i + 1) + ") " + subTypeList.get(i));
            }

            System.out.print("Enter a number selection to view a list of the subtype of Grenade or enter '0' to reselect: ");
            String subtypeSelected = scanner.nextLine();
            int subtypeNumber = Integer.parseInt(subtypeSelected);

            if (subtypeNumber == 0) {        // reselection, want to continue the loop so don't 'break'
                continue;
            }

            String selectedSubType = subTypeList.get(subtypeNumber - 1);
            System.out.println("\nAvailable " + selectedSubType);

            // using List of subtype names, loop through to find matching subType from each Weapon, print those
            int grenadeCount = 1;
            for (Grenade grenade : grenadeList) {
                if (grenade.getSubType().equals(selectedSubType)) {
                    System.out.println(grenadeCount + ") " + grenade.getName());
                    grenadeCount++;
                }
            }

            // user selects from the List of subType names
            System.out.println("\nEnter a Grenade or enter '0' to reselect: ");
            String grenadeSelected = scanner.nextLine();
            int grenadeNumber = Integer.parseInt(grenadeSelected);

            if (grenadeNumber == 0) {
                continue;
            }

            int count = 1;
            for (Grenade grenade : grenadeList) {
                if (grenade.getSubType().equals(selectedSubType)) {
                    if (count == grenadeNumber) {
                        return grenade;
                    }
                    count++;
                }
            }

        }

//        System.out.println("\nAvailable Grenades");
//        System.out.println("----------");
//
//        for (int i = 0; i < grenadeList.size(); i++) {
//            System.out.println((i + 1) + ") " + grenadeList.get(i).getName());
//        }
//
//        System.out.print("\nSelect a Grenade (Please enter a number from the list): ");
//
//        String selectionString = scanner.nextLine();
//        int selectionInt = Integer.parseInt(selectionString);
//
//        return availableGrenades.get(selectionInt - 1);
    }

    private static Armor selectArmor(String armorType, List<Armor> armorList, Scanner scanner) {

        System.out.println("\nAvailable " + armorType);
        System.out.println("----------");

        for (int i = 0; i < armorList.size(); i++) {
            System.out.println((i + 1) + ") " + armorList.get(i).getName());
        }

        System.out.print("\nSelect a " + armorType + " (Please enter a number from the list): ");

        String selectionString = scanner.nextLine();
        int selectionInt = Integer.parseInt(selectionString);

        return availableHelmets.get(selectionInt - 1);
    }

    private static Booster selectBooster(List<Booster> boosterList, Scanner scanner) {

        System.out.println("\nAvailable Boosters");
        System.out.println("----------");

        for (int i = 0; i < boosterList.size(); i++) {
            System.out.println((i + 1) + ") " + boosterList.get(i).getName());
        }

        System.out.print("\nSelect a Booster (Please enter a number from the list): ");

        String selectionString = scanner.nextLine();
        int selectionInt = Integer.parseInt(selectionString);

        return availableBoosters.get(selectionInt - 1);
    }

    private static Set<Stratagem> selectStratagems(List<Stratagem> stratagemList, Scanner scanner) {

        System.out.println("\nAvailable Stratagems");
        System.out.println("----------");

        Set<Stratagem> selectedStratagemSet = new HashSet<>();
        int stratagemsSelected = 0;

        System.out.println("\nSelect 4 stratagems:");

        // Display all available stratagems from the list passed in
        for (int i = 0; i < stratagemList.size(); i++) {
            System.out.println((i + 1) + ") " + stratagemList.get(i).getName());
        }

        // Prompt 4x to make selection
        while (stratagemsSelected < 4) {

            System.out.print("\nSelect a stratagem from the list (enter corresponding number)");
            String userInput = scanner.nextLine();
            int userSelection = Integer.parseInt(userInput);

            try {
                if (userSelection > 0 && userSelection <= stratagemList.size()) { // range --> 1 to (whatever .size()) is due to numbered list from earlier
                    Stratagem currentStratagem = stratagemList.get(userSelection - 1); // -1 b/c zero index List
                    if (selectedStratagemSet.contains(currentStratagem)) {
                        System.out.println("Already selected");
                    } else {
                        selectedStratagemSet.add(currentStratagem);
                        stratagemsSelected++;
                        System.out.println("Stratagem selected");
                    }
                } else {                           // condition when number entered is out of range
                    System.out.println("Please enter number between 1 and " + stratagemList.size());
                }
            } catch (NumberFormatException e) {   // condition when number is not entered
                System.out.println("Not a number. Please enter a number.");
            }

        }

        return selectedStratagemSet;
    }




}