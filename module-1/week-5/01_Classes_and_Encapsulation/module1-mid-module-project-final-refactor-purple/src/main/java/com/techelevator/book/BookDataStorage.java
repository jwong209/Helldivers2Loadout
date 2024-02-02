package com.techelevator.book;

import com.techelevator.data.Dataset;
import com.techelevator.model.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookDataStorage {

    // The regex string to split the Strings in the dataset.
    private static final String FIELD_DELIMITER = "\\|";

    public static final int TITLE_FIELD = 0;
    public static final int AUTHOR_FIELD = 1;
    public static final int PUBLISHED_YEAR_FIELD = 2;
    public static final int PRICE_FIELD = 3;

    // DMC: Make sure this is private!
    private List<Book> books;

    // DMC: Make this public so other objects can use
    //  Why does this method return an array instead of the books list?
    public Book[] getBooks(){
        return this.books.toArray(new Book[books.size()]);
    }

    public BookDataStorage(){
        loadData();
    }

    private void loadData() {

        this.books = new ArrayList<>();

        String[] dataset = Dataset.load();

        /*
         Requirement: 1
         Populate the instance variables `titles`, `authors`, `publishedYears`,
         and `prices` by splitting each string in the `dataset` array and adding
         the individual fields to the appropriate list.
         See README for additional details.
         */
        for (String s : dataset) {
            String[] fields = s.split(FIELD_DELIMITER);

            String title = fields[TITLE_FIELD];
            String author = fields[AUTHOR_FIELD];
            int publishedYears = Integer.parseInt(fields[PUBLISHED_YEAR_FIELD]);
            BigDecimal price = new BigDecimal(fields[PRICE_FIELD]);

            /*
             * Creating a book object
             */
            Book bookToAdd = new Book(title, author, publishedYears, price);

            this.books.add(bookToAdd);
        }
    }

    /*
     Requirement: 3a
     Complete the `filterByTitle()` method.
     See README for additional details.
     */
    public List<Book> filterByTitle(String filterTitle) {

        return new ArrayList<>();
    }

    /*
     Requirement: 4a
     Complete the `filterByAuthor()` method.
     See README for additional details.
     */
    public List<Book> filterByAuthor(String filterAuthor) {

        return new ArrayList<>();
    }

    /*
     Requirement: 5a
     Complete the `filterByPublishedYear()` method.
     See README for additional details.
     */
    public List<Book> filterByPublishedYear(int filterYear) {

        return new ArrayList<>();
    }

    /*
     Requirement: 6a
     Complete the `filterByPublishedYearRange()` method.
     See README for additional details.
     */
    public List<Book> filterByPublishedYearRange(int filterFromYear, int filterToYear) {

        return new ArrayList<>();
    }

    /*
     Requirement: 7a
     Add the `private List<Integer> findMostRecentBooks()` method.
     See README for additional details.
     */
    public List<Book> findMostRecentBooks() {

        return new ArrayList<>();
    }

    /*
     Requirement: 8a
     Complete the `filterByPrice()` method.
     See README for additional details.
     */
    public List<Book> filterByPrice(double filterPrice) {

        return new ArrayList<>();
    }

    /*
     Requirement: 9a
     Complete the `filterByPriceRange()` method.
     See README for additional details.
     */
    public List<Book> filterByPriceRange(double filterFromPrice, double filterToPrice) {

        return new ArrayList<>();
    }

    /*
     Requirement: 10a
     Add the `private List<Integer> findLeastExpensiveBooks()` method.
     See README for additional details.
     */
    public List<Book> findLeastExpensiveBooks() {

        return new ArrayList<>();
    }
}
