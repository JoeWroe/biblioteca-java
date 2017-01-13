/**
 * A class to handle the options for the Main Menu.
 */
public class MenuOption implements MainMenuOption {
    private String menuOptionName;

    public MenuOption(String name) {
        menuOptionName = name;
    }

    @Override
    public String name() {
        return menuOptionName;
    }
}
