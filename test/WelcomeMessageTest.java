import org.junit.Test;
import java.io.PrintStream;
import static org.mockito.Mockito.*;

/**
 * Test #WelcomeMessage.
 */
public class WelcomeMessageTest {
    private WelcomeMessage welcomeMessage;

    @Test
    public void displayMessageShouldPrintAWelcomeMessage() {
        String message = "\nHELLO FROM THE ADELE-O-TECA\n";
        PrintStream printStreamMock = mock(PrintStream.class);

        welcomeMessage = new WelcomeMessage(printStreamMock);
        welcomeMessage.displayMessage();

        verify(printStreamMock).println(message);
    }
}