/**
 * A class to handle the 'List Books' option for the Main Menu.
 */
public class ListerOption implements Option {

    private String name;
    private BookLister bookLister;

    public ListerOption(String name, BookLister bookLister) {
        this.name = name;
        this.bookLister = bookLister;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void run() {
        bookLister.listAllBooks();
    }
}
