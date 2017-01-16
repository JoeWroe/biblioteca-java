import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * For Testing QuitOption
 */
public class QuitOptionTest {
    
    private QuitOption quitOption;

    @Before
    public void setUpQuitOption() {
        quitOption = new QuitOption("Quit");
    }

    @Test
    public void nameShouldReturnQuitOptionName() {
        assertEquals("Quit", quitOption.name());
    }
}