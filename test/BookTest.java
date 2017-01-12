import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * For testing Book.
 */
public class BookTest {
    private Book book;

    @Before
    public void beforeEach() {
        book = new Book("We Are All Completely Beside Ourselves");
    }

    @Test
    public void booksShouldBeAbleToReturnTheirTitle() {
        assertEquals("We Are All Completely Beside Ourselves", book.title());
    }

    @Test
    public void booksShouldBeAbleToPrintTheirTitle() {
        PrintStream printStreamMock = mock(PrintStream.class);
        book.printTitle(printStreamMock);
        verify(printStreamMock).println("We Are All Completely Beside Ourselves");
    }

}