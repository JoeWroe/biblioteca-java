import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Class for setting up a Main Menu with Options.
 */
public class MainMenu {

    private ArrayList<MainMenuOption> mainMenuOptions;

    public MainMenu(ArrayList<MainMenuOption> options) {
        mainMenuOptions = options;
    }

    public void listAllOptions(PrintStream printStream) {
        for(MainMenuOption option : mainMenuOptions) {
            printStream.println(option.name());
        }
    }
}
