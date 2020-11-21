/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Human
{
    // The Team that the Player plays for.
    private Team team;

    /**
     * Constructor for objects of class Player.
     * 
     * The constructor for the Player class that
     * assigns name and a jerseyNumber to the player.
     */
    public Player(String name, Team team)
    {
        super(name);
        this.team = team;
    }

    
    /**
     * Accessor method for the Player's Team.
     * 
     * @return The team that the player plays for.
     */
    public Team getTeam(){
        return team;
    }
    
    /**
     * Mutator method for the Player's Team.
     * 
     * @param The new Team for the player.
     */
    public void setTeam(Team newTeam){
        team = newTeam;
    }
    
    /**
     * Return the information of the Player.
     * 
     * @return the name of the player name along with jerseyNumber
     *         by overriding the toString method.
     */
    public String toString(){
        return team.getTeamName() + getName();
    }
}
