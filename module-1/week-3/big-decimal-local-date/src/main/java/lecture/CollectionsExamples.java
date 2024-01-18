package lecture;

import java.util.*;

public class CollectionsExamples {

    public static void main(String[] args) {
        new CollectionsExamples().run();
    }

    public void run(){
        //collectionsExamples();
        Map<String, String> testMap = new HashMap<>();
        testMap.put("a", "Hi");
        testMap.put("b", "There");
        //testMap.put("A", "Hi");
        //testMap.put("B", "Hi");

        Double smallestDouble = Double.MIN_VALUE;
        Double largestDouble = Double.MAX_VALUE;

        String keyIWantToUse = "A";

        String output = testMap.get(keyIWantToUse.toLowerCase());
        System.out.println(output);

        output = testMap.get(keyIWantToUse);
        System.out.println(output);

        mapAB(testMap);
    }

    public void collectionsExamples(){

        List<Integer> myList = Arrays.asList(-11, 22, 874378, 0, 94, 42);
        System.out.println(myList);

        /*
         * Get the min/max in a collection
         *  Collections.min()
         *  Collections.max()
         */
        Integer minInt = Collections.min(myList);
        Integer maxInt = Collections.max(myList);
        System.out.println("minimum value is: " + minInt);
        System.out.println("maximum value is: " + maxInt);

        /*
         * Sort, Reverse, Shuffle
         *  Collections.sort()
         *  Collections.reverse()
         *  Collections.shuffle()
         */
        Collections.sort(myList);
        System.out.println(myList);
        Collections.reverse(myList);
        System.out.println(myList);
        Collections.shuffle(myList);
        System.out.println(myList);
    }


//    Modify and return the given map as follows: for this problem the map may or may not contain the "a" and "b" keys. If both keys are present, append their 2 string values together and store the result under the key "ab".
//
//    mapAB({"a": "Hi", "b": "There"}) → {"a": "Hi", "ab": "HiThere", "b": "There"}
//    mapAB({"a": "Hi"}) → {"a": "Hi"}
//    mapAB({"b": "There"}) → {"b": "There"}
    public static Map<String, String> mapAB(Map<String, String> map) {

        // Modify map

        boolean hasA = map.containsKey("a");
        boolean hasB = map.containsKey("b");

        // 1. Check if both keys are present: "a" "b"
        if(hasA && hasB) {

            // 2. Get the values associated with both keys
            String aValue = map.get("a");
            String bValue = map.get("b");

            // 3. Combine both values into 1 string
            String combinedString = aValue + bValue;

            // 4. put() "ab" with a value of the combined string
            map.put("ab", combinedString);
        }

        // 5. return the modified map
        return map;
    }
}
