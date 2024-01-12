import java.util.Random;
import java.util.Scanner;

/*
The classic game of rock, paper, scissors.
2 players can throw either rock, paper, or scissors.
The rules below determine who wins:

   rock beats scissors
   rock loses to scissors

   paper beats rock
   paper loses to scissors

   paper beats rock
   paper loses to scissors

   if both players throw the same thing it's a draw.

Create a best-of-3 game of rock, paper, scissors where the user
plays against the computer.

Use the getRandomNumber method to get a random integer of 0, 1, 2
Hint: Use an if statement and correlate 0 with rock, 1 with paper, 2 with scissors
*/
public class RPS {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numPlayerWins = 0;
        int numComputerWins = 0;

        // 4. Repeat steps 1 - 3 until one player gets 2 wins.
        //    what kind of loop????
        while(numPlayerWins < 2 && numComputerWins < 2){
            // 1. Get what the user wants to throw...from the console
            // TODO:         add user input validation
            System.out.print("Enter rock, paper, or scissors: ");
            String userSelection = input.nextLine();

            // 2. Get what the computer will throw
            //      a. Need a way to get a random number... 0, 1, 2
            int randomNumber = new Random().nextInt(3);

            // indexes                           0        1         2
            String[] throwItems = new String[]{"rock", "paper", "scissors"};
            String computerSelection = throwItems[randomNumber];

            // ALTERNATE METHOD
//            if(randomNumber == 0){
//                computSelection = "rock";
//            }

            /*
             * Checkpoint: make sure code captures the user input and generates random
             * values for the computer.
             * ==Code up to this point is good==
             */
            System.out.println("User selected    : " + userSelection);
            System.out.println("Computer selected: " + computerSelection);

            // 3. Find out who won the match...how to check if there's a tie???
            boolean hasUserWon = (userSelection.equals("rock") && computerSelection.equalsIgnoreCase("scissors")) ||
                    (userSelection.equals("paper") && computerSelection.equalsIgnoreCase("rock")) ||
                    (userSelection.equals("scissors") && computerSelection.equalsIgnoreCase("paper"));


            if(userSelection.equalsIgnoreCase(computerSelection)){
                System.out.println("It's a tie!!!");
            } else if(hasUserWon){
                System.out.println("You won!!!");
                numPlayerWins++;
            } else {
                System.out.println("Sorry, you lost :````(");
                numComputerWins++;
            }
        }

        // Only here after computer or player has 2 wins...

        // 5. Tell the user/computer they've won
        if(numPlayerWins == 2){
            System.out.println("CONGRATS, you've won the match");
        } else {
            System.out.println("ARGHHH, you've lost the match");
        }
    }
}

