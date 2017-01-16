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

    public void returnBook() {
        Book book = new Book(getItemTitle(), getItemAuthor(), getItemPublishedYear());
        System.out.println(returnItem(book));
    }

    private String checkOutItem(Book book) {
        for(Book b : bookDirectory) {
            if(b.isEqualTo(book) && !b.isCheckedOut()) return b.checkOutBook();
        }
        return "That book is unavailable.";
    }

    private String returnItem(Book book) {
        for(Book b : bookDirectory) {
            if(b.isEqualTo(book) && b.isCheckedOut()) return b.returnBook();
        }
        return "That book is not a valid return item.";
    }

    private String getItemTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the title: ");
        return scanner.nextLine().trim();
    }

    private String getItemAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the author: ");
        return scanner.nextLine().trim();
    }

    private int getItemPublishedYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the published year: ");
        return scanner.nextInt();
    }
}
