/*package Task1;

import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {


	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        int minNumber = 1;
	        int maxNumber = 100;
	        int numberOfAttempts = 10;
	        int round = 1;
	        int score = 0;

	        System.out.println("Welcome to Guess the Number!");
	        System.out.println("You have " + numberOfAttempts + " attempts to guess the number between " + minNumber + " and " + maxNumber + ".");

	        while (true) {
	            int targetNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
	            System.out.println("\nRound " + round + ":");
	            int attemptsLeft = numberOfAttempts;

	            while (attemptsLeft > 0) {
	                System.out.print("Enter your guess: ");
	                int userGuess = scanner.nextInt();

	                if (userGuess == targetNumber) {
	                    System.out.println("Congratulations! You guessed the correct number!");
	                    int points = attemptsLeft * 10; // Giving points based on the number of attempts left.
	                    score += points;
	                    System.out.println("Points earned: " + points);
	                    break;
	                } else if (userGuess < targetNumber) {
	                    System.out.println("Your guess is too low. Try again.");
	                } else {
	                    System.out.println("Your guess is too high. Try again.");
	                }

	                attemptsLeft--;
	                if (attemptsLeft == 0) {
	                    System.out.println("Out of attempts. The number was: " + targetNumber);
	                }
	            }

	            round++;
	            System.out.print("Do you want to play another round? (yes/no): ");
	            String playAgain = scanner.next();
	            if (!playAgain.equalsIgnoreCase("yes")) {
	                break;
	            }
	        }

	        System.out.println("Game Over!");
	        System.out.println("Total Score: " + score);
	        scanner.close();
	    }
}
*/

