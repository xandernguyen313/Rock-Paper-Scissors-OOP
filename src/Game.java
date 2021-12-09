public class Game {
    public void startGame() {
        System.out.println("MAIN MENU");
        System.out.println("=========");
        System.out.println("1. Type 'computer' to play with a computer.");
        System.out.println("1. Type '2 players' to play with a friend.");
        System.out.println("2. Type 'quit' to exit.");
        System.out.println();
    }

    public void displayChoices() {
        System.out.println("Type 'rock', 'paper', or 'scissors' to play.");
        System.out.println("Type 'quit' to go back to the main menu.");
    }

    public void displayResult() {
        System.out.println("Computer picks: ");
        System.out.println("User picks: ");
        System.out.println("winner");
    }

    public String checkForWinner(Player player1, Player player2) {
//        String p1Choice = player1.getChoice();
//        String p2Choice = player2.getChoice();
//        if(p1Choice.equals(p2Choice)) {
//            return "tie";
//        }
//        if(p1Choice.equals("rock")) {
//            if(p2Choice.equals("paper")) {
//                return "player2";
//            }
//        }
        return "ds";
    }

}
