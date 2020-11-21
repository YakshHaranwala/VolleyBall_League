/**
 * The Player class is the subclass of the Human class.
 * It represents each player that is to be added into the
 * Team. The player object has a reference to the Player's 
 * Team as well as holds the Player's name.
 *
 * @author Salman Haidri, Yaksh J Haranwala, Hasan Zobaer Chowdhury
 * @date   20th November 2020.
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
     *         by overriding the toString method of the Object class.
     */
    public String toString(){
        return team.getTeamName() + getName();
    }
}

