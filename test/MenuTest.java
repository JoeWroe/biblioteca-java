import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

/**
 * For testing Menu.
 */
public class MenuTest {

    private Menu menu;
    private Option option1;

    @Before
    public void setUpMainMenuOption() {
        option1 = mock(ListerOption.class);
        when(option1.name()).thenReturn("List Books");
    }

    @Before
    public void setUpMainMenu() {
        ArrayList<Option> options = new ArrayList<>();
        options.addAll(Arrays.asList(option1));
        menu = new Menu(options);
    }

    @Test
    public void mainMenuShouldListAllOptions() {
        PrintStream printStreamMock = mock(PrintStream.class);
        menu.listAllOptions(printStreamMock);
        verify(printStreamMock).println("List Books");
    }

    @Test
    public void runMainMenuOptionShouldExecuteTheRunMethodOfTheObjectPassed() {
        menu.runMenuOption("List Books");
        verify(option1, times(1)).run();
    }
}