import java.util.Locale;

public class Player {
    private String name;
    private String choice;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setChoice(String choice){
        this.choice = choice.toLowerCase();
    }

    public String getChoice() {
        return choice;
    }
}
