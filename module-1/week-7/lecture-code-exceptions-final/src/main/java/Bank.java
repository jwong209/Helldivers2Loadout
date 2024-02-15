import exceptions.OverdrawnException;

import java.util.*;

/*
 * 1 Customer, 1 Account
 */
public class Bank {

    private final Set<String> ACCOUNT_TYPES = new HashSet<>(List.of("savings", "checking"));

    private static long nextUserId = 1;
    private Map<Long, BankCustomer> customers;

    public Bank(){
        this.customers = new HashMap<>();
    }

    public long addCustomer(String customerName, String address, String phoneNum){

        long userId = nextUserId++;
        this.customers.put(userId, new BankCustomer(customerName, address, phoneNum));

        return userId;
    }

    private BankCustomer getCustomerFromId(long userId){
        if(!this.customers.containsKey(userId)) {
            // TODO: throw an exception here
            System.out.println("ERROR unable to find user id: " + userId);
            return null;
        }

        return this.customers.get(userId);
    }

    public void addSavingsAccount(long userId, int initialDeposit){
        BankCustomer customer = getCustomerFromId(userId);
        String customerName = customer.getName();
        customer.addAccount(new SavingsAccount(customerName, "42", initialDeposit));
    }

    public int withdraw(long userId, int withdrawAmount) throws OverdrawnException {

        BankCustomer customer = getCustomerFromId(userId);

        // Should fix this up :D
        // Add a way to lookup account
        SavingsAccount firstAccount = (SavingsAccount)customer.getAccounts()[0];

        return firstAccount.withdraw(withdrawAmount);
    }
}
