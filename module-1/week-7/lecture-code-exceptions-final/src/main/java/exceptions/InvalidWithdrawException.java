package exceptions;

public class InvalidWithdrawException extends RuntimeException {

    public InvalidWithdrawException(int withdrawAmount){
        super("ERROR: Invalid withdraw amount: " + withdrawAmount);
    }

}
