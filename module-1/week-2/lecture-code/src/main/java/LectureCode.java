import java.util.Scanner;

public class LectureCode {

    public static void main(String[] args) {

        twoTwo(new int[]{4, 2, 2, 3});
        getSandwich("xxbreadyy");

        System.out.println( "Tech Elevator".substring(2,6) );
/*
        Scanner scanner = new Scanner(System.in);

        String userSelection = "";

        do {
            System.out.println("Please enter rock, paper, or scissors");
            userSelection = scanner.nextLine();
        } while( !( userSelection.equals("rock") || userSelection.equals("paper") || userSelection.equals("scissors")) );

        System.out.println("You selected " + userSelection);
*/
    }

    /*
     * https://codingbat.com/prob/p102145
     * Given an array of ints, return true if every 2 that appears in the array is next to another 2.
     *
     * twoTwo([4, 2, 2, 3]) → true
     * twoTwo([2, 2, 4]) → true
     * twoTwo([2, 2, 4, 2]) → false
     */
    public static boolean twoTwo(int[] nums) {

        // 1. setup return variable
        boolean isAllTwosPaired = true;

        // My code...
        // 2. Need to check all the elements in the array...i.e. for loop
        for(int i = 0; i < nums.length; i++) {

            // 3. Check if the current element at i is 2
            int currentElement = nums[i];

            // 4. If it is, check the next (and previous!) element to see if it's also a 2
            if(currentElement == 2){

                // Get the elements before and after the current element
                int prevElement = i > 0 ? nums[i - 1] : 0;
                int nextElement = i < nums.length - 1 ? nums[i + 1] : 0;

                // 5. Fail if there isn't a 2 on either side!
                if(prevElement != 2 && nextElement != 2){
                    return false;
                }
            }
        }

        // Went through all the elements, no unpaired 2s
        return isAllTwosPaired;
    }

    /*
     * https://codingbat.com/prob/p129952
     * A sandwich is two pieces of bread with something in between.
     * Return the string that is between the first and last appearance
     * of "bread" in the given string, or return the empty string "" if there are not two pieces of bread.
     *
     * getSandwich("breadjambread") → "jam"
     * getSandwich("xxbreadjambreadyy") → "jam"
     * getSandwich("xxbreadyy") → ""
     */
    public static String getSandwich(String str) {

        String filling = "";

        // Code...

        // 1. Search for the first "bread" string within the input parameter
        int firstBreadIndex = str.indexOf("bread");

        // 2. Search for the last "bread" string within the input parameter
        int lastBreadIndex = str.lastIndexOf("bread");

        // elements: b r e a d j a m b r e a d
        // indexes:  0 1 2 3 4 5 6

        // Handle case where there's no bread... This case is covered by firstBreadIndex == lastBreadIndex
        //if(firstBreadIndex == -1 || lastBreadIndex == -1) {
        //  return filling;
        //}

        // Handle the case where there's only 1 bread...
        if(firstBreadIndex == lastBreadIndex) {
            return filling;
        }

        // 3. Get the portion of the string between both indexes....
        int numLettersInBread = "bread".length();
        filling = str.substring(firstBreadIndex + numLettersInBread, lastBreadIndex);

        return filling;
    }

}
