import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * For testing ListerOption
 */
public class ListerOptionTest {

    private ListerOption listerOption;
    private BookLister bookLister;

    @Before
    public void createBookListerMock() {
        bookLister = mock(BookLister.class);
    }

    @Test
    public void nameShouldReturnListerOptionName() {
        listerOption = new ListerOption("List Books", bookLister);
        assertEquals("List Books", listerOption.name());
    }

    @Test
    public void listBooksShouldBeRunableToListAllBooks() {
        listerOption = new ListerOption("List Books", bookLister);
        listerOption.run();
        verify(bookLister, times(1)).listAllBooks();
    }
}