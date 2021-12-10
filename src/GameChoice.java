 // Custom data type for player's choice.
public enum GameChoice {
    ROCK, PAPER, SCISSORS;

    // Winning conditions of the game
    // ROCK beats Scissors
    // Scissors beats Paper
    // Paper beats Rock
    public boolean beats(GameChoice other){
        switch(this)
        {
            case ROCK:
                return other == SCISSORS;
            case PAPER:
                return other == ROCK;
            case SCISSORS:
                return other == PAPER;
            default:
                return false;
        }

    }
}
