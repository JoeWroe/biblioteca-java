import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Class for setting up a Main Menu with Options.
 */
public class Menu {

    private ArrayList<Option> options;

    public Menu(ArrayList<Option> options) {
        this.options = options;
    }

    public void listAllOptions(PrintStream printStream) {
        for(Option option : options) {
            printStream.println(option.name());
        }
    }

    public void runMenuOption(String menuOption) {
        for (Option option : options) {
            if (menuOption.equals(generateCommandFromUserInput(option.name()))) option.run();
        }
    }

    private String generateCommandFromUserInput(String userInput) {
        String[] splitUserInput = userInput.split("\\s+");
        String command = "";
        for(String word : splitUserInput) {
            command += word.substring(0,1);
        }
        return command.toUpperCase();
    }
}
