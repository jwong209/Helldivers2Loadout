package lecture;

public class PassByValueExample {
    public static void main(String[] args) {
        new PassByValueExample().run();
    }

    public void run(){
        String vegetable = "potato";
        change(vegetable);
        System.out.println(vegetable);
    }

    public void change(String vegetable){
        vegetable = vegetable + " salad";
    }
}
