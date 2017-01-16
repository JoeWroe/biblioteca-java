import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Class for setting up a Main Menu with Options.
 */
public class Menu {

    private ArrayList<Option> options;
    private static final String INVALID_OPTION_ERROR_MESSAGE = "An invalid option has been passed,\n" +
                                                               "Please enter a valid option,\n" +
                                                               "A valid option is made up of the first letter of each word in the option.";


    public Menu(ArrayList<Option> options) {
        this.options = options;
    }

    public void listAllOptions(PrintStream printStream) {
        for(Option option : options) {
            printStream.println(option.name());
        }
    }

    public void runMenuOption(String menuOption, PrintStream printStream) {
        if (isAValidOption(menuOption)) {
            for (Option option : options) {
                if (menuOption.equals(generateCommandFromUserInput(option.name()))) option.run();
            }
        } else { printInvalidOptionErrorMessage(printStream); }
    }

    private void printInvalidOptionErrorMessage(PrintStream printStream) {
        printStream.println(INVALID_OPTION_ERROR_MESSAGE);
    }

    private boolean isAValidOption(String menuOption) {
        return commandsList().contains(menuOption);
    }

    private ArrayList<String> commandsList() {
        ArrayList<String> commandsList = new ArrayList<>();
        for(Option option : options) commandsList.add(generateCommandFromUserInput(option.name()));
        return commandsList;
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
