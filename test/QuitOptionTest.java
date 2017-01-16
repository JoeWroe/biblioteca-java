import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

/**
 * For Testing QuitOption
 */
public class QuitOptionTest {
    
    private QuitOption quitOption;

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUpQuitOption() {
        quitOption = new QuitOption("Quit");
    }

    @Test
    public void nameShouldReturnQuitOptionName() {
        assertEquals("Quit", quitOption.name());
    }

    @Test
    public void runShouldSystemExitWithStatusCode0() {
        exit.expectSystemExitWithStatus(0);
        quitOption.run();
    }
}