import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * For testing MenuOption
 */
public class MenuOptionTest {

    private MenuOption menuOption;
    private BookLister bookLister;

    @Before
    public void createBookListerMock() {
        bookLister = mock(BookLister.class);
    }

    @Test
    public void nameShouldReturnTheNameOfTheOption() {
        menuOption = new MenuOption("List Books", bookLister);
        assertEquals("List Books", menuOption.name());
    }

    @Test
    public void listBooksShouldBeRunableToListAllBooks() {
        menuOption = new MenuOption("List Books", bookLister);
        menuOption.run();
        verify(bookLister, times(1)).listAllBooks();
    }
}