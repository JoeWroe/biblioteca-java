
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.*;
import static org.mockito.Mockito.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import java.util.ArrayList;
import java.util.Arrays;



/**
 * For testing BookLister
 */
public class BookListerTest {
    
    private Book bookMock1;
    private Book bookMock2;
    private ArrayList<Book> bookDirectory;
    private BookLister bookLister;

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setUpBookMocksAndAddThemToADirectory() {
//      setupBookMocks
        bookMock1 = mock(Book.class);
        bookMock2 = mock(Book.class);

//      AndAddThemToADirectory
        bookDirectory = new ArrayList<>();
        bookDirectory.addAll(Arrays.asList(bookMock1, bookMock2));
        bookLister = new BookLister(bookDirectory);
    }

    @Test
    public void bookListerShouldBeAbleToListAllBooksThatAreNotCheckedOut() {
        when(bookMock1.isCheckedOut()).thenReturn(false);
        when(bookMock2.isCheckedOut()).thenReturn(true);
        bookLister.listAllBooks();
        verify(bookMock1, times(1)).printDetails(System.out);
        verify(bookMock2, never()).printDetails(System.out);
    }

    @Test
    public void checkOutShouldPrintASuccessMessageIfUserHasSuccessfullyCheckedOut() {
        systemInMock.provideLines("We Are All Completely Beside Ourselves", "Karen Joy Fowler", "2014");
        when(bookMock1.isCheckedOut()).thenReturn(false);
        when(bookMock1.isEqualTo(any(Book.class))).thenReturn(true);
        when(bookMock1.checkOutBook()).thenReturn("Thank you! Enjoy the book.");
        bookLister.checkOut();
        assertTrue(systemOutRule.getLog().contains("Thank you! Enjoy the book."));
    }

    @Test
    public void checkOutShouldPrintAFailureMessageIfItCouldNotCheckOut() {
        systemInMock.provideLines("We Are All Completely Beside Ourselves", "Karen Joy Fowler", "2014");
        bookLister.checkOut();
        assertTrue(systemOutRule.getLog().contains("That book is unavailable."));
    }

    @Test
    public void returnBookShouldPrintASuccessMessageIfUserHasSuccessfullyReturnedABook() {
        systemInMock.provideLines("We Are All Completely Beside Ourselves", "Karen Joy Fowler", "2014");
        when(bookMock1.isCheckedOut()).thenReturn(true);
        when(bookMock1.isEqualTo(any(Book.class))).thenReturn(true);
        when(bookMock1.returnBook()).thenReturn("Thank you for returning the book.");
        bookLister.returnBook();
        assertTrue(systemOutRule.getLog().contains("Thank you for returning the book."));
    }

    @Test
    public void returnBookShouldPrintAFailureMessageIfItCouldNotReturnABook() {
        systemInMock.provideLines("We Are All Completely Beside Ourselves", "Karen Joy Fowler", "2014");
        bookLister.returnBook();
        assertTrue(systemOutRule.getLog().contains("That book is not a valid return item."));
    }
}