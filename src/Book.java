import java.io.PrintStream;

/**
 * Class for representing a book as an object.
 */
public class Book {
    private String title;

    public Book(String t) {
        title = t;
    }

    public String title() {
        return title;
    }

    public void printTitle(PrintStream printStream) {
        printStream.println(title());
    }
}
