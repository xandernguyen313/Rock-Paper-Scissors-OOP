public interface GameController {
    public void welcome();
    public void displayMainMenu();
    public void selectMainMenuChoice();
    public void displayResult(Player player, Player otherPlayer);
    public void checkForWinner(Player player, Player otherPlayer, Score history);
}
