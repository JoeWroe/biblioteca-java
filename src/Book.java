import java.io.PrintStream;

/**
 * Class for representing a book as an object.
 */
public class Book {
    private String title;
    private String author;
    private int publishedYear;

    public Book(String t, String a, int p) {
        title = t;
        author = a;
        publishedYear = p;
    }

    public String title() {
        return title;
    }

    public String author() { return author; }

    public int publishedYear() { return publishedYear; }

    public void printDetails(PrintStream printStream) {
        printStream.println(title()+"\t"+author()+"\t"+publishedYear());
    }
}
