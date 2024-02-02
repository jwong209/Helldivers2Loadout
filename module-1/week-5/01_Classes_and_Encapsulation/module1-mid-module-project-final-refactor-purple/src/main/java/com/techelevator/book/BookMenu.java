package com.techelevator.book;

import com.techelevator.book.BookDataStorage;
import com.techelevator.console.MenuInput;
import com.techelevator.console.MenuOutput;

public class BookMenu {

    private BookDataStorage bookStorage;
    private MenuInput menuInput;
    private MenuOutput menuOutput;

    public BookMenu(){
        bookStorage = new BookDataStorage();
        menuInput = new MenuInput();
        menuOutput = new MenuOutput(menuInput, bookStorage);
    }

    public void run() {

        menuOutput.displayMenu();

    }
}
