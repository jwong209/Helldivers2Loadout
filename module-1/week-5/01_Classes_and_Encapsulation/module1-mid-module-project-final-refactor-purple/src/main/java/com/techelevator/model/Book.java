package com.techelevator.model;

import java.math.BigDecimal;

public class Book {
    private String title;
    private String author;
    private int publishedYear;
    private BigDecimal price;

    /*
     * This is called when making a new book oject
     *      new Book(....);
     */
    public Book(String title, String author, int publishedYear, BigDecimal price) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return title + ": " + author + ": " + publishedYear + ": $" + price.setScale(2);
    }
}
