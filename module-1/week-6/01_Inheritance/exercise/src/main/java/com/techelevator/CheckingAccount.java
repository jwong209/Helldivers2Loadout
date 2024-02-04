package com.techelevator;

public class CheckingAccount extends BankAccount{

    // --------------- Constructor ---------------
    public CheckingAccount(String accountHolderName, String accountNumber) { super(accountHolderName, accountNumber); }
    public CheckingAccount(String accountHolderName, String accountNumber, int balance) { super(accountHolderName, accountNumber, balance); }

    // --------------- Override Method ---------------
    @Override
    public int withdraw(int amountToWithdraw) {

        if ((getBalance() - amountToWithdraw) <= -100) {
            return getBalance();
        }

        super.withdraw(amountToWithdraw);

        if (getBalance() < 0 && getBalance() > -100) {
            super.withdraw(10);    // re-examine later
        }

        return getBalance();
    }

}
