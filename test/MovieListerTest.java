import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.*;
import static org.mockito.Mockito.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;



/**
 * For testing MovieLister
 */
public class MovieListerTest {

    private Movie moiveMock1;
    private Movie movieMock2;
    private PrintStream printStreamMock;
    private ArrayList<Movie> movieDirectory;
    private MovieLister movieLister;

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setUpBookMocksAndAddThemToADirectory() {
//      setupBookMocks
        moiveMock1 = mock(Movie.class);
        movieMock2 = mock(Movie.class);

//      AndAddThemToADirectory
        movieDirectory = new ArrayList<>();
        movieDirectory.addAll(Arrays.asList(moiveMock1, movieMock2));
        movieLister = new MovieLister( movieDirectory);
    }

    @Before
    public void setUpPrintStreamMock() {
        printStreamMock = mock(PrintStream.class);
    }

    @Test
    public void movieListerShouldBeAbleToListAllMoviesThatAreNotCheckedOut() {
        when(moiveMock1.isCheckedOut()).thenReturn(false);
        when(movieMock2.isCheckedOut()).thenReturn(true);
        movieLister.listAllMovies();
        verify(moiveMock1, times(1)).printDetails(System.out);
        verify(movieMock2, never()).printDetails(System.out);
    }

    @Test
    public void checkOutShouldPrintASuccessMessageIfUserHasSuccessfullyCheckedOut() {
        systemInMock.provideLines("Your Name", "2016", "Makoto Shinkai", "9");
        when(moiveMock1.isCheckedOut()).thenReturn(false);
        when(moiveMock1.isEqualTo(any(Movie.class))).thenReturn(true);
        when(moiveMock1.checkOutMovie()).thenReturn("Thank you! Enjoy the movie.");
        movieLister.checkOut();
        assertTrue(systemOutRule.getLog().contains("Thank you! Enjoy the movie."));
    }

    @Test
    public void checkOutShouldPrintAFailureMessageIfItCouldNotCheckOut() {
        systemInMock.provideLines("Your Name", "2016", "Makoto Shinkai", "9");
        movieLister.checkOut();
        assertTrue(systemOutRule.getLog().contains("That movie is unavailable."));
    }

    @Test
    public void returnMovieShouldPrintASuccessMessageIfUserHasSuccessfullyReturnedAMovie() {
        systemInMock.provideLines("Your Name", "2016", "Makoto Shinkai", "9");
        when(moiveMock1.isCheckedOut()).thenReturn(true);
        when(moiveMock1.isEqualTo(any(Movie.class))).thenReturn(true);
        when(moiveMock1.returnMovie()).thenReturn("Thank you for returning the movie.");
        movieLister.returnMovie();
        assertTrue(systemOutRule.getLog().contains("Thank you for returning the movie."));
    }

    @Test
    public void returnMovieShouldPrintAFailureMessageIfItCouldNotReturnAMovie() {
        systemInMock.provideLines("Your Name", "2016", "Makoto Shinkai", "9");
        movieLister.returnMovie();
        assertTrue(systemOutRule.getLog().contains("That movie is not a valid return item."));
    }
}