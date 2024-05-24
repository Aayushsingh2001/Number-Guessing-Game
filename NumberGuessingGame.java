import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 5;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    private int score;
    private int roundsWon;

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.play();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            int numberToGuess = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int attempts = 0;

            System.out.println("Welcome to the number guessing game!");
            System.out.println("I'm thinking of a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println(" Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += MAX_ATTEMPTS - attempts + 1;
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Sorry, you didn't guess the number. The correct answer was " + numberToGuess + ".");
            }

            System.out.println("Your current score is " + score + " and you have won " + roundsWon + " rounds.");
            System.out.print("Do you want to play again? (y/n): ");
            String response = scanner.next();

            if (response.equalsIgnoreCase("n")) {
                break;
            }
        }

        System.out.println("Thanks for playing! Your final score is " + score + " and you won " + roundsWon + " rounds.");
    }
}
