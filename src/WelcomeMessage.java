import java.io.PrintStream;

/**
 * Class for printing a welcome message.
 */
public class WelcomeMessage {
    private PrintStream printStream;

    public WelcomeMessage(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void displayMessage() {
        printStream.println("\nHELLO FROM THE ADELE-O-TECA\n");
    }
}
