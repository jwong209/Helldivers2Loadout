import java.util.*;

public class LectureCode {
    static int taskNum = 1;

    public static void main(String[] args) throws InterruptedException {

        /*
         * LIST
         * Ordered, varying size collection
         */
        List<Integer> myListOfInts = new ArrayList<>();
        List<Character> charList = new ArrayList<Character>();

        System.out.println("list size: " + myListOfInts.size());
        myListOfInts.add(42);       // first element added goes into index 0
        myListOfInts.add(52);       // next is 1
        myListOfInts.add(112);      // last one is 2
        System.out.println("list size: " + myListOfInts.size());

        // Remove element at index 1, i.e. the 2nd element
        myListOfInts.remove(1);
        System.out.println("list size: " + myListOfInts.size());
        System.out.println(myListOfInts);

        // Insert at index 1
        myListOfInts.add(1, -3333);
        System.out.println(myListOfInts);

        // Get element by index
        int lastElement = myListOfInts.get(myListOfInts.size() - 1);
        System.out.println("the last element is: " + lastElement);

        // For each loop
        // Modifying eachElement does NOT change the elements in myListOfInts
        for(Integer eachElement : myListOfInts ){
            eachElement = 10;
            System.out.println("The next element is: " + eachElement);
        }

        String[] teachers = new String[]{"margaret", "michael", "daniel"};
        for(String eachTeacher : teachers){
            System.out.println("The next teacher is: " + eachTeacher);
        }

        /*
         * SET
         * Checking for membership
         */
        // Alternate declaration, add elements later
        Set<String> throwItems = new HashSet<>();
        throwItems.add("rock");
        throwItems.add("paper");
        throwItems.add("scissors");

        // Declaration if we know the items in the set beforehand
        // A Set declared using .of() can NOT be changed.
//        Set<String> throwItems = Set.of("rock", "paper", "scissors");

        // NO DUPLICATES for a set
        throwItems.add("rock");
        throwItems.add("rock");
        throwItems.add("rock");
        throwItems.add("rock");

        System.out.println("the items in the set are: " + throwItems);

        /*
         * SET: Check for membership
         * Only allow rock, paper, or scissors to be entered by the user
         */
        Scanner input = new Scanner(System.in);
        String userSelection = null;
        do {
            System.out.print("Enter rock, paper, or scissors: ");
            userSelection = input.nextLine();
        } while(!throwItems.contains(userSelection));

        /*
         * MAP
         * Fast key-value lookup
         */
        Map<String, Integer> studentIds = new HashMap<>();
        studentIds.put("Daniel", 42);
        studentIds.put("Annie", 110);
        studentIds.put("Kyros", 1);
        studentIds.put("Kyros", 55);
        System.out.println("My student IDs are: " + studentIds);

        // Looping over a map:
        //  1. Get a set of all the keys
        //  2. Use a for-each loop to interate over the set of keys
        for(String eachKey : studentIds.keySet()){
            Integer eachValue = studentIds.get(eachKey);
            System.out.println("key: " + eachKey + "; value: " + eachValue);
        }

        List<String> votes = new ArrayList<>();
        votes.add("Kyros");
        votes.add("Kyros");
        votes.add("Kyros");
        votes.add("Annie");
        votes.add("Annie");
        votes.add("Daniel");

        Map<String, Integer> voteCount = new HashMap<>();

        for(String eachVote : votes){

            // 1. Check if the vote is already in the map
            if(voteCount.containsKey(eachVote)) {

                // If it is, then get the current value and add 1
                int currentVoteCount = voteCount.get(eachVote);
                voteCount.put(eachVote, currentVoteCount + 1);

            } else {

                // 2. If the vote isn't in the map, then add key-value pair
                // with value of 1. i.e. first vote
                voteCount.put(eachVote, 1);
            }
        }
        System.out.println(voteCount);

        /*
         * STACK
         * LIFO Insertion order
         */
        Stack<String> discardPile = new Stack<>();
        discardPile.push("8-D");
        discardPile.push("10-H");
        discardPile.push("Q-C");

        // Taking the top card in the discard pile,
        // 2 cards in discard pile remaining after pop
        String lastDiscardedCard = discardPile.pop();

        /*
         * Queue
         * FIFO Insertion order
         */
        Queue<Runnable> tasks = new LinkedList<>();
        tasks.offer(() -> System.out.println("task #" + taskNum++));
        tasks.offer(() -> System.out.println("task #" + taskNum++));
        tasks.offer(() -> System.out.println("task #" + taskNum++));

        while(!tasks.isEmpty()){
            Runnable eachTask = tasks.poll();
            eachTask.run();

            if(taskNum < 6) {
                tasks.offer(() -> System.out.println("task #" + taskNum++));
            }

            Thread.sleep(500);
        }
    }

}
