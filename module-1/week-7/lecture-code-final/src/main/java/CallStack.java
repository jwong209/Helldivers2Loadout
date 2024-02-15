import java.util.Scanner;

public class CallStack {

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

        System.out.println("AFTER C");
    }
}
