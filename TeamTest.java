

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TeamTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TeamTest
{
    private Division division1;
    private Team team1;

    /**
     * Default constructor for test class TeamTest
     */
    public TeamTest()
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
        division1 = new Division();
        team1 = new Team("Raptors", division1);
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

    @Test
    public void testCreateTeam()
    {
        team1.createTeam();
        team1.createTeam();
    }
}

