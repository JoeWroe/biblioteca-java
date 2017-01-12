
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * For testing BookLister
 */
public class BookListerTest {
    private Book bookMock1;
    private Book bookMock2;
    private ArrayList<Book> bookDirectory;

    @Before
    public void beforeEach() {
        bookMock1 = mock(Book.class);
        bookMock2 = mock(Book.class);
        bookDirectory = new ArrayList<>();
        bookDirectory.addAll(Arrays.asList(bookMock1, bookMock2));
    }

    @Test
    public void bookDirectoryShouldBeAbleToListAllBooks() {
        BookLister bookLister = new BookLister(bookDirectory);
        bookLister.listAllBooks();
        verify(bookMock1, times(1)).printDetails(System.out);
        verify(bookMock1, times(1)).printDetails(System.out);
    }


}