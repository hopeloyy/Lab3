import java.util.Random;
import java.util.Scanner;

/**
 * This program asks the user if they want to play a Guessing Game or a Rock-Paper-Scissors game or to exit.
 * The user can play either game multiple times or exit when they choose to go to the previous menu.
 *
 * @author Hope Loy
 * @since 03/18/2025
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("Select a game:");
            System.out.println("1. Guessing Game");
            System.out.println("2. Rock-Paper-Scissors");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    playGuessingGame(scanner);
                    break;
                case 2:
                    playRockPaperScissors(scanner);
                    break;
                case 3:
                    keepPlaying = false;
                    System.out.println("Thanks for playing!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    /**
     * Implements the Guessing Game.
     * The user has a limited number of tries to guess a randomly generated number.
     *
     * @param scanner Scanner object for user input
     */
    public static void playGuessingGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 5;
        boolean guessedCorrectly = false;

        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Guess what it is. You have " + attempts + " tries.");

        while (attempts > 0) {
            System.out.print("Your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == numberToGuess) {
                System.out.println("You got it!");
                guessedCorrectly = true;
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("Nope! Too low. Try again (" + (attempts - 1) + " tries left)");
            } else {
                System.out.println("Nope! Too high. Try again (" + (attempts - 1) + " tries left)");
            }
            attempts--;
        }

        if (!guessedCorrectly) {
            System.out.println("Nope! You lost. The number was " + numberToGuess);
        }
    }

    /**
     * Implements the Rock-Paper-Scissors game.
     * The user plays against the computer, which randomly selects a choice.
     *
     * @param scanner Scanner object for user input
     */
    public static void playRockPaperScissors(Scanner scanner) {
        Random random = new Random();

        System.out.println("Enter your choice: 1. Paper, 2. Scissors, 3. Rock");
        int userChoice = scanner.nextInt();
        int computerChoice = random.nextInt(3) + 1;

        String[] choices = {"Paper", "Scissors", "Rock"};

        System.out.println("You chose: " + choices[userChoice - 1]);
        System.out.println("Computer chose: " + choices[computerChoice - 1]);

        if (userChoice == computerChoice) {
            System.out.println("It's a tie!");
        } else if ((userChoice == 1 && computerChoice == 3) ||
                (userChoice == 2 && computerChoice == 1) ||
                (userChoice == 3 && computerChoice == 2)) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
    }
}
