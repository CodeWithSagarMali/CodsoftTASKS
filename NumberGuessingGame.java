import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Method to play a single round of the game
    public static int playGame() {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // Generate random number between 1 and 100
        int maxAttempts = 10;
        int attempts = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nI have selected a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess the number.");

        // Game loop: repeat until the user guesses correctly or runs out of attempts
        while (attempts < maxAttempts) {
            System.out.print("\nAttempt " + (attempts + 1) + ": Enter your guess: ");
            
            // Validate user input to ensure it is an integer
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.next(); // Clear the invalid input
                continue;
            }
            
            int guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                return maxAttempts - attempts + 1; // Return score based on remaining attempts
            }
        }

        // If the user fails to guess the number within the maximum attempts
        System.out.println("Sorry, you've used all your attempts! The number was " + numberToGuess + ".");
        return 0; // Return score of 0 if the user fails to guess
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");

        int totalScore = 0;
        int roundNumber = 1;

        // Main game loop: allows the user to play multiple rounds
        while (true) {
            System.out.println("\n--- Round " + roundNumber + " ---");
            totalScore += playGame();
            System.out.println("Your current score: " + totalScore);

            // Ask the user if they want to play another round
            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.next().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
            roundNumber++;
        }

        // Game over message
        System.out.println("\nGame Over! Your final score is " + totalScore + ". Thanks for playing!");
        scanner.close();
    }
}