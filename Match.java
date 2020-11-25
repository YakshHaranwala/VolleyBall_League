import java.util.Random;
/**
 * The Match Class is the representation of an individual Match in a Division.
 * 
 * The purpose of the Match class is to simulate matches between 2 teams as well
 * as play sets between 2 teams and generate results of sets randomly.
 *  
 * @author Salman Haidri, Yaksh J Haranwala, Hasan Zobaer Chowdhury
 * @date   20th November 2020
 */
public class Match
{
    // The Team 1 that is participating in the Match.
    private Team team1;
    // The Team 2 that is participating in the Matc
    private Team team2;
    // The Division that the teams are playing in.
    private Division division;
    
    /**
     * Constructor for objects of class Match
     */
    public Match(Team team1, Team team2)
    {
        this.team1 = team1;
        this.team2 = team2;
    }

    /**
     * Accessor method for the first team that is playing in the Match.
     * 
     * @return team1 the first team
     */
    public Team getTeamOne()
    {
        return team1;
    }
    
    /**
     * Accessor method for the second team that is playing in the Match.
     * 
     * @return team2 the second team
     */
    public Team getTeamTwo()
    {
        return team2;
    }
    
    /**
     * Creates a match and updates the points of the team that won the match(no. of sets won + 1)
     * and also the team that lost the match(no. of sets won).
     * This method also updates the number of matches won and matches lost and also updates the points difference.
     * 
     * @return An array of standing points of team1 and team2 in that order.
     */
    public int[] simulateMatch()
    {
        int team1_points = 0;
        int team2_points = 0;
        
        team1.setMatchesPlayed();
        team2.setMatchesPlayed();
        
        for(int i = 1; i <= 5; i++){
            int result[] = Set(i);            
            if(result[0] > result[1]){
                team1_points++;
            }
            else{
                team2_points++;
            }
            
            if(team1_points > 2 || team2_points > 2){
                break;
            }
        }
     
        if(team1_points > team2_points){
            team1_points++;
            team1.setStandingPoints(team1_points);
            team2.setStandingPoints(team2_points);
            team1.setMatchesWon();
            team2.setMatchesLost();
        }
        else{
            team2_points++;
            team2.setStandingPoints(team2_points);
            team1.setStandingPoints(team1_points);
            team2.setMatchesWon();
            team1.setMatchesLost();
        }
        
        team1.pointDifference();
        team2.pointDifference();
        
        return new int[] {team1_points, team2_points};
    }
    
    /**
     * Randomly scores the set and returns the points scored by each team on that set.
     * It randomly choses a number between 0 and 99 and if the number is less than or equal to 50
     * team1 gets the points else team2 gets the points.
     * This set also sets points for and points against of each team after every set.
     * 
     * @param set_Number to check which set teams are playing
     * @return An array containing scores of team1 and team2 in that order.
     */
    private int[] Set(int set_Number)
    {  
        int team1_score = 0;
        int team2_score = 0;
        int points = 0;
        if(set_Number <= 4){
            points = 21;
        }
        else if(set_Number == 5){
            points = 15;
        }
        Random rand = new Random();
        while(team1_score < points && team2_score < points){
            int rand1 = rand.nextInt(100);
            if(rand1 <= 50){
                team1_score++;
            }
            else if(rand1 > 50){
                team2_score++;
            }
        }
        team1.setPointsFor(team1_score);
        team1.setPointsAgainst(team2_score);
        team2.setPointsFor(team2_score);
        team2.setPointsAgainst(team1_score);
        return new int[] {team1_score, team2_score};
    }
}
