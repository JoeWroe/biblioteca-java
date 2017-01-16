/**
 * A class to handle the 'List Books' option for the Main Menu.
 */
public class BookListerOption implements Option {

    private String name;
    private BookLister bookLister;

    public BookListerOption(String name, BookLister bookLister) {
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
