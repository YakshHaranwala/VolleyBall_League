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
    // The Division that the team is playing in.
    private Division division;
    // The number of matches that the Team has played.
    private int matchesPlayed;
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

    /**
     * Constructor for objects of class Team which
     * assigns all the necessary attributes to it.
     */
    public Team(String teamName, Division division)
    {
        // initialise instance variables
        this.teamName = teamName;
        this.division = division;
    }
}
