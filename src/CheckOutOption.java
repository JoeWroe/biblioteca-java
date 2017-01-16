/**
 * A class to handle the 'Check Out' option of the Main Menu.
 */
public class CheckOutOption implements Option {

    private String name;
    private BookLister bookLister;

    public CheckOutOption(String name, BookLister bookLister) {
        this.name = name;
        this.bookLister = bookLister;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void run() {
        bookLister.checkOut();
    }
}
