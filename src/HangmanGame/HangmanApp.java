package HangmanGame;
import java.util.Scanner;

public class HangmanApp {
    public static void main(String[] args) {
        //declare local variables
        String [] words = {"AUSTRIA", "BELGIUM","BULGARIA", "CROATIA", "CYPRUS","CZECHIA","DENMARK","ESTONIA","FINLAND","FRANCE",
        "GERMANY", "GREECE", "HUNGARY", "IRELAND", "ITALY","LATVIA","LITHUANIA","LUXEMBOURG","MALTA","NETHERLANDS","POLAND",
                "PORTUGAL", "ROMANIA", "SLOVAKIA", "SLOVENIA", "SPAIN", "SWEDEN"};
        int lives;
        String randomWord;
        char letter;
        char answer;
        boolean letterMatched;
        boolean letterIsUsed;
        String usedLetters;
        //declare objects
        StringBuffer sb = new StringBuffer();
        HangmanStats statistics = new HangmanStats();

        System.out.println("Welcome to my Hangman project! " +
                "\n\tGuess the EUROPEAN UNION countries! ");
        do {
            lives = 5;
            Scanner input = new Scanner(System.in);
            Hangman word = new Hangman();
            System.out.println("\t\tPress \"ENTER\" to start the game!");
            input.nextLine();

            //generate random word from an array
            randomWord = words[(int) (Math.random()*words.length)];
            word.setWordToGuess(randomWord);
            word.convertWord();

            usedLetters = " ";
            String wordToShow = word.getWordToShow();
            System.out.println("Country to guess: " + wordToShow);
            System.out.println("You've got " + lives + " lives");
            System.out.println();

            do {
                    //input
                    System.out.println("Enter a letter: ");
                    letter = input.next().charAt(0);
                    letter = Character.toUpperCase(letter);
                    //process
                    word.setLetter(letter);
                    word.guessing();
                    wordToShow = word.getWordToShow();
                    //output
                    System.out.println("Country: " + wordToShow);

                    //check if letter is already entered
                    letterIsUsed = usedLetters.contains(String.valueOf(letter));
                    if(!letterIsUsed){
                        usedLetters = String.valueOf(sb.append(letter).append(" "));
                        //output
                        System.out.println("Letters used: " + sb.toString());
                    }else{
                        System.out.println("Letter is already used!");
                    }

                    //check if letter matched, if not lives -1
                    letterMatched = randomWord.contains(String.valueOf(letter));
                    if (!letterMatched && !letterIsUsed) {
                        lives--;
                    }
                    //output
                    System.out.println("Lives: " + lives);
                    System.out.println();


                } while (lives > 0 && wordToShow.contains("*")) ;

            //output
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            if (lives == 0) {
                System.out.println("You lost!");
                    System.out.println("You didn't guess country " + randomWord);
                    statistics.incrementGamesLost();
                } else {
                System.out.println("You WON!");
                    statistics.incrementGamesWon();
                }

            System.out.println("Do you want to play again? y / n");
            answer = input.next().charAt(0);
            sb.setLength(0);
        }while(answer == 'y');

        //process
        int gamesWon = statistics.getGamesWon();
        int gamesLost = statistics.getGamesLost();
        int total = statistics.getGamesTotal();

        //output
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Game statistics: ");
        System.out.println("Games played: " + total);
        System.out.println("Games won: " + gamesWon);
        System.out.println("Games lost: " + gamesLost);

    }//end main
}//end class
