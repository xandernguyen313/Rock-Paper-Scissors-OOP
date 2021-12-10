public class Game implements GameController {
    public Winner winner;
    private Computer computer;
    private User user;

    public Game(){
        computer = new Computer();
        user = new User();
    }
    public User getUser() {
        return user;
    }
    public Computer getComputer() {
        return computer;
    }
    @Override
    public void welcome() {
        System.out.println("====================================");
        System.out.printf("%25s", "Welcome to \n");
        System.out.printf("%25s","The Game Of \n");
        System.out.printf("%32s","ROCK PAPER AND SCISSORS \n");
        System.out.println("====================================");
    }

    @Override
    public void displayMainMenu() {
        System.out.println("MAIN MENU");
        System.out.println("=========");
        System.out.println("1. Type 'computer' to play with a computer.");
        System.out.println("1. Type '2 players' to play with a friend.");
        System.out.println("2. Type 'quit' to exit.");
        System.out.println();
    }
    @Override
    public void selectUserChoice() {
        user.selectChoice();
    }

    @Override
    public void selectComputerChoice() {
        computer.selectChoice();
    }

    @Override
    public void displayResult() {
        System.out.println("Computer picks: ");
        System.out.println("User picks: ");
        System.out.println("winner");
    }

    @Override
    public void checkForWinner() {
        GameChoice player1 = user.getChoice();
        GameChoice player2 = computer.getChoice();
        if(player1.equals(player2)) {
            winner = Winner.TIE;
        } else if(player1.beats(player2)) {
            winner = Winner.USER;
        } else {
            winner = Winner.COMPUTER;
        }
    }

}
