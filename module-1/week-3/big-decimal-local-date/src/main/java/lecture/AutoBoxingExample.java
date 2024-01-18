package lecture;

import java.util.Arrays;

public class AutoBoxingExample {

    public static void main(String[] args) {
        new AutoBoxingExample().run();
    }

    public void run(){
        autoBox();
    }

    public void autoBox(){
        Integer integerNum = 10;
        int intNum = integerNum;

        /*
         * Integer types can be set to null,
         * but int can not
         */
        integerNum = null;
        //intNum = null; // ERROR!

        Integer integerNumCopy = intNum + Integer.valueOf(5);
        System.out.println(integerNum);
        System.out.println(integerNumCopy);
        System.out.println(intNum);

        int[] arr = new int[]{ 1, 2, 3, 4, 5};
        int[] arr2 = arr;
        arr2[1] = -99;
        System.out.println("arr: " + Arrays.toString(arr) + "; arr2: " + Arrays.toString(arr2));

        changeArr(arr2);
        System.out.println("arr: " + Arrays.toString(arr) + "; arr2: " + Arrays.toString(arr2));

        /*
         * Integer[] is NOT the same as int[]
         */
        //Integer[] integerArr = arr;
    }

    public void changeArr(int[] intArr){
        if(intArr.length > 0){
            System.out.println("changing array!");
            intArr[0] = -11111;
        }
    }
}
