package HangmanGame;

public class HangmanStats {
    //declare instantiable variables
    private int gamesWon;
    private int gamesLost;

    //getter
    public int getGamesWon() {
        return gamesWon;
    }

    //method to increment games won
    public void incrementGamesWon(){
        this.gamesWon +=1;
    }

    //getter
    public int getGamesLost() {
        return gamesLost;
    }

    //method to increment lost games
    public  void incrementGamesLost(){
        this.gamesLost +=1;
    }

    //getter
    public int getGamesTotal(){
     return gamesWon + gamesLost;
    }

}//end class