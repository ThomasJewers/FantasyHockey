public class Player {
    //Player class variables
    private String playerName;
    private int playerGoals;
    private int playerAssists;

    //Player class constructor
    public Player(String playerName, int playerGoals, int playerAssists) {
        this.playerName = playerName;
        this.playerGoals = playerGoals;
        this.playerAssists = playerAssists;
    }

    //Player class getters
    public String getPlayerName(){
        return playerName;
    }
    public int getPlayerGoals(){
        return playerGoals;
    }

    public int getPlayerAssists(){
        return playerAssists;
    }
    //Player methods
    public int playerTotal(){
        return this.playerGoals+this.playerAssists;
    }

}
