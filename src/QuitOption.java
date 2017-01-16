/**
 * A class to handle the 'Quit' option for the Main Menu.
 */
public class QuitOption implements Option {

    private String name;

    public QuitOption(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void run() {
        System.exit(0);
    }
}
