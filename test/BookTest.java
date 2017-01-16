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
        book = new Book("We Are All Completely Beside Ourselves", "Karen Joy Fowler", 2014);
    }

    @Test
    public void booksShouldBeAbleToReturnItsTitle() {
        assertEquals("We Are All Completely Beside Ourselves", book.title());
    }

    @Test
    public void bookShouldBeAbleToReturnItsAutor() {
        assertEquals("Karen Joy Fowler", book.author());
    }

    @Test
    public void bookShouldBeAbleToReturnItsPublishYear() {
        assertEquals(2014, book.publishedYear());
    }

    @Test
    public void booksShouldBeAbleToPrintTheirDetails() {
        PrintStream printStreamMock = mock(PrintStream.class);
        book.printDetails(printStreamMock);
        verify(printStreamMock).println("We Are All Completely Beside Ourselves\tKaren Joy Fowler\t2014");
    }

    @Test
    public void checkedOutShouldSetTheBooksCheckedOutToTrue() {
        book.checkedOut();
        assertTrue(book.isCheckedOut());
    }

    @Test
    public void returnedShouldSetTheBooksCheckedOutToFalse() {
        book.checkedOut();
        book.returned();
        assertFalse(book.isCheckedOut());
    }
}