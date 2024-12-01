public class WordleLetter {
    private char letter;
    private String color;
    private boolean colorSet;

    // Constructor
    public WordleLetter(char letter){
        this.letter = letter;
        this.colorSet = false;
    }
    public char getLetter() {
        return letter;
    }
    // Setter for color
    public void setColor(String color){
        this.color = color;
        this.colorSet = true;
    }
    public String getColor() {
        return color;
    }
    // Method to check if the color has been set
    public boolean isColorSet(){
        return colorSet;
    }

    // Method to check if the color is green
    public boolean isGreen(){
        return colorSet && color.equals("green");
    }
	
    public String toString() {
        // Determine the special characters to add at the beginning of the String
        // to change the text color to the right color.
        String colorCode;
        if (color.equals("green")) {
            colorCode = "\u001B[32m";
        } else if (color.equals("yellow")) {
            colorCode = "\u001B[33m";
        } else {
            colorCode = "\u001B[31m";
        }

        // These are the special characters to add to the end of the String
        // to signify the end of the color change.
        String resetCode = "\u001B[0m";

        // Surround the letter with space characters and with the above color-changing special characters.
        return String.format("%s %s %s", colorCode, letter, resetCode);
    }
}