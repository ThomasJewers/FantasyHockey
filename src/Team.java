import java.util.ArrayList;

public class Team {
    //region Team class variables
    private String teamName;
    private float teamBudget;
    private ArrayList<Player> teamPlayers;
    //endregion
    //region Team class constructor
    public Team(String teamName, float teamBudget){
        this.teamName = teamName;
        this.teamBudget = teamBudget;
        this.teamPlayers = new ArrayList<>();
    }
    //endregion
    //region Team class setters
    public void addPlayer(Player player) {
        teamPlayers.add(player);
    }
    //endregion
    //region Team class getters
    public String getTeamName() {
        return teamName;
    }
    public float getTeamBudget() {
        return teamBudget;
    }
    public ArrayList<Player> getPlayers() {
        return teamPlayers;
    }

    //Statistic methods
    public int teamGoals(){
        int totalGoals = 0;
        for (int i = 0; i<teamPlayers.size(); i++){
            totalGoals = totalGoals + teamPlayers.get(i).getPlayerGoals();
        }
        return totalGoals;
    }

    public int teamAssists(){
        int totalAssists = 0;
        for (int i = 0; i<teamPlayers.size(); i++){
            totalAssists = totalAssists + teamPlayers.get(i).getPlayerAssists();
        }
        return totalAssists;
    }

    public int teamTotal(){
        int totalTotal = 0;
        for (int i = 0; i<teamPlayers.size(); i++){
            totalTotal = totalTotal + teamPlayers.get(i).getPlayerAssists() + teamPlayers.get(i).getPlayerGoals();
        }
        return totalTotal;
    }

    public String teamRating() {
        String rating = "null";
        if (teamTotal() > 20) {
            rating = "***";
        }else if (teamTotal()>=10 && teamTotal()<20) {
            rating = "**";
        }else if (teamTotal()<10 && teamTotal()>0){
            rating = "*";
        } else if (teamTotal()==0){
            rating = "Zero";
        }
        return rating;
    }
    //endregion

}
