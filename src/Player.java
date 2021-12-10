import java.util.Locale;
// Parent class of Computer and User
public abstract class Player {
    private String name;
    private GameChoice choice;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setChoice(GameChoice choice){
        this.choice = choice;
    }

    public GameChoice getChoice() {
        return choice;
    }

    // This method will have 2 different implementation
    // One for computer
    // One for user
    public abstract void selectChoice();
}
