import exceptions.InvalidWithdrawException;
import exceptions.OverdrawnException;

public class BankApp {

    public static void main(String[] args) {
        Bank federal = new Bank();

        long userId = federal.addCustomer("Polly Owl", "42 Hoot St.", "555-5555");

        federal.addSavingsAccount(userId, 500);

        /*
         * TODO: Add try-catch
         */
        try {
            int endingBalance = federal.withdraw(userId, 1000);
            System.out.println("Ending balance is: " + endingBalance);
        } catch(InvalidWithdrawException e){
            System.out.println(e.getMessage());
        } catch(OverdrawnException e){
            System.out.println("ERROR: Overdrawn exception");
        }
    }
}
