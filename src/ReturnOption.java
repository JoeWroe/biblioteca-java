/**
 * A class to handle the 'Return' option of the Main Menu.
 */
public class ReturnOption implements Option {

    private String name;
    private BookLister bookLister;

    public ReturnOption(String name, BookLister bookLister) {
        this.name = name;
        this.bookLister = bookLister;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void run() {
        bookLister.returnBook();
    }

}
