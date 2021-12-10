import java.awt.*;

public class Main {

    public static void main(String[] args) {

        GameChoice choice = GameChoice.ROCK;
        GameChoice otherChoice = GameChoice.SCISSORS;

        User player1 = new User();
        player1.selectChoice();
        System.out.println(player1.getChoice());
    }
}
