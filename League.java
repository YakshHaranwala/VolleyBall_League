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
        Division division_1 = new Division(division_1_teams);
        Division division_2 = new Division(division_2_teams);
        Division division_3 = new Division(division_3_teams);
        
        // Add the divisions to the divisionList
        divisionList.add(division_1);
        divisionList.add(division_2);
        divisionList.add(division_3);
    }
}
