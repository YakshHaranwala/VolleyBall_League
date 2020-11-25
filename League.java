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
        //String[] division_1_teams = {"LA Lakers", "Toronto Raptors", 
                                     //"Boston Celtics", "Chicago Bulls", 
                                     ///"Pheonix Suns"};
        //String[] division_2_teams = {"Real Madrid VC", "VC Barcelona",  
                                     //"Bayern Munich VC", "Manchester City",
                                    // "Liverpool VC"};
        //String[] division_3_teams = {"Chennai Super Kings", "Mumbai Indians",
                                    // "RCB", "Sunrisers Hyderabad",
                                    // "Kings XI Punjab"};
                                    
        for(int i = 0; i <= 2; i++){
            String[] arr = new String[5];
        }
        
        // Create 3 division.                             
        Division division_1 = new Division(division_1_teams);
        Division division_2 = new Division(division_2_teams);
        Division division_3 = new Division(division_3_teams);
        
        // Add the divisions to the divisionList.
        divisionList.add(division_1);
        divisionList.add(division_2);
        divisionList.add(division_3);
    }
}
