import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * For testing BookListerOption
 */
public class BookListerOptionTest {

    private BookListerOption bookListerOption;
    private BookLister bookLister;

    @Before
    public void createBookListerMock() {
        bookLister = mock(BookLister.class);
        bookListerOption = new BookListerOption("List Books", bookLister);
    }

    @Test
    public void nameShouldReturnListerOptionName() {
        assertEquals("List Books", bookListerOption.name());
    }

    @Test
    public void listBooksShouldBeRunableToListAllBooks() {
        bookListerOption.run();
        verify(bookLister, times(1)).listAllBooks();
    }
}