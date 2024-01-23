package com.techelevator;

import java.math.BigDecimal;
import java.util.*;

public class App {

    // The regex string to split the Strings in the dataset.
    private static final String FIELD_DELIMITER = "\\|";

    private static final int TITLE_FIELD = 0;
    private static final int AUTHOR_FIELD = 1;
    private static final int PUBLISHED_YEAR_FIELD = 2;
    private static final int PRICE_FIELD = 3;

    private final Scanner keyboard = new Scanner(System.in);

    private List<String> titles = new ArrayList<>();
    private List<String> authors = new ArrayList<>();
    private List<Integer> publishedYears = new ArrayList<>();
    private List<BigDecimal> prices = new ArrayList<>();

    //  ----------------------------------------  Created variables  ----------------------------------------
    List<Integer> foundIndexes = new ArrayList<>();   // created by me; use as arguments in displaySearchResults()
    int primaryField = 0;   // created for Challenge; pass into displaySearchResults() and sortSearchResults()
    List<String> newSortedTitles = new ArrayList<>();
    List<String> newSortedAuthors = new ArrayList<>();
    List<Integer> newSortedPublishedYears = new ArrayList<>();
    List<BigDecimal> newSortedPrices = new ArrayList<>();
    //  ------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {

        App app = new App();
        app.loadData();
        app.run();

    }

    private void loadData() {

        String[] dataset = Dataset.load();

        /*
         Requirement: 1
         Populate the instance variables `titles`, `authors`, `publishedYears`,
         and `prices` by splitting each string in the `dataset` array and adding
         the individual fields to the appropriate list.
         See README for additional details.
         */

        // Iterate through all strings, split by the delimiter provided
        for (String data : dataset) {
            String[] splitData = data.split(FIELD_DELIMITER);

            // Since they are strings, must convert strings into appropriate types
            // With newly constructed split-array, assign each element to categories
            titles.add(splitData[TITLE_FIELD]);
            authors.add(splitData[AUTHOR_FIELD]);
            publishedYears.add(Integer.parseInt(splitData[PUBLISHED_YEAR_FIELD]));

            // Convert String into BigDecimal before assigning to prices list
            BigDecimal price = new BigDecimal(splitData[PRICE_FIELD]);
            prices.add(price);
        }


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
                        displayTitlesList(titles);
                    } else if (dataAndSubsetsMenuSelection == 3) {
                        displayAuthorsList(authors);
                    } else if (dataAndSubsetsMenuSelection == 4) {
                        displayPublishedYearsList(publishedYears);
                    } else if (dataAndSubsetsMenuSelection == 5) {
                        displayPricesList(prices);
                    } else if (dataAndSubsetsMenuSelection == 0) {
                        break;
                    }
                }
            }
            else if (mainMenuSelection == 2) {
                while (true) {
                    printSearchBooksMenu();
                    int searchBooksMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (searchBooksMenuSelection == 1) {
                        // Search by title
                        String filterTitle = promptForString("Enter title: ");
                        /*
                         Requirement: 3b
                         Replace `displayTitlesList(titles)` with calls to the
                         `filterByTitle()` and `displaySearchResults()` methods.
                         */
//                        displayTitlesList(titles);
                        filterByTitle(filterTitle);
                        displaySearchResults(foundIndexes, primaryField);
                    } else if (searchBooksMenuSelection == 2) {
                        // Search by author
                        String filterAuthor = promptForString("Enter author: ");
                        /*
                         Requirement: 4b
                         Replace `displayAuthorsList(authors)` with calls to the
                         `filterByAuthor()` and `displaySearchResults()` methods.
                         */
//                        displayAuthorsList(authors);
                        filterByAuthor(filterAuthor);
                        displaySearchResults(foundIndexes, primaryField);
                    } else if (searchBooksMenuSelection == 3) {
                        // Search by published year
                        int filterYear = promptForPublishedYear("Enter date (YYYY): ");
                        /*
                         Requirement: 5b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYear()` and `displaySearchResults()` methods.
                         */
//                        displayPublishedYearsList(publishedYears);
                        filterByPublishedYear(filterYear);
                        displaySearchResults(foundIndexes, primaryField);
                    } else if (searchBooksMenuSelection == 4) {
                        // Search by published year range
                        int filterFromYear = promptForPublishedYear("Enter \"from\" date (YYYY): ");
                        int filterToYear = promptForPublishedYear("Enter \"to\" date (YYYY): ");
                        /*
                         Requirement: 6b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYearRange()` and `displaySearchResults()` methods.
                         */
//                        displayPublishedYearsList(publishedYears);
                        filterByPublishedYearRange(filterFromYear, filterToYear);
                        displaySearchResults(foundIndexes, primaryField);
                    } else if (searchBooksMenuSelection == 5) {
                        // Find the most recent books
                        /*
                         Requirement: 7b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `findMostRecentBooks()` and `displaySearchResults()` methods.
                         */
//                        displayPublishedYearsList(publishedYears);
                        findMostRecentBooks();
                        displaySearchResults(foundIndexes, primaryField);
                    } else if (searchBooksMenuSelection == 6) {
                        // Search by price
                        double filterPrice = promptForPrice("Enter price: ");
                        /*
                         Requirement: 8b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPrice()` and `displaySearchResults()` methods.
                         */
//                        displayPricesList(prices);
                        filterByPrice(filterPrice);
                        displaySearchResults(foundIndexes, primaryField);
                    } else if (searchBooksMenuSelection == 7) {
                        // Search by price range
                        double filterFromPrice= promptForPrice("Enter \"from\" price: ");
                        double filterToPrice = promptForPrice("Enter \"to\" price: ");
                        /*
                         Requirement: 9b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPriceRange()` and `displaySearchResults()` methods.
                         */
//                        displayPricesList(prices);
                        filterByPriceRange(filterFromPrice, filterToPrice);
                        displaySearchResults(foundIndexes, primaryField);
                    } else if (searchBooksMenuSelection == 8) {
                        // Find the least expensive books
                        /*
                         Requirement: 10b
                         Replace `displayPricesList(prices)` with calls to the
                         `findLeastExpensiveBooks()` and `displaySearchResults()` methods.
                         */
//                        displayPricesList(prices);
                        findLeastExpensiveBooks();
                        displaySearchResults(foundIndexes, primaryField);
                    } else if (searchBooksMenuSelection == 0) {
                        break;
                    }
                }
            } else if (mainMenuSelection == 0) {
                break;
            }
        }

    }

    private void sortSearchResults(List<Integer> indexes, int primaryField) {  // Challenge #2

        if (primaryField == TITLE_FIELD) {
            for (Integer entry : indexes) {
                String sortedTitle = titles.get(entry);
                newSortedTitles.add(sortedTitle);
            }
            Collections.sort(newSortedTitles);    // sort lists after obtaining titles, cannot sort foundIndexes since that sorts int and not alphabetical title names
        } else if (primaryField == AUTHOR_FIELD) {
            for (Integer entry : indexes) {
                String sortedAuthor = authors.get(entry);
                newSortedAuthors.add(sortedAuthor);
            }
            Collections.sort(newSortedAuthors);
        } else if (primaryField == PUBLISHED_YEAR_FIELD) {
            for (Integer entry : indexes) {
                Integer sortedYear = publishedYears.get(entry);
                newSortedPublishedYears.add(sortedYear);
            }
            Collections.sort(newSortedPublishedYears);
        } else {
            for (Integer entry : indexes) {
                BigDecimal sortedPrice = prices.get(entry);
                newSortedPrices.add(sortedPrice);
            }
            Collections.sort(newSortedPrices);
        }

    }

    /*
     Requirement: 2
     Write the displaySearchResults(List<Integer> indexes) method.
     See README for additional details.
     */

    private void displaySearchResults(List<Integer> indexes, int primaryField) {

        sortSearchResults(foundIndexes, primaryField); // Challenge #2, updated from Challenge #1

        if (primaryField == TITLE_FIELD) {
            for (String title : newSortedTitles) {
                System.out.println(title + ": " + authors.get(titles.indexOf(title)) + ": " + publishedYears.get(titles.indexOf(title)) + ": " + prices.get(titles.indexOf(title)));
            }
        }
        if (primaryField == AUTHOR_FIELD) {
            for (String author : newSortedAuthors) {
                System.out.println(author + ": " + titles.get(authors.indexOf(author)) + ": " + + publishedYears.get(authors.indexOf(author)) + ": " + prices.get(authors.indexOf(author)));
            }
        }
        if (primaryField == PUBLISHED_YEAR_FIELD) {
            for (Integer year : newSortedPublishedYears) {
                System.out.println(year + ": " + titles.get(publishedYears.indexOf(year)) + ": " + authors.get(publishedYears.indexOf(year)) + ": " + prices.get(publishedYears.indexOf(year)));
            }
        }
        if (primaryField == PRICE_FIELD){
            for (BigDecimal price : newSortedPrices) {
                System.out.println(price + ": " + titles.get(prices.indexOf(price)) + ": " + authors.get(prices.indexOf(price)) + ": " + publishedYears.get(prices.indexOf(price)));
            }
        }

        System.out.println();  // Extra empty line just for visual separation

/*
        // Challenge #1; ---------------------------------------------------------------(old)
        if (primaryField == TITLE_FIELD) {
            for (Integer index : indexes) {
                System.out.println(titles.get(index) + ": " + authors.get(index) + ": " + publishedYears.get(index) + ": " + prices.get(index));
            }
        } else if (primaryField == AUTHOR_FIELD) {
            for (Integer index : indexes) {
                System.out.println(authors.get(index) + ": " + titles.get(index) + ": " + + publishedYears.get(index) + ": " + prices.get(index));
            }
        } else if (primaryField == PUBLISHED_YEAR_FIELD) {
            for (Integer index : indexes) {
                System.out.println(publishedYears.get(index) + ": " + titles.get(index) + ": " + authors.get(index) + ": " + prices.get(index));
            }
        } else {
            for (Integer index : indexes) {
                System.out.println(prices.get(index) + ": " + titles.get(index) + ": " + authors.get(index) + ": " + publishedYears.get(index));
            }
        }

        /*   original code created at start -----  (old)
        for (Integer index : indexes) {
            System.out.println(titles.get(index) + ": " + authors.get(index) + ": " + publishedYears.get(index) + ": " + prices.get(index));
        }
         */
        newSortedTitles.clear();
        newSortedAuthors.clear();
        newSortedPrices.clear();
        newSortedPublishedYears.clear();
        foundIndexes.clear();  // Need to clear list after every search or it will keep adding up for subsequent searches
    }

    /*
     Requirement: 3a
     Complete the `filterByTitle()` method.
     See README for additional details.
     */

    private List<Integer> filterByTitle(String filterTitle) {
        // If the list contains filterTitle, then add that index to foundIndexes list
        for (int i = 0; i < titles.size(); i++) {
            String title = titles.get(i);
            if (title.toLowerCase().contains(filterTitle.toLowerCase())) {   // account for case insensitivity
                foundIndexes.add(i);
            }
        }
        primaryField = TITLE_FIELD;  // Challenge
        return foundIndexes;
    }

    /*
     Requirement: 4a
     Complete the `filterByAuthor()` method.
     See README for additional details.
     */
    private List<Integer> filterByAuthor(String filterAuthor) {
        for (int i = 0; i < authors.size(); i++) {
            String author = authors.get(i);
            if (author.toLowerCase().contains(filterAuthor.toLowerCase())) {
                foundIndexes.add(i);
            }
        }
        primaryField = AUTHOR_FIELD;  // Challenge
        return foundIndexes;
    }

    /*
     Requirement: 5a
     Complete the `filterByPublishedYear()` method.
     See README for additional details.
     */
    private List<Integer> filterByPublishedYear(int filterYear) {
        for (int i = 0; i < publishedYears.size(); i++) {
            Integer publishedYear = publishedYears.get(i);
            if (publishedYear == filterYear) {
                foundIndexes.add(i);
            }
        }
        primaryField = PUBLISHED_YEAR_FIELD;  // Challenge
        return foundIndexes;
    }

    /*
     Requirement: 6a
     Complete the `filterByPublishedYearRange()` method.
     See README for additional details.
     */
    private List<Integer> filterByPublishedYearRange(int filterFromYear, int filterToYear) {
        for (int i = 0; i < publishedYears.size(); i++) {
            Integer publishedYear = publishedYears.get(i);
            if (publishedYear >= filterFromYear && publishedYear <= filterToYear) {
                foundIndexes.add(i);
            }
        }
        primaryField = PUBLISHED_YEAR_FIELD;  // Challenge
        return foundIndexes;
    }

    /*
     Requirement: 7a
     Add the `private List<Integer> findMostRecentBooks()` method.
     See README for additional details.
     */
    private List<Integer> findMostRecentBooks() {
        Integer mostRecentYear = Collections.max(publishedYears);

        for (int i = 0; i < publishedYears.size(); i++) {
            if (publishedYears.get(i) == mostRecentYear) {
                foundIndexes.add(i);
            }
        }
        primaryField = PUBLISHED_YEAR_FIELD;  // Challenge
        return foundIndexes;
    }

    /*
     Requirement: 8a
     Complete the `filterByPrice()` method.
     See README for additional details.
     */
    private List<Integer> filterByPrice(double filterPrice) {
        for (int i = 0; i < prices.size(); i++) {
            double price = prices.get(i).doubleValue();  // Convert each price from BigDecimal into double
            if (price <= filterPrice) {
                foundIndexes.add(i);
            }
        }
        primaryField = PRICE_FIELD;  // Challenge
        return foundIndexes;
    }

    /*
     Requirement: 9a
     Complete the `filterByPriceRange()` method.
     See README for additional details.
     */
    private List<Integer> filterByPriceRange(double filterFromPrice, double filterToPrice) {
        for (int i = 0; i < prices.size(); i++) {
            double price = prices.get(i).doubleValue();  // BigDecimal into double
            if (price >= filterFromPrice && price <= filterToPrice) {
                foundIndexes.add(i);
            }
        }
        primaryField = PRICE_FIELD;  // Challenge
        return foundIndexes;
    }

    /*
     Requirement: 10a
     Add the `private List<Integer> findLeastExpensiveBooks()` method.
     See README for additional details.
     */
    private List<Integer> findLeastExpensiveBooks() {
        double leastExpensive = Double.MAX_VALUE;

        for (int i = 0; i < prices.size(); i++) {
            double price = prices.get(i).doubleValue();

            if (price <= leastExpensive) {
                leastExpensive = price;
            }
        }

        for (int i = 0; i < prices.size(); i++) {
            double price = prices.get(i).doubleValue();
            if (price == leastExpensive) {
                foundIndexes.add(i);
            }
        }

//        primaryField = PRICE_FIELD;  // Challenge
        return foundIndexes;
    }

    // UI methods

    private void printMainMenu() {
        System.out.println("1: Display data and subsets");
        System.out.println("2: Search books");
        System.out.println("0: Exit");
        System.out.println();
    }

    private void printDataAndSubsetsMenu() {
        System.out.println("1: Display dataset");
        System.out.println("2: Display titles");
        System.out.println("3: Display authors");
        System.out.println("4: Display published years");
        System.out.println("5: Display prices");
        System.out.println("0: Return to main menu");
        System.out.println();
    }

    private void printSearchBooksMenu() {
        System.out.println("1: Search by title");
        System.out.println("2: Search by author");
        System.out.println("3: Search by published year");
        System.out.println("4: Search by published year range");
        System.out.println("5: Find most recent books");
        System.out.println("6: Search by price");
        System.out.println("7: Search by price range");
        System.out.println("8: Find least expensive books");
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

    private void displayTitlesList(List<String> titles) {
        System.out.println("Titles");
        System.out.println("-------");
        for (int i = 0; i < titles.size(); i++) {
            System.out.println(i + ": " + titles.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayAuthorsList(List<String> authors) {
        System.out.println("Authors");
        System.out.println("-------");
        for (int i = 0; i < authors.size(); i++) {
            System.out.println(i + ": " + authors.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayPublishedYearsList(List<Integer> publishedYears) {
        System.out.println("Published Years");
        System.out.println("---------------");
        for (int i = 0; i < publishedYears.size(); i++) {
            System.out.println(i + ": " + publishedYears.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayPricesList(List<BigDecimal> prices) {
        System.out.println("Prices");
        System.out.println("------");
        for (int i = 0; i < prices.size(); i++) {
            System.out.println(i + ": " + prices.get(i));
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

    private int promptForPublishedYear(String prompt) {
        int year;
        while (true) {
            System.out.println(prompt);
            try {
                year = Integer.parseInt(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The year provided is not well-formed. It must be YYYY.");
            }
        }
        return year;
    }

    private double promptForPrice(String prompt) {
        double price;
        while (true) {
            System.out.println(prompt);
            try {
                price = Double.parseDouble(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The price provided is not a valid monetary value.");
            }
        }
        return price;
    }

    private void promptForReturn() {
        System.out.println("Press RETURN to continue.");
        keyboard.nextLine();
    }
}
