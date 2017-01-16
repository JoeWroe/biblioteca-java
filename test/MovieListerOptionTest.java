import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * For testing MovieListerOption
 */
public class MovieListerOptionTest {

    private MovieListerOption movieListerOption;
    private MovieLister movieLister;

    @Before
    public void createMovieListerMock() {
        movieLister = mock(MovieLister.class);
        movieListerOption = new MovieListerOption("List Movies", movieLister);
    }

    @Test
    public void nameShouldReturnListerOptionName() {
        assertEquals("List Movies", movieListerOption.name());
    }

    @Test
    public void listMoviesShouldBeRunableToListAllMovies() {
        movieListerOption.run();
        verify(movieLister, times(1)).listAllMovies();
    }
}