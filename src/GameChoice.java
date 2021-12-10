public enum GameChoice {
    ROCK, PAPER, SCISSORS;

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
