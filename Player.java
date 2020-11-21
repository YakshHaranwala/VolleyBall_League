/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Human
{
    // The Jersey Number for the Player.
    private int jerseyNumber;

    /**
     * Constructor for objects of class Player.
     * 
     * The constructor for the Player class that
     * assigns name and a jerseyNumber to the player.
     */
    public Player(String name, int jerseyNumber)
    {
        super(name);
        this.jerseyNumber = jerseyNumber;
    }

    /**
     * Accessor method for the Player's Jersey Number.
     * 
     * @return the player's jersey number.
     */
    public int getJerseyNumber(){
        return jerseyNumber;
    }
    
    /**
     * Mutator method for the Player's Jersey Number.
     * 
     * @param the new jersey number for the player.
     */
    public void setJerseyNumber(int newJerseyNumber){
        jerseyNumber = newJerseyNumber;
    }
}
