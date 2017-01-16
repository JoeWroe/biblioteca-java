import java.io.PrintStream;

/**
 * Class for representing a Movie
 */
public class Movie {

    private String name;
    private int year;
    private String director;
    private int rating;
    private boolean checkedOut;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        checkedOut = false;
    }

    public String name() {
        return name;
    }

    public int year() {
        return year;
    }

    public String director() { return director; }

    public int rating() { return rating; }

    public void printDetails(PrintStream printStream) {
        printStream.printf("%-1.1s %-30.30s %-30.30s %-30.30s %-30.30s%n", "- ", name(), year(), director(), rating());
    }

    public String checkOutMovie() {
        checkedOut = true;
        return "Thank you! Enjoy the movie";
    }

    public String returnMovie() {
        checkedOut = false;
        return "Thank you for returning the Movie.";
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public boolean isEqualTo(Movie movie) {
        return name.equals(movie.name()) && year == movie.year() && director.equals(movie.director()) && rating == movie.rating();
    }
}
