import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;
import 
public class Game implements GameController {
    public Optional<Player> winner;
    private Computer computer;
    private User user1;
    private User user2;
    private static final Scanner scanner;
    private Score userVsUserHistory;
    private Score userVsComputerHistory;
    private boolean gameOver = false;

    static {
        scanner = new Scanner(System.in);
    }

    public Game(){
        computer = new Computer();
        user1 = new User();
        user2 = new User();
        computer.setName("Computer");
        user1.setName("Player 1");
        user2.setName("Player 2");
        userVsUserHistory = new Score(user1, user2);
        userVsComputerHistory = new Score(user1, computer);
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
        System.out.println("=========");
        System.out.println("1. Type '1' to play with a computer.");
        System.out.println("2. Type '2' to play with a friend.");
        System.out.println("3. Type '3' to see history.");
        System.out.println("4. Type '4' to exit.");
        System.out.println();
    }

    @Override
    public void selectMainMenuChoice(){
        int choice = validateInput();
        switch (choice) {
            case 1:
                user1.selectChoice();
                computer.selectChoice();

                checkForWinner(user1, computer, userVsComputerHistory);
                displayResult(user1, computer);
                break;
            case 2:
                user1.selectChoice();
                user2.selectChoice();
                checkForWinner(user1, user2, userVsUserHistory);
                displayResult(user1, user2);
                break;
            case 3:
                if(userVsComputerHistory.getTotalGamePlayed() != 0) {
                    System.out.println(userVsComputerHistory);
                }
                if(userVsUserHistory.getTotalGamePlayed() != 0) {
                    System.out.println(userVsUserHistory);
                }
                break;
            case 4:
                gameOver = true;
                System.out.println("Thank you for playing. See you soon!");
                break;
            default:
                System.out.println(choice + " is not a valid choice. Try Again!");
        }

        while(!gameOver) {
            displayMainMenu();
            selectMainMenuChoice();
        }
    }

    public int validateInput(){
        while(!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    @Override
    public void displayResult(Player player, Player otherPlayer) {
        System.out.println("===============");
        System.out.println(player.getName() + " picks: " + player.getChoice());
        System.out.println(otherPlayer.getName() +" picks: " + otherPlayer.getChoice());
        System.out.println("Winner: " + winner.map(w -> w.getName()).orElse("TIE"));
        System.out.println();
    }

    @Override
    public void checkForWinner(Player player, Player otherPlayer, Score history) {
        GameChoice player1 = player.getChoice();
        GameChoice player2 = otherPlayer.getChoice();
        if(player1.equals(player2)) {
            winner = Optional.ofNullable(null);
        } else if(player1.beats(player2)) {
            winner = Optional.of(player);
            history.addToRecord(player);
        } else {
            winner = Optional.of(otherPlayer);
            history.addToRecord(otherPlayer);
        }
    }

    public void clear() {
        getConsoleView().clear();
    }


}
