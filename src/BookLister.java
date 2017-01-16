import java.util.ArrayList;
import java.util.Scanner;

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
            if (!b.isCheckedOut()) {
                b.printDetails(System.out);
            }
        }
    }

    public void checkOut() {
        Book book = new Book(getItemTitle(), getItemAuthor(), getItemPublishedYear());
        System.out.println(checkOutItem(book));
    }

    private String checkOutItem(Book book) {
        for(Book b : bookDirectory) {
            if(b.isEqualTo(book) && !b.isCheckedOut()) return b.checkOutBook();
        }
        return "That book is unavailable.";
    }

    public String getItemTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the title: ");
        return scanner.nextLine().trim();
    }

    public String getItemAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the author: ");
        return scanner.nextLine().trim();
    }

    public int getItemPublishedYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the published year: ");
        return scanner.nextInt();
    }
}
