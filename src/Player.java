import java.util.Locale;

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
    public abstract void selectChoice();
}
