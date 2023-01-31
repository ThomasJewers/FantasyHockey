import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //variables in case of later program expansion
        int playersPerTeam = 3;
        int numberOfTeams = 1;
        //object arrays
        ArrayList<Team> teams = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        //region user input for team names and random budget
        for (int i=0;i<numberOfTeams;i++) {
            System.out.println("Enter name for team # "+(i+1)+": ");
            float budget = (float) (Math.random() * 100000);
            teams.add(new Team(scan.nextLine(), budget));
        }
        //endregion
        //region user input for players
        for (int i=0;i<numberOfTeams;i++){
            System.out.println("Enter players for "+teams.get(i).getTeamName()+": ");
            for (int j=0;j<playersPerTeam;j++){
                System.out.println("Enter player # "+(j+1)+":");
                String playerName = scan.nextLine();
                System.out.println("Enter number of goals for "+playerName+":");
                int goals = scan.nextInt();
                System.out.println("Enter number of assists for "+playerName+":");
                int assists = scan.nextInt();
                scan.nextLine();
                teams.get(i).addPlayer(new Player(playerName, goals, assists));
            }
        }
        //endregion
        //region display statistics
        System.out.println("======================");
        System.out.println("REPORT: Stats per Team");
        System.out.println("======================");
        for (Team i : teams){
            System.out.println(i.getTeamName()+":   G - "+i.teamGoals()+"  A - "+i.teamAssists()+"  Total - "+i.teamTotal());
            System.out.println("Rating: "+i.teamRating()+" stars");
        }
        System.out.println("======================");
        System.out.println("REPORT: Stats per Player");
        System.out.println("======================");
        for (Team i : teams){
            for (Player j : i.getPlayers()){
                System.out.println(i.getTeamName());
                System.out.println(j.getPlayerName()+":    G - "+j.getPlayerGoals()+"   A - "+j.getPlayerAssists()+"   Total - "+j.playerTotal());
            }
        }
        //endregion
    }
}