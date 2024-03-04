package org.example;

import java.util.*;

public class LoadoutApp {
    private final Scanner userInput = new Scanner(System.in);

    // ----- Populate lists from files, create obj from classes that handle this -----
    private PrimaryWeaponPopulator primaryWeaponPopulator = new PrimaryWeaponPopulator();
    private SecondaryWeaponPopulator secondaryWeaponPopulator = new SecondaryWeaponPopulator();
    private GrenadePopulator grenadePopulator = new GrenadePopulator();
    private HelmetPopulator helmetPopulator = new HelmetPopulator();
    private BodyArmorPopulator bodyArmorPopulator = new BodyArmorPopulator();
    private CapePopulator capePopulator = new CapePopulator();
    private StratagemPopulator stratagemPopulator = new StratagemPopulator();
    private BoosterPopulator boosterPopulator = new BoosterPopulator();

    // ----- From populators, create lists to house available items for each category -----
    private List<Weapon> availablePrimaryWeapons = primaryWeaponPopulator.getPrimaryWeaponsList();
    private List<Weapon> availableSecondaryWeapons = secondaryWeaponPopulator.getSecondaryWeaponsList();
    private List<Grenade> availableGrenades = grenadePopulator.getGrenadesList();
    private List<Armor> availableHelmets = helmetPopulator.getHelmetsList();
    private List<Armor> availableBodyArmor = bodyArmorPopulator.getBodyArmorList();
    private List<Armor> availableCapes = capePopulator.getCapesList();
    private List<Stratagem> availableStratagems = stratagemPopulator.getStratagemsList();
    private List<Booster> availableBoosters = boosterPopulator.getBoostersList();
    private List<Loadout> loadouts = new ArrayList<>();    // Store created loadouts here


    // ----- Getters -----
    public List<Loadout> getLoadouts() {
        return loadouts;
    }
    // -------------------
    public void createLoadout() {

        boolean willContinue = true;

        while (willContinue) {
            System.out.print("\nEnter name for custom loadout: ");
            String loadoutName = userInput.nextLine();

            Weapon selectedPrimary = selectWeapon("Primary Weapon", availablePrimaryWeapons, userInput);
            Weapon selectedSecondary = selectWeapon("Secondary Weapon", availableSecondaryWeapons, userInput);
            Grenade selectedGrenade = selectGrenade(availableGrenades, userInput);
            Armor selectedHelmet = selectArmor("Helmet", availableHelmets, userInput);
            Armor selectedBodyArmor = selectArmor("Body Armor", availableBodyArmor, userInput);
            Armor selectedCape = selectCape(availableCapes, userInput);
            Set<Stratagem> selectedStratagems = selectStratagems(availableStratagems, userInput);
            Booster selectedBooster = selectBooster(availableBoosters, userInput);  // swap place with Stratagem, in this way closer to actual in-game cycle of user choices

            Loadout customLoadout = new Loadout(loadoutName, selectedPrimary, selectedSecondary, selectedGrenade, selectedHelmet, selectedBodyArmor, selectedCape, selectedBooster, selectedStratagems);
            loadouts.add(customLoadout);

        // ----- Choice to stop infinite loop of creating loadouts -----
            System.out.print("\nCreate another loadout? ( Y / N ): ");
            String continueChoice = userInput.nextLine();

            if (continueChoice.equals("Y")) {
                willContinue = true;
            } else if (continueChoice.equals("N")) {
                willContinue = false;
            }
        }

    }

    private Weapon selectWeapon(String weaponType, List<Weapon> weaponsList, Scanner scanner) {

        while (true) {
            System.out.println("\n[ " + weaponType + " Selection ]\n");

        // ----- Create List of subtype names to print -----
            System.out.println(weaponType + " types: ");
            /* -- Using Set --> List --
            Set<String> subTypeSet = new HashSet<>();   // temporary Set to store subType, unique means less code

            for (Weapon weapon : weaponsList) {
                subTypeSet.add(weapon.getSubType());
            }

            List<String> subTypeList = new ArrayList<>(subTypeSet);  // convert back to temporary List

            for (int i = 0; i < subTypeList.size(); i++) {
                System.out.println((i + 1) + ") " + subTypeList.get(i));
            }

            */
            // -- Using List instead of Set to ensure original order --
            List<String> subTypeList = new ArrayList<>();

            for (Weapon weapon : weaponsList) {
                if (!subTypeList.contains(weapon.getSubType())) {
                    subTypeList.add(weapon.getSubType());
                }
            }
            for (int i = 0; i < subTypeList.size(); i++) {
                System.out.println((i + 1) + ") " + subTypeList.get(i));
            }

        // ----- User chooses a subtype -----
            System.out.print("\nSelect a type of " + weaponType + " to view or enter '0' to reselect a type: ");
            String subtypeSelected = scanner.nextLine();
            int subtypeNumber = Integer.parseInt(subtypeSelected);

            if (subtypeNumber == 0) {        // reselection
                continue;
            }

            String selectedSubType = subTypeList.get(subtypeNumber - 1);
            System.out.println("\nAvailable " + selectedSubType + ": ");

        // ----- Print available of that subtype  -----
            int weaponCount = 1;
            for (Weapon weapon : weaponsList) {
                if (weapon.getSubType().equals(selectedSubType)) {
                    System.out.println(weaponCount + ") " + weapon.getName());
                    weaponCount++;
                }
            }

        // ----- User selects of chosen subtype -----
            System.out.print("\nSelect a " + weaponType + " or enter '0' to reselect: ");
            String weaponSelected = scanner.nextLine();
            int weaponSelectedInt = Integer.parseInt(weaponSelected);

            if (weaponSelectedInt == 0) {
                continue;
            }
            if (weaponSelectedInt < 0 || weaponSelectedInt > weaponsList.size()) {
                System.out.println("Please enter number between 1 and " + weaponsList.size());
                continue;
            }

            // -- Use temp counter to match with order List was printed for User --

            int subtypeFoundCount = 1;
            for (Weapon weapon : weaponsList) {
                if (weapon.getSubType().equals(selectedSubType)) {
                    if (subtypeFoundCount == weaponSelectedInt) {
                        return weapon;
                    }
                    subtypeFoundCount++;
                }
            }


        }

    }


    private Grenade selectGrenade(List<Grenade> grenadeList, Scanner scanner) {

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
            System.out.print("\nEnter a Grenade or enter '0' to reselect: ");
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

    }

    private Armor selectArmor(String armorType, List<Armor> armorList, Scanner scanner) {

        while (true) {
            System.out.println("\n[ " + armorType + "Selection ]");
            System.out.println("--------------------");

            // get the types but have to be unique collection, print off types with # selections, Set --> List
            Set<String> subTypeSet = new HashSet<>();   // temporary Set to store subType, unique means less code

            for (Armor armor : armorList) {
                subTypeSet.add(armor.getSubType());
            }

            List<String> subTypeList = new ArrayList<>(subTypeSet);

            for (int i = 0; i < subTypeList.size(); i++) {
                System.out.println((i + 1) + ") " + subTypeList.get(i));
            }

            System.out.print("Enter a number selection to view a list of the subtype of" + armorType + " or enter '0' to reselect: ");
            String subtypeSelected = scanner.nextLine();
            int subtypeNumber = Integer.parseInt(subtypeSelected);

            if (subtypeNumber == 0) {
                continue;
            }

            String selectedSubType = subTypeList.get(subtypeNumber - 1);
            System.out.println("\nAvailable " + selectedSubType);

            // using List of subtype names, loop through to find matching subType from each Weapon, print those
            int grenadeCount = 1;
            for (Armor armor : armorList) {
                if (armor.getSubType().equals(selectedSubType)) {
                    System.out.println(grenadeCount + ") " + armor.getName());
                    grenadeCount++;
                }
            }

            // user selects from the List of subType names
            System.out.println("\nEnter a " + armorType + " or enter '0' to reselect: ");
            String grenadeSelected = scanner.nextLine();
            int grenadeNumber = Integer.parseInt(grenadeSelected);

            if (grenadeNumber == 0) {
                continue;
            }

            int count = 1;
            for (Armor armor : armorList) {
                if (armor.getSubType().equals(selectedSubType)) {
                    if (count == grenadeNumber) {
                        return armor;
                    }
                    count++;
                }
            }
        }

    }

    private Armor selectCape(List<Armor> armorList, Scanner scanner) {

        System.out.println("\n[ Cape Selection ]");
        System.out.println("--------------------");

        for (int i = 0; i < armorList.size(); i++) {
            System.out.println((i + 1) + ") " + armorList.get(i).getName());
        }

        System.out.print("\nSelect a Cape (Please enter a number from the list): ");
        String selectionString = scanner.nextLine();
        int selectionInt = Integer.parseInt(selectionString);

        return armorList.get(selectionInt - 1);
    }

    private Booster selectBooster(List<Booster> boosterList, Scanner scanner) {

        System.out.println("\n[ Booster Selection ]");
        System.out.println("--------------------");

        for (int i = 0; i < boosterList.size(); i++) {
            System.out.println((i + 1) + ") " + boosterList.get(i).getName());
        }

        System.out.print("\nSelect a Booster (Please enter a number from the list): ");
        String selectionString = scanner.nextLine();
        int selectionInt = Integer.parseInt(selectionString);

        return boosterList.get(selectionInt - 1);
    }

    private Set<Stratagem> selectStratagems(List<Stratagem> stratagemList, Scanner scanner) {

        System.out.println("\n[ Stratagem Selection ]");
        System.out.println("--------------------");

        Set<Stratagem> selectedStratagemSet = new HashSet<>();  // unique Stratagem

        int numberOfStratagemsSelected = 0;

        while (numberOfStratagemsSelected < 4) {
        // ----- Create List of subtype names to print -----
            System.out.println("\nStratagem types: ");
            Set<String> subTypeSet = new HashSet<>();              // this section needs to repeat up to 4 times so inside while loop
            for (Stratagem stratagem : stratagemList) {
                subTypeSet.add(stratagem.getSubType());
            }

            List<String> subTypeList = new ArrayList<>(subTypeSet);
            for (int i = 0; i < subTypeList.size(); i++) {
                System.out.println((i + 1) + ") " + subTypeList.get(i));
            }

        // ----- User chooses a subtype -----
            System.out.println("\nEnter number to select subtype or enter '0' to finish Stratagem selection process: ");
            String subtypeInput = scanner.nextLine();
            int subtypeInt = Integer.parseInt(subtypeInput);

            if (subtypeInt == 0) {
                break;
            }
            if (subtypeInt < 0 || subtypeInt > subTypeList.size()) {
                System.out.println("Please enter number between 1 and " + subTypeList.size());
                continue;
            }

            String selectedSubtype = subTypeList.get(subtypeInt - 1);
            System.out.println("\nAvailable " + selectedSubtype + ": ");

        // ----- Print available stratagems of that subtype  -----
            int stratagemCount = 1;
            for (Stratagem stratagem: stratagemList) {
                if (stratagem.getSubType().equals(selectedSubtype)) {
                    System.out.println(stratagemCount + ") " + stratagem.getName());
                    stratagemCount++;
                }
            }

        // ----- User selects stratagem of chosen subtype -----
            System.out.println("\nEnter number of stratagem or enter '0' to cancel and view another subtype: ");
            String stratagemInput = scanner.nextLine();
            int stratagemInt = Integer.parseInt(stratagemInput);

            if (stratagemInt == 0) {
                continue;
            }
            if (stratagemInt < 0 || stratagemInt > stratagemList.size()) {
                System.out.println("Please enter number between 1 and " + stratagemList.size());
                continue;
            }

            // -- Use temp counter to match with order stratagemList was printed for User --
            Stratagem selectedStratagem = null;
            int subtypeFoundCount = 0;

            for (Stratagem stratagem : stratagemList) {
                if (stratagem.getSubType().equals(selectedSubtype)) { // condition 1 --> match subtype name
                    subtypeFoundCount++;
                    if (subtypeFoundCount == stratagemInt) {   // condition 2 --> count matches what user entered
                        selectedStratagem = stratagem;
                        break;
                    }
                }
            }

            // -- Check if selectedStratagem Set already has it --
            if (selectedStratagem != null) {
                if (selectedStratagemSet.contains(selectedStratagem)) {
                    System.out.println("\nStratagem was selected already. Please reselect.");
                } else {
                    selectedStratagemSet.add(selectedStratagem);
                    numberOfStratagemsSelected++;
//                    System.out.println("Stratagem selection complete.");
                }
            }

        }
//        System.out.println("returned selectedStratagemSet");
        // -- Confirmation of selection --
        System.out.println("\nStratagems selected: ");
        for (Stratagem stratagem : selectedStratagemSet) {
            System.out.println(stratagem.getName());
        }

        return selectedStratagemSet;
    }




}