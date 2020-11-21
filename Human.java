/**
 * Abstract class Human.
 * The Human class serves as a Base class for the Player and Coach classes.
 * The purpose of the Human class is to provide a BluPrint of what is expected
 * in the Player and Coach Classes.
 *
 * @author Salman Haidri, Yaksh J Haranwala, Hasan Zobaer Chowdhury
 * @date 20th November 2020
 */
public abstract class Human
{
    // Name of the Human.
    private String name;
    
    /**
     * Create a Human object and initiate the field variables.
     */
    public Human(String name)
    {
        this.name = name;
    }
    
    /**
     * Accessor method for the name of the Human.
     *   
     * @return  The Name of the Human.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Mutator method for the name of the Human.
     * 
     * @param name is the name that we want to set for the Human.
     */
    public void getName(String newName){
        name = newName;
    }
}
