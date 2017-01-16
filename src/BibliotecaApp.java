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

    private static ArrayList<Option> createOptions() {
        BookLister bookLister = new BookLister(createBookList());
        ListerOption listBooks = new ListerOption("List Books", bookLister);
        ArrayList<Option> menuOptions = new ArrayList<>();
        menuOptions.addAll(Arrays.asList(listBooks));
        return menuOptions;
    }

    private static String chooseOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the initials of your menu choice.");
        return scanner.next().toUpperCase();
    }
}
