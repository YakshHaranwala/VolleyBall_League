import java.util.Random;
/**
 * The Match Class is the representation of an individual Match in a Division.
 * 
 * The Match class takes in 2 teams and simulates the match with
 * sets and points 
 * @author (your name)
 * @version (a version number or a date)
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
     * Accessor method for the first team
     * that is playing
     * 
     * @return team1 the first team
     */
    public Team getTeam1()
    {
        return team1;
    }
    
    /**
     * Accessor method for the second team
     * that is playing
     * 
     * @return team2 the second team
     */
    public Team getTeam2()
    {
        return team2;
    }
    
    /**
     * Create a match and update the points of 
     * the team that won the match.
     */
    public void simulateMatch()
    {
        int team1_points = 0;
        int team2_points = 0;
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
            team1.setStandingPoints(team1_points + 1);
            team2.setStandingPoints(team2_points);
        }
        else{
            team2.setStandingPoints(team2_points + 1);
            team1.setStandingPoints(team1_points);
        }
        team1.pointDifference();
        team2.pointDifference();
    }
    
    /**
     * Randomly scores the set and return the 
     * points scored by each team on that set.
     * 
     * @param set_Number to check which set teams are playing
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
        while(team1_score <= points && team2_score < points){
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
