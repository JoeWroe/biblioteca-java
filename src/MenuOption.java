/**
 * A class to handle the options for the Main Menu.
 */
public class MenuOption implements MainMenuOption {
    private String menuOptionName;
    private BookLister bookLister;

    public MenuOption(String name, BookLister bookListerObject) {
        menuOptionName = name;
        bookLister = bookListerObject;
    }

    @Override
    public String name() {
        return menuOptionName;
    }

    @Override
    public void run() {
        bookLister.listAllBooks();
    }
}
