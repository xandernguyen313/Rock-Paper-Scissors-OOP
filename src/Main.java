import java.awt.*;

public class Main {

    public static void main(String[] args) {


//        Computer comp = new Computer();
//        User user = new User();
//        user.selectChoice();
//        comp.selectChoice();
//        user.setChoice(GameChoice.SCISSORS);
//        System.out.println(comp.getChoice());
//        System.out.println(user.getChoice().equals(comp.getChoice()));
        Game game = new Game();
        game.selectUserChoice();
        game.selectComputerChoice();
        game.checkForWinner();
        System.out.println(game.getComputer().getChoice());
        System.out.println(game.winner);

    }
}
