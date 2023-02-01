//Thomas Jewers 01/31/2023
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //variables in case of later program expansion
        int playersPerTeam = 3;
        int numberOfTeams = 3;
        //objects
        ArrayList<Team> teams = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        //region user input for team names and random budget
        String tempTeam;
        for (int i=0;i<numberOfTeams;i++) {
            do {
                System.out.println("Enter name for team # "+(i+1)+": ");
                tempTeam = scan.nextLine();
                if (tempTeam.length() < 3){
                    System.out.println("Team names must be greater than three characters");
                }
            } while (tempTeam.length() < 3);
            float budget = (float) (Math.random() * 100000);
            teams.add(new Team(tempTeam, budget));
        }
        //endregion
        //region user input for players
        int goals;
        int assists;
        String playerName;
        for (int i=0;i<numberOfTeams;i++){
            System.out.println("Enter players for "+teams.get(i).getTeamName()+": ");
            for (int j=0;j<playersPerTeam;j++){
                do {
                    System.out.println("Enter player # " + (j + 1) + ":");
                    playerName = scan.nextLine();
                    if (playerName.length()<3){
                        System.out.println("Player names must be greater than three characters");
                    }
                } while (playerName.length() < 3);
                //region Player goals input with validation
                do {
                    System.out.println("Enter number of goals for "+playerName+":");
                    if (scan.hasNextInt()){
                    goals = scan.nextInt();
                        if (goals<0){
                            System.out.println("Number of goals must positive");
                            scan.nextLine();
                        }
                    } else {
                        System.out.println("Invalid input type");
                        goals = -1;
                        scan.nextLine();
                    }
                    } while (goals<0);
                //endregion
                //region Player assists input with validation
                do {
                    System.out.println("Enter number of assists for "+playerName+":");
                    if (scan.hasNextInt()){
                        assists = scan.nextInt();
                        if (assists<0){
                            System.out.println("Number of assists must positive");
                            scan.nextLine();
                        }
                    } else {
                        System.out.println("Invalid input type");
                        assists = -1;
                        scan.nextLine();
                    }
                } while (assists<0);
                //endregion
                //add player to teams
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
            System.out.printf("Budget - $"+"%.2f \n",i.getTeamBudget());
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
            System.out.println("======================");
        }
        //endregion
    }
}