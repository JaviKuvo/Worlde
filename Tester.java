import java.io.FileNotFoundException;

/**
 * Tester file.
 *
 * Use this main method to test classes and methods as you create them.
 * Feel free to modify this file as you wish.
 */
public class Tester {
  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(WordBank.checkInDictionary("hello"));  // true
    System.out.println(WordBank.checkInDictionary("asdfg"));  // false

    System.out.println(WordBank.getAnswerForPuzzleNumber(0)); // bused
    System.out.println(WordBank.getAnswerForPuzzleNumber(0)); // bused
    System.out.println(WordBank.getAnswerForPuzzleNumber(1)); // plumb

    // TODO add tests for Wordle Letter
    WordleLetter myWordleLetter = new WordleLetter('r');
    System.out.println(myWordleLetter.isColorSet());
    myWordleLetter.setColor("green");
    System.out.println(myWordleLetter.isColorSet());
    myWordleLetter.setColor("yellow");
    System.out.println(myWordleLetter.isColorSet());


    // TODO add tests for Wordle Game
    String s = "argon";
    System.out.println(s.charAt(0)); // 'a"
    System.out.println(s.charAt(1)); // 'r"
    System.out.println(s.charAt(2)); // 'g"
    System.out.println(s.charAt(3)); // 'o"
    System.out.println(s.charAt(4)); // 'n"
    char c = s.charAt(0); // c receives the value 'a'
    

    // TODO add tests for Main

  }
}
