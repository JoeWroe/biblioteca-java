import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * For testing Movie
 */
public class MovieTest {

    private Movie movie;

    @Before
    public void beforeEach() {
        movie = new Movie("Your Name", 2016, "Makoto Shinkai", 9);
    }

    @Test
    public void moviesShouldBeAbleToReturnTheirTitle() {
        assertEquals("Your Name", movie.name());
    }

    @Test
    public void moviesShouldBeAbleToReturnTheirYear() {
        assertEquals(2016, movie.year());
    }

    @Test
    public void moviesShouldBeAbleToReturnTheirDirector() {
        assertEquals("Makoto Shinkai", movie.director());
    }

    @Test
    public void moviesShouldBeAbleToReturnTheirRating() {
        assertEquals(9, movie.rating());
    }

    @Test
    public void moviesShouldBeAbleToPrintTheirDetails() {
        PrintStream printStreamMock = mock(PrintStream.class);
        movie.printDetails(printStreamMock);
        verify(printStreamMock).printf("%-1.1s %-30.30s %-30.30s %-30.30s %-30.30s%n", "- ", "Your Name", 2016, "Makoto Shinkai", 9);
    }

    @Test
    public void isEqualToShouldReturnTrueIfTheMoviePassedHasMatchingProperties() {
        Movie matchingMovie = new Movie("Your Name", 2016, "Makoto Shinkai", 9);
        assertTrue(movie.isEqualTo(matchingMovie));
    }

    @Test
    public void isEqualToShouldReturnFalseIfTheMoviePassedDoesNotMatch() {
        Movie nonMatchingMovie = new Movie("A Prophet", 2009, "Jacques Audiard", 8);
        assertFalse(movie.isEqualTo(nonMatchingMovie));
    }

    @Test
    public void checkOutShouldSetTheBooksCheckedOutToTrue() {
        movie.checkOutMovie();
        assertTrue(movie.isCheckedOut());
    }

    @Test
    public void returnMovieShouldSetTheMoviesCheckedOutStatusToFalse() {
        movie.checkOutMovie();
        movie.returnMovie();
        assertFalse(movie.isCheckedOut());
    }
}