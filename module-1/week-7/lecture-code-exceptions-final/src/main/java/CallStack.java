import java.util.Scanner;

public class CallStack {
    Scanner input;

    public static void main(String[] args) {
        new CallStack().run();
    }

    private void run() {
        System.out.println("BEFORE RUN");
        a();
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

        try {
            input.nextLine();
            System.out.println("AFTER THE NEXTLINE() method");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Handling the array index out of bounds exception");
        } catch(NullPointerException e){
            System.out.println("Handling the null pointer exception");
        } catch(Exception e){
            /*
             * Dont usually do this
             */
            System.out.println("CATCHING ALL EXCEPTIONs");
        } finally {
            // Logging operations
            // setting Loading flag to false
        }

        System.out.println("AFTER C");
    }
}
