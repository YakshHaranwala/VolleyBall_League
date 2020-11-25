import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DivisionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DivisionTest
{
    private Division division1;
    private Team team1;
    private Team team2;

    /**
     * Default constructor for test class DivisionTest
     */
    public DivisionTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        String[] arr = {"LA Lakers", "Toronto Raptors","Boston Celtics", "Chicago Bulls", "Pheonix Suns"};
        division1 = new Division(arr);
        team1 = new Team("A");
        team2 = new Team("B");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
