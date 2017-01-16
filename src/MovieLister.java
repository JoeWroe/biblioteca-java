import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to return a list of movies.
 */

public class MovieLister {
    private ArrayList<Movie> movieDirectory;
    private static final String LIST_MOVIES_MESSAGE = "\nHELLO FROM THE LIST OF MOVIES";

    public MovieLister(ArrayList<Movie> movieDirectory) {
        this.movieDirectory = movieDirectory;
    }

    public void listAllMovies() {
        PrintStream printStream = new PrintStream(System.out);
        printStream.println(LIST_MOVIES_MESSAGE);
        for(Movie m : movieDirectory) {
            if (!m.isCheckedOut()) {
                m.printDetails(System.out);
            }
        }
    }

    public void checkOut() {
        Movie movie = new Movie(getItemName(), getItemYear(), getItemDirector(), getItemRating());
        System.out.println(checkOutItem(movie));
    }

    public void returnMovie() {
        Movie movie = new Movie(getItemName(), getItemYear(), getItemDirector(), getItemRating());
        System.out.println(returnItem(movie));
    }

    private String checkOutItem(Movie movie) {
        for(Movie m : movieDirectory) {
            if(m.isEqualTo(movie) && !m.isCheckedOut()) return m.checkOutMovie();
        }
        return "That movie is unavailable.";
    }

    private String returnItem(Movie movie) {
        for(Movie m : movieDirectory) {
            if(m.isEqualTo(movie) && m.isCheckedOut()) return m.returnMovie();
        }
        return "That movie is not a valid return item.";
    }

    private String getItemName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the name: ");
        return scanner.nextLine().trim();
    }

    private int getItemYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the year: ");
        return scanner.nextInt();
    }

    private String getItemDirector() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the director: ");
        return scanner.nextLine().trim();
    }

    private int getItemRating() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the rating: ");
        return scanner.nextInt();
    }
}
