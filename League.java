import java.util.ArrayList;
/**
 *
 * @author Salman Haidri, Yaksh J Haranwala, Hasan Zobaer Chowdhury
 * @date   23rd November 2020
 */
public class League
{
    private ArrayList<Division> divisionList;

    /**
     * Constructor for objects of class League
     */
    public League()
    {
        // initialise instance variables
        divisionList = new ArrayList<>();
    }

    /**
     * Setup a league with 3 divisions.
     * 
     * The 3 Lists containing 5 names are to be passed
     * to 3 divisions (one list each) so as to create 
     * divisions with different team names.
     * 
     */
    public void leagueSetup()
    {
        String[] division_1_teams = {"Division 1 Team 1", "Division 1 Team 2", 
                                     "Division 1 Team 3", "Division 1 Team 4", 
                                     "Division 1 Team 5"};
                                     
        String[] division_2_teams = {"Division 2 Team 1", "Division 2 Team 2", 
                                     "Division 2 Team 3", "Division 2 Team 4", 
                                     "Division 2 Team 5"};
                                     
        String[] division_3_teams = {"Division 3 Team 1", "Division 3 Team 2", 
                                     "Division 3 Team 3", "Division 3 Team 4", 
                                     "Division 3 Team 5"};
                                
        
        // Create 3 division.                             
        Division divisionOne = new Division(division_1_teams);
        Division divisionTwo = new Division(division_2_teams);
        Division divisionThree = new Division(division_3_teams);
        
        // Add the divisions to the divisionList
        divisionList.add(divisionOne);
        divisionList.add(divisionTwo);
        divisionList.add(divisionThree);
        
        //divisionOne.printList();
        //System.out.println();
        
        //divisionTwo.printList();
        //System.out.println();
        
        //divisionThree.printList();
        //System.out.println();
    }
    
    /**
     * Show the simulation of a League.
     * 
     * This method will create 3 divisions and then make 5 teams play matches
     * against each other.
     * Each team will play 1 match against remaining 4 teams.
     * Then, the standings will be calculated accordingly and printed out at the last.
     */
    public void simulateLeague(){
        leagueSetup();
        divisionList.get(0).createMatchups();
        divisionList.get(1).createMatchups();
        divisionList.get(2).createMatchups();
        
        divisionList.get(0).printList();
        divisionList.get(1).printList();
        divisionList.get(2).printList();
    }
}
