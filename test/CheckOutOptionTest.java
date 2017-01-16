import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * For testing CheckOutOption
 */
public class CheckOutOptionTest {

    private CheckOutOption checkOutOption;
    private BookLister bookLister;

    @Before
    public void setUpBookListerAndCheckOutOption() {
//      setUpBookLister
        bookLister = mock(BookLister.class);

//      AndCheckOutOption
        checkOutOption = new CheckOutOption("Check Out", bookLister);
    }

    @Test
    public void nameShouldReturnOptionName() {
        assertEquals("Check Out", checkOutOption.name());
    }

    @Test
    public void runShouldExecuteCheckOutMethodOfBookLister() {
        checkOutOption.run();
        verify(bookLister, times(1)).checkOut();
    }
}