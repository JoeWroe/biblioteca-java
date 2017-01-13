import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

/**
 * For testing MainMenu.
 */
public class MainMenuTest {

    private MainMenu mainMenu;
    private MainMenuOption mainMenuOption1;

    @Before
    public void setUpMainMenuOption() {
        mainMenuOption1 = mock(MenuOption.class);
        when(mainMenuOption1.name()).thenReturn("List Books");
    }

    @Before
    public void setUpMainMenu() {
        ArrayList<MainMenuOption> mainMenuOptions = new ArrayList<>();
        mainMenuOptions.addAll(Arrays.asList(mainMenuOption1));
        mainMenu = new MainMenu(mainMenuOptions);
    }

    @Test
    public void mainMenuShouldListAllOptions() {
        PrintStream printStreamMock = mock(PrintStream.class);
        mainMenu.listAllOptions(printStreamMock);
        verify(printStreamMock).println("List Books");
    }
}