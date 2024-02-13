import java.util.Scanner;

public class CallStack {
    Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        new CallStack().run();
    }

    private void run() {
        String name = "Rose";

        try {
            a();
            System.out.println("No exception occurred");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Handling the ArrayIndexOutOfBoundsException");
        } catch(NullPointerException e){
            System.out.println("Handling the NullPointerException");
        }

        System.out.println("AFTER RUN");
    }

    public void a(){
        System.out.println("A");
        b();
        System.out.println("AFTER A");
    }

    public void b(){
        System.out.println("B");

        c();

        System.out.println("AFTER B");
    }

    public void c(){
        System.out.println("C");

        String userInput = inputScanner.nextLine();
        Integer.parseInt(userInput);

        System.out.println("AFTER C");
    }
}
