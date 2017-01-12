import java.util.ArrayList;
import java.util.Arrays;

/**
 * Contains #main for running the application.
 */
public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessage welcomeMessage = new WelcomeMessage(System.out);
        welcomeMessage.displayMessage();
        ArrayList<Book> bookList = createBookList();
        BookLister bookLister = new BookLister(bookList);
        bookLister.listAllBooks();
    }

    private static ArrayList<Book> createBookList() {
        Book book1 = new Book("We Are All Completely Beside Ourselves");
        Book book2 = new Book("Start With Why");
        Book book3 = new Book("Steve Jobs: The Autobiography");
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.addAll(Arrays.asList(book1, book2, book3));
        return bookList;
    }
}
