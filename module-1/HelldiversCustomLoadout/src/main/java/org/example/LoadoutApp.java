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

        // ----- Update a log file of last created loadout -----
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
                    log.println("-- " + stratagem.getName());
                }

                log.println("Booster: " + currentLoadout.getBooster().getName());
                log.println("\nSuccessfully created on: " + LocalDateTime.now());
                log.println("------------------------------------------");

            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }

        // ----- Choice to stop infinite loop of creating loadouts -----
            while(true) {
                System.out.println("\nCreate another loadout?  Yes [Y]  No [N]: ");

                String continueChoice = userInput.nextLine();

                if (continueChoice.equalsIgnoreCase("Y")) {
                    willContinue = true;
                    break;
                } else if (continueChoice.equalsIgnoreCase("N")) {
                    willContinue = false;
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter Yes [Y] or [N].");
                }
            }

        }
        System.out.println("---------------------------------------------------------");
    }


}