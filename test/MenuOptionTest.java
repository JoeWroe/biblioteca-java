import org.junit.Test;

import static org.junit.Assert.*;

/**
 * For testing MenuOption
 */
public class MenuOptionTest {

    private MenuOption menuOption;

    @Test
    public void nameShouldReturnTheNameOfTheOption() {
        menuOption = new MenuOption("List Books");
        assertEquals("List Books", menuOption.name());
    }
}