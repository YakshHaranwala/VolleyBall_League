import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * The Division class represent a Division on the Volleyball League.
 *
 * The purpose of the division class is to simulate the division.
 * The division also serves the purpose of adding a match and simulating it
 * and then announcing the winners by calculating the standings.
 *
 * @author Salman Haidri, Yaksh J Haranwala, Hasan Zobaer Chowdhury
 * @date   20th November 2020
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
        // createMatch(teamPool.get(1), teamPool.get(2));
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
            //teamToAdd.createTeam();
            teamPool.add(teamToAdd);
        }
    }
    
    /**
     * Create a Volleyball Match between 2 teams.
     * 
     * @param Team1 is the first team participating in the match.
     * @param Team2 is the second team participating in the match.
     */
    protected void createMatch(Team team1, Team team2){
        Match matchToAdd = new Match(team1, team2);
        int[] score = matchToAdd.simulateMatch();
        addMatch(team1, team2, score);
    }
    
    /**
     * Take 2 teams from the same division and create a Match.
     * Then, call the Match class's simulateMatch() method to
     * simulate the points and the winner of the Match.
     * 
     */
    public void addMatch(Team team1, Team team2, int[] score){
        if(score[0] > score[1]){
            team1.setMatchesWon();
            team2.setMatchesLost();
        }
        else{
            team2.setMatchesWon();
            team1.setMatchesLost();
        }
        calculateStanding();
    }
    
    /**
     * Calculate the standings of the League after the matches have taken place.
     *
     * The method does so by comparing the standingPoints of all the teams with 
     * each other and swapping out the teams that are higher.
     * Also, if 2 teams have same standingPoints, then the pointsDifference is used
     * as a tiebreaker.
     * The Algorithm is in-place as such it uses the teamPool ArrayList and sorts it 
     * only according to standings..
     */
    public ArrayList<Team> calculateStanding(){
        Team[] teamArray = new Team[teamPool.size()];
        teamArray = teamPool.toArray(teamArray);
        
        for (int i = 0; i < teamArray.length; i++){
            //Team teamArray[i] = teamArray[i];
            for (int j = i+1; j < teamArray.length; j++){
                //Team teamArray[j] = teamArray[j];
                if (teamArray[i].getStandingPoints() < teamArray[j].getStandingPoints()){
                    Team temp = teamArray[i];
                    teamArray[i] = teamArray[j];
                    teamArray[j] = temp;
                }
                else if (teamArray[i].getStandingPoints() == teamArray[j].getStandingPoints()){
                    if (teamArray[i].pointDifference() < teamArray[j].pointDifference()){
                        Team temp = teamArray[i];
                        teamArray[i] = teamArray[j];
                        teamArray[j] = temp;
                    }
                }
                else {
                    continue;
                }
            }
        }
        ArrayList<Team> standings = new ArrayList<>(Arrays.asList(teamArray));
        
        return standings;
    }
    
    /**
     * Print the teams in the Division.
     * 
     */
    public void printList(){
        ArrayList<Team> toPrint = calculateStanding();
        System.out.println("Standing " + "     Team     " + "           Matches Played " + " Matches Won " + " Matches Lost " +
                           " League Points " +  " Points For " + " Points Against " + 
                           " Points Difference ");
        int i = 1;
        for (Team team : toPrint){
            System.out.print(i + "          ");
            System.out.println(team);
            i++;
        }
    }
    
    /**
     * Create matchups between all the teams.
     * 
     * @return The ArrayList containing all the matchups between teams.
     */
    public void createMatchups(){
        Team[] teams = new Team[teamPool.size()];
        teams = teamPool.toArray(teams);
        
        for (int i = 0; i < teams.length; i++){
            for (int j = i+1; j < teams.length; j++){
                createMatch(teams[i], teams[j]);
            }
        }
    }
}
