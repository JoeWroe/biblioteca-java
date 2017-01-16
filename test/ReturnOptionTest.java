import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * For testing ReturnOption
 */
public class ReturnOptionTest {

    private ReturnOption returnOption;
    private BookLister bookLister;

    @Before
    public void setUpBookListerAndReturnOption() {
//      setUpBookLister
        bookLister = mock(BookLister.class);

//      AndReturnOption
        returnOption = new ReturnOption("Return", bookLister);
    }

    @Test
    public void nameShouldReturnOptionName() {
        assertEquals("Return", returnOption.name());
    }

    @Test
    public void runShouldExecuteCheckOutMethodOfBookLister() {
        returnOption.run();
        verify(bookLister, times(1)).returnBook();
    }

}