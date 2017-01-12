import java.util.ArrayList;

/**
 * Class to return a list of books.
 */

public class BookLister {
    private ArrayList<Book> bookDirectory;

    public BookLister(ArrayList<Book> bd) {
        bookDirectory = bd;
    }

    public void listAllBooks() {
        for(Book b : bookDirectory) {
            b.printTitle(System.out);
        }
    }
}
