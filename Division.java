import java.util.ArrayList;
/**
 * Write a description of class Division here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Division
{
    // ArrayList storing the 5 teams in a Division.
    private ArrayList<Team> teamPool;
    // A List storing the names of the 5 teams.
    private String[] teamNames;
    
    /**
     * Constructor for objects of class Division to initiate
     * the List containing the teams.
     * Then, immediately call the private helper method addTeams() so as
     * to create the pool of teams that are competing in the Division.
     * 
     * @param The list of names of the teams competing in the Division.
     */
    public Division(String[] teamNames)
    {
        teamPool = new ArrayList<>();
        this.teamNames = teamNames;
        addTeams();
    }
    
    /**
     * Add 5 teams that will be competing in the division.
     * 
     * The purpose of the function is to iteratively create 5 
     * teams that are competing in this particular division.
     * Here, there is an explicit expectation that when we create 
     * a Division object, then we would have to pass in a list of
     * 5 team names that are going to be used in order to create 5
     * teams here.
     */
    private void addTeams(){
        for (int i = 0; i <= 4; i++){
            Team teamToAdd = new Team(teamNames[i]);
            teamPool.add(teamToAdd);
        }
    }
    
    /**
     * Take 2 teams from the same division and create a match.
     */
    public void addMatch(Team team1, Team team2, int score){
        Match matchToAdd = new Match(team1, team2, score);
        matchToAdd.simulateMatch();
    }
}
