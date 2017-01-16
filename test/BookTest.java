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
    public void bookShouldBeAbleToReturnItsAuthor() {
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
        verify(printStreamMock).printf("%-1.1s %-50.50s %-30.30s %-30.30s%n", "- ", "We Are All Completely Beside Ourselves", "Karen Joy Fowler", 2014);
    }

    @Test
    public void isEqualToShouldReturnTrueIfTheBookPassedHasMatchingProperties() {
        Book matchingBook = new Book("We Are All Completely Beside Ourselves", "Karen Joy Fowler", 2014);
        assertTrue(book.isEqualTo(matchingBook));
    }

    @Test
    public void isEqualToShouldReturnFalseIfTheBookPassedDoesNotMatch() {
        Book nonMatchingBook = new Book("The Very Hungry Caterpillar", "Eric Carle", 2002);
        assertFalse(book.isEqualTo(nonMatchingBook));
    }

    @Test
    public void checkOutShouldSetTheBooksCheckedOutToTrue() {
        book.checkOutBook();
        assertTrue(book.isCheckedOut());
    }

    @Test
    public void returnBookShouldSetTheBooksCheckedOutToFalse() {
        book.checkOutBook();
        book.returnBook();
        assertFalse(book.isCheckedOut());
    }
}