package org.helldivers2.controller;

import org.helldivers2.model.Stratagem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StratagemManager {

    private List<Stratagem> stratagemsList = new ArrayList<>();

// ----- Constructor -----
    public StratagemManager() {
        loadStratagems();
    }

// ----- Getters -----
    public List<Stratagem> getStratagemsList() {
        return stratagemsList;

    }

// ----- Methods -----
    private void loadStratagems() {

        String filePath = "data/stratagems";
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNext()) {
                String lineOfText = scanner.nextLine();
                String[] splitLine = lineOfText.split("\\|");

                String name = splitLine[0];
                String subType = splitLine[1];
                String callInTime = splitLine[2];
                String uses = splitLine[3];
                String cooldownTime = splitLine[4];
                String stratagemTraits = splitLine[5];
                Stratagem currentStratagem = new Stratagem(name, callInTime, uses, cooldownTime, stratagemTraits, subType);

                stratagemsList.add(currentStratagem);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

    }

    public Set<Stratagem> selectStratagems(List<Stratagem> stratagemList, Scanner scanner) {

        System.out.println("\n[ Stratagem Selection ]");

        Set<Stratagem> selectedStratagemSet = new HashSet<>();  // unique Stratagem to return
        int numberOfStratagemsSelected = 0;

        while (numberOfStratagemsSelected < 4) {

            List<String> subTypeList = new ArrayList<>();

            for (Stratagem stratagem : stratagemList) {
                if (!subTypeList.contains(stratagem.getSubType())) {
                    subTypeList.add(stratagem.getSubType());
                }
            }

            System.out.println("\nStratagem types: ");
            for (int i = 0; i < subTypeList.size(); i++) {
                System.out.println((i + 1) + ") " + subTypeList.get(i));
            }

            try {
            // ----- User chooses a subtype -----
                System.out.print("\nSelect a type of Stratagem or enter '0' to end Stratagem selection process: ");
                String subtypeInput = scanner.nextLine();
                int subtypeInt = Integer.parseInt(subtypeInput);

                if (subtypeInt == 0) {
                    break;
                }
                if (subtypeInt < 0 || subtypeInt > subTypeList.size()) {
                    System.out.println("[!] Invalid input. Please enter number between 1 and " + subTypeList.size());
                    continue;
                }

                String selectedSubtype = subTypeList.get(subtypeInt - 1);

            // ----- Print available stratagems of that subtype  -----
                System.out.println("\n" + selectedSubtype + " choices: ");
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
                if (stratagemSelectedInt < 0 || stratagemSelectedInt > (stratagemCount - 1)) {
                    System.out.println("[!] Invalid input. Please enter number between 1 and " + (stratagemCount - 1));
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
                        }
                    }
                }

            // -- Check if selectedStratagem Set already has it (unique) --
                if (selectedStratagem != null) {
                    if (selectedStratagemSet.contains(selectedStratagem)) {
                        System.out.println("\n[!] Stratagem was selected already. Please reselect.");
                    } else {
                        selectedStratagemSet.add(selectedStratagem);
                        numberOfStratagemsSelected++;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.print("[!] Invalid input. Please enter a number.\n");
            }

        }
        // -- Print all stratagems selected --
        System.out.println("\nStratagems selected: ");
        for (Stratagem stratagem : selectedStratagemSet) {
            System.out.println(">> " + stratagem.getName() + " <<");
        }

        System.out.println("\n------------------------------------------------------------------------");
        return selectedStratagemSet;
    }
}
