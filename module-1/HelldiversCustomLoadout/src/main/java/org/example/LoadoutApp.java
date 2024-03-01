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
    static List<Loadout> loadouts = new ArrayList<>();    // Store created loadouts

    public static void main(String[] args) {

        System.out.println("\nWelcome Super Citizen!\n");

        while (true) {
            System.out.println("Enter name for custom loadout: ");
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
        System.out.println("Select a " + weaponType + "(Please enter a number from the list): ");

        for (int i = 0; i < weaponsList.size(); i++) {
            System.out.println((i + 1) + ". " + weaponsList.get(i).getName());
        }

        String selectionString = scanner.nextLine();
        int selectionInt = Integer.parseInt(selectionString);

        return availablePrimaryWeapons.get(selectionInt - 1);
    }


    private static Grenade selectGrenade(List<Grenade> grenadeList, Scanner scanner) {
        System.out.println("Select a + grenade (Please enter a number from the list): ");

        for (int i = 0; i < grenadeList.size(); i++) {
            System.out.println((i + 1) + ". " + grenadeList.get(i).getName());
        }

        String selectionString = scanner.nextLine();
        int selectionInt = Integer.parseInt(selectionString);

        return availableGrenades.get(selectionInt - 1);
    }

    private static Armor selectArmor(String armorType, List<Armor> armorList, Scanner scanner) {
        System.out.println("Select a " + armorType + "(Please enter a number from the list): ");

        for (int i = 0; i < armorList.size(); i++) {
            System.out.println((i + 1) + ". " + armorList.get(i).getName());
        }

        String selectionString = scanner.nextLine();
        int selectionInt = Integer.parseInt(selectionString);

        return availableHelmets.get(selectionInt - 1);
    }

    private static Booster selectBooster(List<Booster> boosterList, Scanner scanner) {
        System.out.println("Select a Booster (Please enter a number from the list): ");

        for (int i = 0; i < boosterList.size(); i++) {
            System.out.println((i + 1) + ". " + boosterList.get(i).getName());
        }

        String selectionString = scanner.nextLine();
        int selectionInt = Integer.parseInt(selectionString);

        return availableBoosters.get(selectionInt - 1);
    }

    private static Set<Stratagem> selectStratagems(List<Stratagem> stratagemList, Scanner scanner) {

        Set<Stratagem> selectedStratagemSet = new HashSet<>();
        int stratagemsSelected = 0;

        System.out.println("Select 4 stratagems");

        // Display all available stratagems from the list passed in
        for (int i = 0; i < stratagemList.size(); i++) {
            System.out.println((i + 1) + ". " + stratagemList.get(i).getName());
        }

        // Prompt 4x to make selection
        while (stratagemsSelected < 4) {
//            for (int i = 0; i < stratagemList.size(); i++) {                    // print each # and name
//                System.out.println((i + 1) + ". " + stratagemList.get(i).getName());
//            }

            System.out.println("Select a stratagem from the list (enter corresponding number)");
            String userInput = scanner.nextLine();
            int userSelection = Integer.parseInt(userInput);

            try {
                if (userSelection > 0 && userSelection <= stratagemList.size()) { // range --> 1 to (whatever .size()) is due to numbered list from earlier
                    Stratagem currentStratagem = stratagemList.get(userSelection - 1);
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