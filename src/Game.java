import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;

// Game Class will handle flow of the game
public class Game implements GameController {
    // Has-A relationship
    public Optional<Player> winner;
    private final Computer computer;
    private final User user1;
    private final User user2;
    private final Score userVsUserHistory;
    private final Score userVsComputerHistory;
    private static final Scanner scanner;
    private boolean gameOver = false;

    // Belongs to the Class
    // Only initialize once
    static {
        scanner = new Scanner(System.in);
    }

    // Constructor
    // Create instances of the Class Computer, User, and Score.
    // and start the game.
    public Game(){
        computer = new Computer();
        user1 = new User();
        user2 = new User();
        computer.setName("Computer");
        user1.setName("Player 1");
        user2.setName("Player 2");
        userVsUserHistory = new Score(user1, user2);
        userVsComputerHistory = new Score(user1, computer);
        startGame();
    }

    public void startGame(){
        displayMainMenu();
        selectMainMenuChoice();
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

    // Record users input
    // and call appropriate methods
    @Override
    public void selectMainMenuChoice(){
        // Validate users choice
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

        // Keep looping until user selects option 4 to exit
        while(!gameOver) {
            displayMainMenu();
            selectMainMenuChoice();
        }
    }

    // Validate the users input
    // Make sure the user only enters an integer
    // Return that integer
    public int validateInput(){
        while(!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // This method asks for 2 Player objects
    // E.G: user and computer objects or user1 vs user2
    // and display the result of that game
    @Override
    public void displayResult(Player player, Player otherPlayer) {
        System.out.println("===============");
        System.out.println(player.getName() + " picks: " + player.getChoice());
        System.out.println(otherPlayer.getName() +" picks: " + otherPlayer.getChoice());
        System.out.println("Winner: " + winner.map(w -> w.getName()).orElse("TIE"));
        System.out.println();
    }

    // Check one player's choice against other player's choice
    // if one wins,
    // then increment number of wins for that player
    // the winner is an Optional because if it's a tie, winner is set to null.
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


}
