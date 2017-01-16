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
    private PrintStream printStreamMock;

    @Before
    public void setUpPrintStream() {
        printStreamMock = mock(PrintStream.class);
    }

    @Before
    public void setUpMenuOptionAndAddToMenu() {
//      setUpMenuOption
        option1 = mock(ListerOption.class);
        when(option1.name()).thenReturn("List Books");

//      AndAddToMenu
        ArrayList<Option> options = new ArrayList<>();
        options.addAll(Arrays.asList(option1));
        menu = new Menu(options);
    }

    @Test
    public void menuShouldListAllOptions() {
        menu.listAllOptions(printStreamMock);
        verify(printStreamMock).println("HELLO FROM THE MAIN MENU");
        verify(printStreamMock).println("- List Books");
    }

    @Test
    public void runMenuOptionShouldExecuteTheRunMethodOfTheObjectPassed() {
        menu.runMenuOption("LB", printStreamMock);
        verify(option1, times(1)).run();
    }

    @Test
    public void runMenuOptionShouldDisplayAnErrorIfAnInvalidCommandIsPassed() {
        menu.runMenuOption("A none valid command", printStreamMock);
        verify(printStreamMock).println("An invalid option has been passed,\n" +
                                        "Please enter a valid option,\n" +
                                        "A valid option is made up of the first letter of each word in the option.");
    }
}