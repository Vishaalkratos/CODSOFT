import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            boolean playGame = true;

            System.out.println("Welcome to the Number Guessing Game!");

            while (playGame) {
                int secretNumber = random.nextInt(100) + 1;
                int attempts = 0;

                System.out.print("Enter your name: ");
                String playerName = scanner.nextLine();

                System.out.println("Hello " + playerName + "! Let's play the Number Guessing Game.");
                System.out.println("I'm thinking of a number between 1 and 100.");

                while (true) {
                    System.out.print("Your guess: ");
                    if (scanner.hasNextInt()) {
                        int userGuess = scanner.nextInt();
                        attempts++;

                        if (userGuess == secretNumber) {
                            System.out.println("Congratulations, " + playerName + "! You guessed the number in " + attempts + " attempts.");
                            break;
                        } else if (userGuess < secretNumber) {
                            System.out.println("Try a higher number.");
                        } else {
                            System.out.println("Try a lower number.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next(); // consume the invalid input
                    }
                }

                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = scanner.next().toLowerCase();
                while (!playAgain.equals("yes") && !playAgain.equals("no")) {
                    System.out.print("Please enter 'yes' or 'no': ");
                    playAgain = scanner.next().toLowerCase();
                }
                if (playAgain.equals("no")) {
                    System.out.println("Thanks for playing, " + playerName + "! See you soon :)");
                    playGame = false;
                }
            }
        }
    }
}