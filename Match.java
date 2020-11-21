import java.util.Random;
/**
 * Write a description of class Match here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Match
{
    // instance variables - replace the example below with your own
    private Team team1;
    private Team team2;
    
    private int score;
    
    private Division division;
    

    /**
     * Constructor for objects of class Match
     */
    public Match(Team team1, Team team2, int score)
    {
        this.team1 = team1;
        this.team2 = team2;
        this.score = score;
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
    
    public int getScore()
    {
        return score;
    }
    
    /**
     * Create a match and update the points of 
     * the team that won the match.
     */
    public void createMatch()
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
            team1.setPoints();
        }
        else{
            team2.setPoints();
        }
    }
    
    /**
     * Randomly scores the set and return the 
     * points scored by each team on that set.
     * 
     * @param set_Number to check which set teams are playing
     */
    public int[] Set(int set_Number)
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
        int rand1 = rand.nextInt(100);
        while(team1_score < points && team2_score < points){
            if(rand1 <= 50){
                team1_score++;
            }
            else if(rand1 > 50){
                team2_score++;
            }
        }
        team1.setPointsFor(team1_score);
        team2.setPointsFor(team2_score);
        return new int[] {team1_score, team2_score};
    }
}
