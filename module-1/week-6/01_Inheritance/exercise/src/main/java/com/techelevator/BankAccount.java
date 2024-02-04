package com.techelevator;

public class BankAccount {

    private String accountHolderName;
    private String accountNumber;
    private int balance;

    // --------------- Constructor ---------------
    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // --------------- Getter ---------------
    public String getAccountHolderName() {
        return this.accountHolderName;
    }
    public String getAccountNumber() {
        return this.accountNumber;
    }

    public int getBalance() {
        return this.balance;
    }
    // -------------------------------------

    public int deposit(int amountToDeposit) {
        if (amountToDeposit > 0) {
            balance += amountToDeposit;
        }
        return balance;
    }

    public int withdraw(int amountToWithdraw) {
        if (amountToWithdraw > 0) {
            balance -= amountToWithdraw;
        }
        return balance;
    }


}
