import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joe on 12/01/2017.
 */
public class BookTest {
    public Book book;

    @Before
    public void beforeEach() {
        book = new Book("We Are All Completely Beside Ourselves");
    }

    @Test
    public void booksShouldBeAbleToReturnTheirTitle() {
        assertEquals("We Are All Completely Beside Ourselves", book.title());
    }

}