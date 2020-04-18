package HangmanGame;

public class Hangman {
    //declare instantiable variables
    private StringBuffer wordToShow;
    private String wordToGuess;
    private char letter;

    //constructor
    public Hangman(){
        wordToShow = new StringBuffer();
    }

    //setters
    public void setLetter(char letter) {
        this.letter = letter;
    }

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    //getter
    public String getWordToShow() {
        return wordToShow.toString();
    }

    //methods
    //convert word to ******
    public void convertWord(){
        for(int i = 0; i < wordToGuess.length(); i++){
            wordToShow.append("*");
        }
    }

    //method to guess the word
    public void guessing(){
        for(int i = 0; i < wordToGuess.length(); i++){
            if (letter == wordToGuess.charAt(i)){
                wordToShow.setCharAt(i,letter);
            }
        }
    }

}//end class
