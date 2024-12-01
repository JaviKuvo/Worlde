import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    // Do not modify the method signature.
    public static WordleGame startGame(Scanner scanner) throws FileNotFoundException {
        int puzzleNumber;
        do {
            System.out.print("Enter a puzzle number (between 0 and 2315): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // consume the invalid input
            }
            puzzleNumber = scanner.nextInt();
        } while (puzzleNumber < 0 || puzzleNumber > 2315);

        return new WordleGame(puzzleNumber);
    }

    // Do not modify the method signature.
    public static void playGame(Scanner scanner, WordleGame game) throws FileNotFoundException {
        while (!game.isGameOver()) {
            System.out.print("Enter a 5-letter guess: ");
            String guess = scanner.next().toLowerCase();

            while (guess.length() != 5 || !WordBank.checkInDictionary(guess)) {
                System.out.println("Invalid guess. Please enter a valid 5-letter word from the dictionary.");
                System.out.print("Enter a 5-letter guess: ");
                guess = scanner.next().toLowerCase();
            }

            game.guess(guess);
            System.out.println(game.toString());
        }
    }

    // Do not modify the method signature.
    public static void reportGameOutcome(WordleGame game) {
        if (game.isGameWin()) {
            System.out.println("You won!");
        } else {
            System.out.println("The answer was " + game.getAnswer());
        }
    }

    // This main method body should not be modified.
    public static void main(String[] args) throws FileNotFoundException {
        // Only use this Scanner for user input, do not create new ones via `new Scanner(System.in)`.
        Scanner scanner = new Scanner(System.in);
        WordleGame game = startGame(scanner);
        playGame(scanner, game);
        reportGameOutcome(game);
    }
}