import java.io.PrintStream;

/**
 * Class for representing a book as an object.
 */
public class Book {
    private String title;
    private String author;
    private int publishedYear;
    private boolean checkedOut;

    public Book(String t, String a, int p) {
        title = t;
        author = a;
        publishedYear = p;
        checkedOut = false;
    }

    public String title() {
        return title;
    }

    public String author() { return author; }

    public int publishedYear() { return publishedYear; }

    public void printDetails(PrintStream printStream) {
        printStream.println(title()+"\t"+author()+"\t"+publishedYear());
    }

    public String checkOutBook() {
        checkedOut = true;
        return "Thank you! Enjoy the book";
    }

    public String returnBook() {
        checkedOut = false;
        return "Thank you for returning the book.";
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public boolean isEqualTo(Book book) {
        return title.equals(book.title()) && author.equals(book.author()) && publishedYear == book.publishedYear();
    }
}
