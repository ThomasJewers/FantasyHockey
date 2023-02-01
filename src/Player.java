//Thomas Jewers 01/31/2023
public class Player {
    //region Player class variables
    private String playerName;
    private int playerGoals;
    private int playerAssists;
    //endregion
    //region Player class constructor
    public Player(String playerName, int playerGoals, int playerAssists) {
        this.playerName = playerName;
        this.playerGoals = playerGoals;
        this.playerAssists = playerAssists;
    }
    //endregion
    //region Player class getters
    public String getPlayerName(){
        return playerName;
    }
    public int getPlayerGoals(){
        return playerGoals;
    }
    public int getPlayerAssists(){
        return playerAssists;
    }
    //endregion
    //region Player methods
    public int playerTotal(){
        return this.playerGoals+this.playerAssists;
    }
    //endregion
}
