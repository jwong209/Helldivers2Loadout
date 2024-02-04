package com.techelevator;

public class SavingsAccount extends BankAccount{

    // --------------- Constructor ---------------
    public SavingsAccount(String accountHolderName, String accountNumber) { super(accountHolderName, accountNumber); }
    public SavingsAccount(String accountHolderName, String accountNumber, int balance) { super(accountHolderName, accountNumber, balance); }

    @Override
    public int withdraw(int amountToWithdraw) {

        if ((getBalance() - amountToWithdraw) - 2 < 0 ||  (getBalance() - amountToWithdraw) < 0 || amountToWithdraw < 0) {
            return getBalance();
        }

        super.withdraw(amountToWithdraw);

        if (getBalance() < 150) {
            super.withdraw(2);  // service charge of $2.00
        }

        return getBalance();
    }


}
