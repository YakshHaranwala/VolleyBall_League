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
     * The purpose of the function is to create a match instance by giving 2 teams,
     * then simulating the match by calling the simulateMatch() function and then
     * pass in the score returned by the simulateMatch() function to addMatch()
     * function.
     * 
     * @param Team1 is the first team participating in the match.
     * @param Team2 is the second team participating in the match.
     */
    private void createMatch(Team team1, Team team2){
        Match matchToAdd = new Match(team1, team2);
        int[] score = matchToAdd.simulateMatch();
        addMatch(team1, team2, score);
    }
    
    /**
     * Add a match to the division after it has been played and then calculate standing after printing the results.
     * 
     * The calculation of standings is done in a separate function in the class.
     * 
     * @param team1 is the Team 1 participating in the Match.
     * @param team2 is the Team 2 participating in the Match.
     * @param score is the results of the match.
     */
    public void addMatch(Team team1, Team team2, int[] score){
        if (score[0] > score[1]) score[0]--;
        else                     score[1]--;
        System.out.println(team1.getTeamName() + ": " + String.valueOf(score[0]) + "  " +
                           team2.getTeamName() + ": " + String.valueOf(score[1]));
        calculateStanding();
    }
    
    /**
     * Calculate the standings of the League after the matches have taken place.
     *
     * The method does so by comparing the standingPoints of all the teams with 
     * each other and swapping out the teams that are higher.
     * Also, if 2 teams have same standingPoints, then the pointsDifference is used
     * as a tiebreaker.
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
     * Print the standings of the teams in the League.
     * 
     * The function serves it purpose by calling the helper calculateStandings()
     * function and fetching an array that is according to the standings of the teams 
     * after the matches have been played. Then, the function prints all the teams.
     */
    public void printStandings(){
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
     * Each team will play 1 game at home and 1 game away against the same opponent.
     * As a result, each time will play 8 games in total. 
     */
    public void createMatchups(){
        Team[] teams = new Team[teamPool.size()];
        teams = teamPool.toArray(teams);
        
        for (int i = 0; i < teams.length; i++){
            for (int j = i+1; j < teams.length; j++){
                createMatch(teams[i], teams[j]);
                createMatch(teams[j], teams[i]);
            }
        }
    }
}
