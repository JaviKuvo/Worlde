import java.io.FileNotFoundException;

public class WordleGame {
    private String answer;
    private WordleLetter[][] guesses;
    private int currentGuess;

    // Constructor
    public WordleGame(int puzzleNumber) throws FileNotFoundException {
        this.answer = WordBank.getAnswerForPuzzleNumber(puzzleNumber);
        this.guesses = new WordleLetter[6][5];
        this.currentGuess = 0;
    }

    // Getter for the answer
    public String getAnswer() {
        return answer;
    }

    // Method to process a guess
    public void guess(String guessWord) {
        WordleLetter[] wordleLetters = new WordleLetter[5];
        for (int i = 0; i < 5; i++) {
            char guessLetter = guessWord.charAt(i);
            char answerLetter = answer.charAt(i);
            String color;

            if (guessLetter == answerLetter) {
                color = "green";
            } else if (answer.contains(String.valueOf(guessLetter))) {
                color = "yellow";
            } else {
                color = "red";
            }

            wordleLetters[i] = new WordleLetter(guessLetter);
            wordleLetters[i].setColor(color);
        }

        guesses[currentGuess] = wordleLetters;
        currentGuess++;
    }

    // Getter for the number of guesses so far
    public int getNumberGuessesSoFar() {
        return currentGuess;
    }

    // Getter for a specific guess
    public WordleLetter[] getGuess(int guessNumber) {
        return guesses[guessNumber];
    }

    // Check if the game is over
    public boolean isGameOver() {
        return isGameWin() || currentGuess >= 6;
    }

    // Check if the player has won the game
    public boolean isGameWin() {
        if (currentGuess == 0) {
            return false;
        }

        WordleLetter[] latestGuess = guesses[currentGuess - 1];
        StringBuilder guessWord = new StringBuilder();

        for (WordleLetter letter : latestGuess) {
            guessWord.append(letter.getLetter());
        }

        return guessWord.toString().equals(answer);
    }

    // toString method provided in the starter code
    public String toString() {
        String result = "";
        for (int i = 0; i < getNumberGuessesSoFar(); i++) {
            for (int j = 0; j < 5; j++) {
                result += getGuess(i)[j];
            }
            result += "\n";
        }
        return result;
    }
}