import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Contains #main for running the application.
 */
public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessage welcomeMessage = new WelcomeMessage(System.out);
        welcomeMessage.displayMessage();

        Menu menu = new Menu(createOptions());
        menu.listAllOptions(System.out);

        while(true) {
            menu.runMenuOption(chooseOption(), System.out);
        }
    }

    private static ArrayList<Book> createBookList() {
        Book book1 = new Book("We Are All Completely Beside Ourselves", "Karen Joy Fowler", 2014);
        Book book2 = new Book("Start With Why", "Simon Sinek", 2011);
        Book book3 = new Book("Steve Jobs: The Exclusive Autobiography", "Walter Isaacson", 2015);
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.addAll(Arrays.asList(book1, book2, book3));
        return bookList;
    }

    private static ArrayList<Movie> createMovieList() {
        Movie movie1 = new Movie("Your Name", 2016, "Makoto Shinkai", 9);
        Movie movie2 = new Movie("A Prophet", 2009, "Jacques Audiard", 8);
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.addAll(Arrays.asList(movie1, movie2));
        return movieList;
    }

    private static ArrayList<Option> createOptions() {
        BookLister bookLister = new BookLister(createBookList());
        BookListerOption listBooks = new BookListerOption("List Books", bookLister);
        CheckOutOption checkOutItem = new CheckOutOption("Check Out Book", bookLister);
        ReturnOption returnItem = new ReturnOption("Return Book", bookLister);
        MovieLister movieLister = new MovieLister(createMovieList());
        MovieListerOption listMovies = new MovieListerOption("List Movies", movieLister);
        QuitOption quit = new QuitOption("Quit");
        ArrayList<Option> menuOptions = new ArrayList<>();
        menuOptions.addAll(Arrays.asList(listBooks, checkOutItem, returnItem, listMovies, quit));
        return menuOptions;
    }

    private static String chooseOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter the initials of your menu choice.");
        return scanner.next().toUpperCase();
    }
}
