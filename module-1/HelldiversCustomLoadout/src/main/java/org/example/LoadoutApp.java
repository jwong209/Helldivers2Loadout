package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;

public class LoadoutApp {
    private final Scanner userInput = new Scanner(System.in);

// ----- Managers tasked with populating available lists and selecting items -----
    private WeaponManager weaponManager = new WeaponManager();
    private GrenadeManager grenadeManager = new GrenadeManager();
    private ArmorManager armorManager = new ArmorManager();
    private CapeManager capeManager = new CapeManager();
    private StratagemManager stratagemManager = new StratagemManager();
    private BoosterManager boosterManager = new BoosterManager();

    // ----- Populate lists from files -----
//    private HelmetPopulator helmetPopulator = new HelmetPopulator();
//    private BodyArmorPopulator bodyArmorPopulator = new BodyArmorPopulator();
//    private CapePopulator capePopulator = new CapePopulator();
//    private StratagemPopulator stratagemPopulator = new StratagemPopulator();
//    private BoosterPopulator boosterPopulator = new BoosterPopulator();

// ----- Create lists of available items from Managers -----
    private List<Weapon> availablePrimaryWeapons = weaponManager.getPrimaryWeaponsList();
    private List<Weapon> availableSecondaryWeapons = weaponManager.getSecondaryWeaponsList();
    private List<Grenade> availableGrenades = grenadeManager.getGrenadesList();
    private List<Armor> availableHelmets = armorManager.getHelmetList();
    private List<Armor> availableBodyArmor = armorManager.getBodyArmorList();
    private List<Armor> availableCapes = capeManager.getCapesList();
    private List<Stratagem> availableStratagems = stratagemManager.getStratagemsList();
    private List<Booster> availableBoosters = boosterManager.getBoostersList();
    private List<Loadout> loadouts = new ArrayList<>();                       // Store loadouts


// ----- Getters -----
    public List<Loadout> getLoadouts() {
        return loadouts;
    }

// ----- Methods -----
    public void createLoadout() {

        boolean willContinue = true;

        while (willContinue) {
            System.out.print("\nEnter name for custom loadout: ");
            String loadoutName = userInput.nextLine();

//            Weapon selectedPrimary = selectWeapon("Primary Weapon", availablePrimaryWeapons, userInput);
//            Weapon selectedSecondary = selectWeapon("Secondary Weapon", availableSecondaryWeapons, userInput);
//            Grenade selectedGrenade = selectGrenade(availableGrenades, userInput);
//            Armor selectedHelmet = selectArmor("Helmet", availableHelmets, userInput);
//            Armor selectedBodyArmor = selectArmor("Body Armor", availableBodyArmor, userInput);
            Weapon selectedPrimary = weaponManager.selectWeapon("Primary Weapon", availablePrimaryWeapons, userInput);
            Weapon selectedSecondary = weaponManager.selectWeapon("Secondary Weapon", availableSecondaryWeapons, userInput);
            Grenade selectedGrenade = grenadeManager.selectGrenade(availableGrenades, userInput);
            Armor selectedHelmet = armorManager.selectArmor("Helmet", availableHelmets, userInput);
            Armor selectedBodyArmor = armorManager.selectArmor("Body Armor", availableBodyArmor, userInput);
            Armor selectedCape = capeManager.selectCape(availableCapes, userInput);
            Set<Stratagem> selectedStratagems = stratagemManager.selectStratagems(availableStratagems, userInput);
            Booster selectedBooster = boosterManager.selectBooster(availableBoosters, userInput);

            Loadout customLoadout = new Loadout(loadoutName, selectedPrimary, selectedSecondary, selectedGrenade, selectedHelmet, selectedBodyArmor, selectedCape, selectedBooster, selectedStratagems);
            loadouts.add(customLoadout);

        // ----- Choice to stop infinite loop of creating loadouts -----
            System.out.print("\nCreate another loadout? (Y/N): ");
            String continueChoice = userInput.nextLine();

            if (continueChoice.equals("Y")) {
                willContinue = true;
            } else if (continueChoice.equals("N")) {
                willContinue = false;
            }

        // Update a log file of last created loadout
            String logPath = "loadouts.log";
            File logFile = new File(logPath);

            try (PrintWriter log = new PrintWriter(new FileOutputStream(logFile, true))) {

                Loadout currentLoadout = loadouts.get(loadouts.size() - 1);

                log.println("[   Loadout: " + currentLoadout.getName() + "   ]");
                log.println("Primary Weapon: " + currentLoadout.getPrimaryWeapon().getName());
                log.println("Secondary Weapon: " + currentLoadout.getSecondaryWeapon().getName());
                log.println("Grenade: " + currentLoadout.getGrenade().getName());
                log.println("Helmet: " + currentLoadout.getHelmet().getName());
                log.println("Body Armor: " + currentLoadout.getBodyArmor().getName());
                log.println("Cape: " + currentLoadout.getCape().getName());
                log.println("Stratagems: ");

                for (Stratagem stratagem : currentLoadout.getStratagems()) {
                    log.println("- " + stratagem.getName());
                }

                log.println("Booster: " + currentLoadout.getBooster().getName());
                log.println("\nSuccessfully created on: " + LocalDateTime.now());
                log.println("------------------------------------------");

            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
            System.out.println("---------------------------------------------------------");
        }

    }
/*
    private Grenade selectGrenade(List<Grenade> grenadeList, Scanner scanner) {

        while (true) {
            System.out.println("\n[ Grenade Selection ]\n");
            System.out.println("Grenades types: ");

        // ----- Create list of unique subtype names -----
            List<String> subTypeList = new ArrayList<>();

            for (Grenade grenade : grenadeList) {
                if (!subTypeList.contains(grenade.getSubType())) {
                    subTypeList.add(grenade.getSubType());
                }
            }

            for (int i = 0; i < subTypeList.size(); i++) {
                System.out.println((i + 1) + ") " + subTypeList.get(i));
            }

        // ----- User chooses a subtype -----
            System.out.print("\nSelect a type of Grenade or enter '0' to reselect a type: ");
            String subtypeSelected = scanner.nextLine();
            int subtypeInt = Integer.parseInt(subtypeSelected);

            if (subtypeInt == 0) {        // reselection
                continue;
            }
            if (subtypeInt < 0 || subtypeInt > subTypeList.size()) {
                System.out.println("Please enter number between 1 and " + subTypeList.size());
                continue;
            }

            String selectedSubType = subTypeList.get(subtypeInt - 1);
            System.out.println("\nAvailable " + selectedSubType);

        // ----- Print available of that subtype  -----
            System.out.println("  Name  |  Damage  |  Penetration  |  Outer Radius  |  Fuse Time");
            System.out.println("-------------------------------------------------------------------");

            int grenadeCount = 1;
            for (Grenade grenade : grenadeList) {
                if (grenade.getSubType().equals(selectedSubType)) {
                    System.out.println(grenadeCount + ") " + grenade.getName() + "  |  " + grenade.getDamage() + "  |  " + grenade.getPenetration() + "  |  " + grenade.getOuterRadius() + "  |  " + grenade.getFuseTime());
                    grenadeCount++;
                }
            }

        // ----- User selects of chosen subtype -----
            System.out.print("\nSelect a Grenade or enter '0' to reselect: ");
            String grenadeSelected = scanner.nextLine();
            int grenadeSelectInt = Integer.parseInt(grenadeSelected);

            if (grenadeSelectInt == 0) {
                continue;
            }
            if (grenadeSelectInt < 0 || grenadeSelectInt > grenadeList.size()) {
                System.out.println("Please enter number between 1 and " + grenadeList.size());
                continue;
            }

        // -- Use temp counter to match with order List was printed for User --
            int subtypeFoundCount = 1;
            for (Grenade grenade : grenadeList) {
                if (grenade.getSubType().equals(selectedSubType)) {
                    if (subtypeFoundCount == grenadeSelectInt) {
                        System.out.println(">> " + grenade.getName() + " selected <<");
                        return grenade;
                    }
                    subtypeFoundCount++;
                }
            }
        }

    }

 */
/*
    private Armor selectArmor(String armorType, List<Armor> armorList, Scanner scanner) {

        while (true) {
            System.out.println("\n[ " + armorType + " Selection ]\n");
            System.out.println("" + armorType + " types: ");

            // ----- Create list of unique subtype names -----
            List<String> subTypeList = new ArrayList<>();

            for (Armor armor : armorList) {
                if (!subTypeList.contains(armor.getSubType())) {
                    subTypeList.add(armor.getSubType());
                }
            }

            for (int i = 0; i < subTypeList.size(); i++) {
                System.out.println((i + 1) + ") " + subTypeList.get(i));
            }

        // ----- User chooses a subtype -----
            System.out.print("\nSelect a type of the subtype of " + armorType + " or enter '0' to reselect a type: ");
            String subtypeSelected = scanner.nextLine();
            int subtypeInt = Integer.parseInt(subtypeSelected);

            if (subtypeInt == 0) {
                continue;
            }

            String selectedSubType = subTypeList.get(subtypeInt - 1);
            System.out.println("\nAvailable " + selectedSubType);

        // ----- Print available of that subtype  -----
            System.out.println("  Name  |  Armor Rating  |  Speed  |  Stamina Regen  |  Armor Passive");
            System.out.println("------------------------------------------------------------------------");

            int armorCount = 1;
            for (Armor armor : armorList) {
                if (armor.getSubType().equals(selectedSubType)) {
                    System.out.println(armorCount + ") " + armor.getName() + "  |  " + armor.getArmorRating() + "  |  " + armor.getSpeed() + "  |  " + armor.getStaminaRegen() + "  |  " + armor.getArmorPassive());
                    armorCount++;
                }
            }

        // ----- User selects of chosen subtype -----
            System.out.println("\nSelect a " + armorType + " or enter '0' to reselect: ");
            String armorSelected = scanner.nextLine();
            int armorSelectedInt = Integer.parseInt(armorSelected);

            if (armorSelectedInt == 0) {
                continue;
            }
            if (armorSelectedInt < 0 || armorSelectedInt > armorList.size()) {
                System.out.println("Please enter number between 1 and " + armorList.size());
                continue;
            }

        // -- Use temp counter to match with order List was printed for User --
            int subtypeFoundCount = 1;
            for (Armor armor : armorList) {
                if (armor.getSubType().equals(selectedSubType)) {
                    if (subtypeFoundCount == armorSelectedInt) {
                        System.out.println(">> " + armor.getName() + " selected <<");
                        return armor;
                    }
                    subtypeFoundCount++;
                }
            }
        }

    }

 */
/*
    private Armor selectCape(List<Armor> armorList, Scanner scanner) {

        System.out.println("\n[ Cape Selection ]\n");

        System.out.println("  Name  |  Armor Rating  |  Speed  |  Stamina Regen  |  Armor Passive");
        System.out.println("------------------------------------------------------------------------");

        for (int i = 0; i < armorList.size(); i++) {
            System.out.println((i + 1) + ") " + armorList.get(i).getName() + "  |  " + armorList.get(i).getArmorRating() + "  |  " + armorList.get(i).getSpeed() + "  |  " + armorList.get(i).getStaminaRegen() + "  |  " + armorList.get(i).getArmorPassive());
        }

        System.out.print("\nSelect a Cape: ");
        String selectionString = scanner.nextLine();
        int selectionInt = Integer.parseInt(selectionString);

        Armor selectedCape = armorList.get(selectionInt - 1);
        System.out.println(">> " + selectedCape.getName() + " selected <<");
        return selectedCape;
    }

 */
/*
    private Booster selectBooster(List<Booster> boosterList, Scanner scanner) {

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
        return selectedBooster;
    }

 */
/*
    private Set<Stratagem> selectStratagems(List<Stratagem> stratagemList, Scanner scanner) {

        System.out.println("\n[ Stratagem Selection ]\n");

        Set<Stratagem> selectedStratagemSet = new HashSet<>();  // unique Stratagem to return
        int numberOfStratagemsSelected = 0;

        while (numberOfStratagemsSelected < 4) {

            List<String> subTypeList = new ArrayList<>();

            for (Stratagem stratagem : stratagemList) {
                if (!subTypeList.contains(stratagem.getSubType())) {
                    subTypeList.add(stratagem.getSubType());
                }
            }

            System.out.println("Stratagem types: ");
            for (int i = 0; i < subTypeList.size(); i++) {
                System.out.println((i + 1) + ") " + subTypeList.get(i));
            }

        // ----- User chooses a subtype -----
            System.out.println("\nSelect a type of Stratagem enter '0' to end Stratagem selection process: ");
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
            System.out.println("  Name  |  Call-In Time  |  Uses  |  Cooldown Time  |  Stratagem Traits");
            System.out.println("--------------------------------------------------------------------------");
            int stratagemCount = 1;
            for (Stratagem stratagem: stratagemList) {
                if (stratagem.getSubType().equals(selectedSubtype)) {
                    System.out.println(stratagemCount + ") " + stratagem.getName() + "  |  " + stratagem.getCallInTime() + "  |  " + stratagem.getUses() + "  |  " + stratagem.getCooldownTime() + "  |  " + stratagem.getStratagemTraits());
                    stratagemCount++;
                }
            }

        // ----- User selects stratagem of chosen subtype -----
            System.out.print("\nSelect a Stratagem or enter '0' to reselect: ");
            String stratagemSelected = scanner.nextLine();
            int stratagemSelectedInt = Integer.parseInt(stratagemSelected);

            if (stratagemSelectedInt == 0) {
                continue;
            }
            if (stratagemSelectedInt < 0 || stratagemSelectedInt > stratagemList.size()) {
                System.out.println("Please enter number between 1 and " + stratagemList.size());
                continue;
            }

        // -- Use temp counter to match with order stratagemList was printed for User --
            Stratagem selectedStratagem = null;
            int subtypeFoundCount = 0;

            for (Stratagem stratagem : stratagemList) {
                if (stratagem.getSubType().equals(selectedSubtype)) { // condition 1 --> match subtype name
                    subtypeFoundCount++;
                    if (subtypeFoundCount == stratagemSelectedInt) {   // condition 2 --> count matches what user entered
                        selectedStratagem = stratagem;
                        System.out.println(">> " + selectedStratagem.getName() + " selected <<");
//                        break;
                    }
                }
            }

        // -- Check if selectedStratagem Set already has it (unique) --
            if (selectedStratagem != null) {
                if (selectedStratagemSet.contains(selectedStratagem)) {
                    System.out.println("\n[!] Stratagem was selected already. Please reselect. [!]");
                } else {
                    selectedStratagemSet.add(selectedStratagem);
                    numberOfStratagemsSelected++;
                }
            }

        }
        // -- Confirmation of selection --
        System.out.println("\nStratagems selected: ");
        for (Stratagem stratagem : selectedStratagemSet) {
            System.out.println(stratagem.getName());
        }

        return selectedStratagemSet;
    }

 */

}