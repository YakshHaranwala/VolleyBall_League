import java.util.ArrayList;
import java.util.Random;
/**
 * The Team class is the actual representation of each team that 
 * is going to participate in the in the Division as well as is 
 * going to play matches.
 *
 * @author Salman Haidri, Yaksh J Haranwala, Hassan Zobaer Chowdhury.
 * @version 20th November 2020
 */
public class Team
{
    // The Name of the Team
    private String teamName;
    // The number of matches that the Team has played.
    private int matchesPlayed;
    // Points for winning the match
    private int standingPoints;
    // The number of matches that the Team has Won.
    private int matchesWon;
    // The number of matches that the Team has Lost.
    private int matchesLost;
    // The number of points scored by the Team in the Division.
    private int pointsFor;
    // The number of points scored against the Team in the Division.
    private int pointsAgainst;   
    // Point difference PF - PA.
    private int pointsDifference;
    //ArrayList storing the Team's players and coaches.
    private ArrayList<Human> teamList;

    /**
     * Constructor for objects of class Team which
     * assigns all the necessary attributes to it.
     */
    public Team(String teamName)
    {
        // initialise instance variables
        this.teamName = teamName;
        teamList = new ArrayList<>();
        createTeam();
    }
    
    /**
     * Accessor method for the name of the Team.
     * 
     * @return The team name.
     */
    public String getTeamName(){
        return teamName;
    }
    
    /**
     * Mutator method for the name of the Team.
     * 
     * @param The new name for the Team.
     */
    public void setTeamName(String newTeamName){
        teamName = newTeamName;
    }
  
    /**
     * Accessor method for the points gained
     * for winning the match
     * 
     * @return the points of the team.
     */
    public int getStandingPoints(){
        return standingPoints;
    }
    
    /**
     * Mutator method for the points gained
     * for winning the match
     */
    public void setStandingPoints(int noOfSets){
        // System.out.println(getTeamName() + " " + String.valueOf(noOfSets)); //Uncomment for printing and checking the results!
        standingPoints += noOfSets;
    }
    
    /**
     * Accessor method for the points scored 
     * by the team in the Division.
     * 
     * @return The points scored by the Team.
     */
    public int getPointsFor(){
        return pointsFor;
    }
    
    /**
     * Mutator method for the points scored
     * by the team in the Division.
     * 
     * @param Additional Points scored by the team.
     */
    public void setPointsFor(int addPointsFor){
        pointsFor += addPointsFor;
    }
    
    /**
     * Accessor method for the points against
     * the team in the Division.
     * 
     * @return The points scored against the Team.
     */
    public int getPointsAgainst(){
        return pointsAgainst;
    }
    
    /**
     * Mutator method for the points against
     * the team in the Division.
     * 
     * @param Additional points scored against the Team.
     */
    public void setPointsAgainst(int addPointsAgainst){
        pointsAgainst += addPointsAgainst;
    }
    
    /**
     * The point difference for the Team's point.
     * Subtract pointsAgainst from pointsFor in the Division.
     * 
     * @return The point difference for the Team.
     */
    public int pointDifference(){
        pointsDifference = pointsFor - pointsAgainst;
        
        return pointsDifference;
    }
    
    /**
     * Return whether the Team is full or not.
     * 
     * Check if the number of players are already 12 in 
     * the team and if so, then return null object and indicate 
     * that the Team is already full.
     * Else, add the player to the team.
     */
    public boolean isFull(){
        int playerCount = 0;
        int coachCount = 0;
        for (Human member : teamList){
            if (member instanceof Player)  playerCount++;
            if (member instanceof Coach)   coachCount++;
        }
        
        if (playerCount < 12 && coachCount < 2) return false;
        else                                    return true;
    }
    
    /**
     * Add player to the team.
     * @param Player that is to be added.
     */
    public void addPlayer(Player player){
        boolean fullCheck = isFull();
        if (fullCheck)  return;
        else            teamList.add(player);
    }
     
    /**
     * Create the team player and coach names and add it to ArrayList
     * storing the Team List.
     */
    public void createTeam(){
        int noOfPlayers = 12;  // The maximum number of players in a team.
        int noOfCoaches = 2;  // The maximum number of coaches in a team.
        
        if (isFull()) return; // Check if the team is full or not.
        
        else{
            // Use a for loop to create 12 players and add them to the
            // teamList, also note that jersey numbers are generated randomly
            // between 1 to 100 and associated to the Players.
            for (int i = 0; i < noOfPlayers; i++){
                Random rand = new Random();  // Create randomizer.
                int jerseyNumber = rand.nextInt(100);  // Generate jersey number.
            
                String playerName = "Player number " + String.valueOf(jerseyNumber);
                Human player = new Player(playerName, this);
                teamList.add(player);
            }
        
            // Use a for loop to create 2 coaches and add them to the 
            // teamList.
            for (int j = 0; j <= noOfCoaches-1; j++){
                String coachName = "Coach number " + String.valueOf(j+1);
            
                Human coach = new Coach(coachName);
                teamList.add(coach);
            }
        }
    }
}
