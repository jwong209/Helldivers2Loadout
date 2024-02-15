import exceptions.OverdrawnException;

public class SavingsAccount extends BankAccount {

    public static final int LOW_BALANCE = 150;
    public static final int SERVICE_CHARGE = 2;

    public SavingsAccount(String accountHolder, String accountNumber, int balance) {
        super(accountHolder, accountNumber, balance);
    }

    public SavingsAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    @Override
    public int withdraw(int amountToWithdraw) throws OverdrawnException {
        /*
         * TODO: Create an exception if (getBalance() - amountToWithdraw < SERVICE_CHARGE)
         */

        if (getBalance() - amountToWithdraw < SERVICE_CHARGE){
            throw new OverdrawnException();
        }

        // Only perform transaction if there's still room for service charge
        // Withdraw the amount
        super.withdraw(amountToWithdraw);

        // Assess service charge if balance goes below low balance threshold
        if (getBalance() < LOW_BALANCE) {
            super.withdraw(SERVICE_CHARGE);
        }

        return getBalance();
    }
}
