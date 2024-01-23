import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    // The regex string to split the Strings in the dataset.
    private static final String FIELD_DELIMITER = "\\|";

    private static final int NAME_FIELD = 0;
    private static final int HOUSE_FIELD = 1;
    private static final int AGE_FIELD = 2;

    private final Scanner keyboard = new Scanner(System.in);

    private List<String> names = new ArrayList<>();
    private List<String> houses = new ArrayList<>();
    private List<Integer> ages = new ArrayList<>();

    public static void main(String[] args) {

        App app = new App();
        app.loadData();
        app.run();
    }
    private void loadData() {

        String[] dataset = Dataset.load();

        // TODO: populate arrays
        for(String eachEntry : dataset){
            String[] entryData = eachEntry.split(FIELD_DELIMITER);

            // Add to lists
            names.add(entryData[NAME_FIELD]);
            houses.add(entryData[HOUSE_FIELD]);
            ages.add(Integer.parseInt(entryData[AGE_FIELD]));
        }
        System.out.println();
    }

    private void run() {

        while (true) {
            // Main menu loop
            printMainMenu();
            int mainMenuSelection = promptForMenuSelection("Please choose an option: ");
            if (mainMenuSelection == 1) {
                // Display data and subsets loop
                while (true) {
                    printDataAndSubsetsMenu();
                    int dataAndSubsetsMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (dataAndSubsetsMenuSelection == 1) {
                        displayDataset(Dataset.load());
                    } else if (dataAndSubsetsMenuSelection == 2) {
                        displayNamesList(names);
                    } else if (dataAndSubsetsMenuSelection == 3) {
                        displayHousesList(houses);
                    } else if (dataAndSubsetsMenuSelection == 4) {
                        displayAgesList(ages);
                    } else if (dataAndSubsetsMenuSelection == 0) {
                        break;
                    }
                }
            }
            else if (mainMenuSelection == 2) {
                while (true) {
                    printSearchWizardMenu();
                    int searchWizardMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (searchWizardMenuSelection == 1) {
                        // Search by title
                        String filterName = promptForString("Enter name: ");

                        // TODO: Apply Filter

                        //displayWizards(new ArrayList<Integer>());

                    } else if (searchWizardMenuSelection == 2) {

                        // 1. Get user input on which house to search for.
                        String filterHouses = promptForString("Enter houses: ");

                        // TODO: 2. Apply Filter using the user selection
                        List<Integer> indexesThatMatchUserInput = filterByHouse(filterHouses);

                        displayWizards(indexesThatMatchUserInput);

                    } else if (searchWizardMenuSelection == 4) {
                        // Search by published year range
                        int filterAge = promptForAge("Enter age: ");

                        // TODO: Apply Filter

                        //displayWizards(new ArrayList<Integer>());

                    } else if (searchWizardMenuSelection == 0) {
                        break;
                    }
                }
            } else if (mainMenuSelection == 0) {
                break;
            }
        }
    }

    /*
     * TODO: Display wizards based on index
     */
    //      N/A                 the subset of wizards to display information for
    private void displayWizards(List<Integer> wizardIndexes){

        // Map the indexes to the relevent data in the 3 lists

        // We have a list with 3, 4, 5 indexes [3,4,5]
        // 1. Go through all the indexes in the input parameter
        for(Integer eachWizardIndex : wizardIndexes){

            // 2. Get the name, house, and age information from the index
            String name = names.get(eachWizardIndex);
            String house = houses.get(eachWizardIndex);
            int age = ages.get(eachWizardIndex);

            // 3. Print ALL the information on the wizard
            System.out.println("Wizard " + name + ", is in house: " + house + ", and is " + age + " years old.");
        }
    }

    /*
     * TODO: Filter!
     */
    private List<Integer> filterByName(String filterName) {
        return null;
    }

    //      list of indexes                   "Hufflepuff", "Ravenclaw"
    private List<Integer> filterByHouse(String filterHouse) {

        List<Integer> filteredIndexes = new ArrayList<>();

        // Find matching house names for the user selection (filterHouse)

        // 1. Loop over all the houses to find the indexes that match Hufflepuff
        for(int i = 0; i < houses.size(); i++){
            String eachHouse = houses.get(i);

            // 2. Check if the house matches the user selection (filterHouse)
            if(eachHouse.equalsIgnoreCase(filterHouse)){

                // 3. Add the index to my list to return
                filteredIndexes.add(i);
            }
        }

        // Should return a list with 3, 4, 5 (Hufflepuff)
        return filteredIndexes;
    }

    private List<Integer> filterByAge(int filterAge) {
        return null;
    }

    // UI methods

    private void printMainMenu() {
        System.out.println("1: Display data and subsets");
        System.out.println("2: Search wizards");
        System.out.println("0: Exit");
        System.out.println();
    }

    private void printDataAndSubsetsMenu() {
        System.out.println("1: Display dataset");
        System.out.println("2: Display names");
        System.out.println("3: Display houses");
        System.out.println("4: Display ages");
        System.out.println("0: Return to main menu");
        System.out.println();
    }

    private void printSearchWizardMenu() {
        System.out.println("1: Search by name");
        System.out.println("2: Search by house");
        System.out.println("3: Search by age");
        System.out.println("0: Return to main menu");
        System.out.println();
    }

    private void displayDataset(String[] dataset) {
        System.out.println("Dataset");
        System.out.println("-------");
        for (String data : dataset) {
            System.out.println(data);
        }
        System.out.println();
        promptForReturn();
    }

    private void displayNamesList(List<String> names) {
        System.out.println("Names");
        System.out.println("-------");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(i + ": " + names.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayHousesList(List<String> houses) {
        System.out.println("Houses");
        System.out.println("-------");
        for (int i = 0; i < houses.size(); i++) {
            System.out.println(i + ": " + houses.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayAgesList(List<Integer> ages) {
        System.out.println("Ages");
        System.out.println("---------------");
        for (int i = 0; i < ages.size(); i++) {
            System.out.println(i + ": " + ages.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private int promptForMenuSelection(String prompt) {
        System.out.print(prompt);
        int menuSelection;
        try {
            menuSelection = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    private String promptForString(String prompt) {
        System.out.print(prompt);
        return keyboard.nextLine();
    }

    private int promptForAge(String prompt) {
        int year;
        while (true) {
            System.out.println(prompt);
            try {
                year = Integer.parseInt(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The age provided is not well-formed.");
            }
        }
        return year;
    }

    private void promptForReturn() {
        System.out.println("Press RETURN to continue.");
        keyboard.nextLine();
    }
}
