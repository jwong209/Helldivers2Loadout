package com.techelevator.console;

import com.techelevator.model.Book;
import com.techelevator.book.BookDataStorage;
import com.techelevator.data.Dataset;

import java.util.List;

public class MenuOutput {
    
    private MenuInput input;
    private BookDataStorage bookStorage;
    
    public MenuOutput(MenuInput menuInput, BookDataStorage bookStorage) {
        this.input = menuInput;
        this.bookStorage = bookStorage;
    }

    // UI methods

    public void displayMenu() {

        while (true) {
            // Main menu loop
            printMainMenu();
            int mainMenuSelection = this.input.promptForMenuSelection("Please choose an option: ");
            if (mainMenuSelection == 1) {
                // Display data and subsets loop
                while (true) {
                    printDataAndSubsetsMenu();
                    int dataAndSubsetsMenuSelection = this.input.promptForMenuSelection("Please choose an option: ");

                    Book[] books = bookStorage.getBooks();

                    if (dataAndSubsetsMenuSelection == 1) {
                        displayDataset(Dataset.load());
                    } else if (dataAndSubsetsMenuSelection == 2) {
                        displayTitlesList(books);
                    } else if (dataAndSubsetsMenuSelection == 3) {
                        displayAuthorsList(books);
                    } else if (dataAndSubsetsMenuSelection == 4) {
                        displayPublishedYearsList(books);
                    } else if (dataAndSubsetsMenuSelection == 5) {
                        displayPricesList(books);
                    } else if (dataAndSubsetsMenuSelection == 0) {
                        break;
                    }
                }
            }
            else if (mainMenuSelection == 2) {
                while (true) {
                    printSearchBooksMenu();
                    int searchBooksMenuSelection = this.input.promptForMenuSelection("Please choose an option: ");
                    if (searchBooksMenuSelection == 1) {
                        // Search by title
                        String filterTitle = this.input.promptForString("Enter title: ");
                        /*
                         Requirement: 3b
                         Replace `displayTitlesList(titles)` with calls to the
                         `filterByTitle()` and `displaySearchResults()` methods.
                         */
                        List<Book> foundBooks = this.bookStorage.filterByTitle(filterTitle);
                        displaySearchResults(foundBooks);

                    } else if (searchBooksMenuSelection == 2) {
                        // Search by author
                        String filterAuthor = this.input.promptForString("Enter author: ");
                        /*
                         Requirement: 4b
                         Replace `displayAuthorsList(authors)` with calls to the
                         `filterByAuthor()` and `displaySearchResults()` methods.
                         */
                        List<Book> foundBooks = this.bookStorage.filterByAuthor(filterAuthor);
                        displaySearchResults(foundBooks);

                    } else if (searchBooksMenuSelection == 3) {
                        // Search by published year
                        int filterYear = this.input.promptForPublishedYear("Enter date (YYYY): ");
                        /*
                         Requirement: 5b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYear()` and `displaySearchResults()` methods.
                         */
                        List<Book> foundBooks = this.bookStorage.filterByPublishedYear(filterYear);
                        displaySearchResults(foundBooks);

                    } else if (searchBooksMenuSelection == 4) {
                        // Search by published year range
                        int filterFromYear = this.input.promptForPublishedYear("Enter \"from\" date (YYYY): ");
                        int filterToYear = this.input.promptForPublishedYear("Enter \"to\" date (YYYY): ");
                        /*
                         Requirement: 6b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYearRange()` and `displaySearchResults()` methods.
                         */
                        List<Book> foundBooks = this.bookStorage.filterByPublishedYearRange(filterFromYear, filterToYear);
                        displaySearchResults(foundBooks);

                    } else if (searchBooksMenuSelection == 5) {
                        // Find the most recent books
                        /*
                         Requirement: 7b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `findMostRecentBooks()` and `displaySearchResults()` methods.
                         */
                        List<Book> foundBooks = this.bookStorage.findMostRecentBooks();
                        displaySearchResults(foundBooks);

                    } else if (searchBooksMenuSelection == 6) {
                        // Search by price
                        double filterPrice = this.input.promptForPrice("Enter price: ");
                        /*
                         Requirement: 8b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPrice()` and `displaySearchResults()` methods.
                         */
                        List<Book> foundBooks = this.bookStorage.filterByPrice(filterPrice);
                        displaySearchResults(foundBooks);

                    } else if (searchBooksMenuSelection == 7) {
                        // Search by price range
                        double filterFromPrice= this.input.promptForPrice("Enter \"from\" price: ");
                        double filterToPrice = this.input.promptForPrice("Enter \"to\" price: ");
                        /*
                         Requirement: 9b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPriceRange()` and `displaySearchResults()` methods.
                         */
                        List<Book> foundBooks = this.bookStorage.filterByPriceRange(filterFromPrice, filterToPrice);
                        displaySearchResults(foundBooks);

                    } else if (searchBooksMenuSelection == 8) {
                        // Find the least expensive books
                        /*
                         Requirement: 10b
                         Replace `displayPricesList(prices)` with calls to the
                         `findLeastExpensiveBooks()` and `displaySearchResults()` methods.
                         */
                        List<Book> foundBooks = this.bookStorage.findLeastExpensiveBooks();
                        displaySearchResults(foundBooks);

                    } else if (searchBooksMenuSelection == 0) {
                        break;
                    }
                }
            } else if (mainMenuSelection == 0) {
                break;
            }
        }
    }
    
    /*
     Requirement: 2
     Write the displaySearchResults(List<Integer> indexes) method.
     See README for additional details.
     */
    private void displaySearchResults(List<Book> books) {
        System.out.println("Results");
        System.out.println("-------");
        for (Book eachBook : books) {
            String str = eachBook.getTitle() + ": " + eachBook.getAuthor() + ": " + eachBook.getPublishedYear() + ": $" + eachBook.getPrice();
            System.out.println(str);
        }
        System.out.println();
        input.promptForReturn();
    }

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
        input.promptForReturn();
    }

    private void displayTitlesList(Book[] books) {
        System.out.println("Titles");
        System.out.println("-------");
        for (int i = 0; i < books.length; i++) {
            System.out.println(i + ": " + books[i].getTitle());
        }
        System.out.println();
        input.promptForReturn();
    }

    private void displayAuthorsList(Book[] books) {
        System.out.println("Authors");
        System.out.println("-------");
        for (int i = 0; i < books.length; i++) {
            System.out.println(i + ": " + books[i].getAuthor());
        }
        System.out.println();
        input.promptForReturn();
    }

    private void displayPublishedYearsList(Book[] books) {
        System.out.println("Published Years");
        System.out.println("---------------");
        for (int i = 0; i < books.length; i++) {
            System.out.println(i + ": " + books[i].getPublishedYear());
        }
        System.out.println();
        input.promptForReturn();
    }

    private void displayPricesList(Book[] books) {
        System.out.println("Prices");
        System.out.println("------");
        for (int i = 0; i < books.length; i++) {
            System.out.println(i + ": " + books[i].getPrice());
        }
        System.out.println();
        input.promptForReturn();
    }
}
