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
        listerOption = new ListerOption("List Books", bookLister);
    }

    @Test
    public void nameShouldReturnListerOptionName() {
        assertEquals("List Books", listerOption.name());
    }

    @Test
    public void listBooksShouldBeRunableToListAllBooks() {
        listerOption.run();
        verify(bookLister, times(1)).listAllBooks();
    }
}