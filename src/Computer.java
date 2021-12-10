import java.util.Random;

public class Computer extends Player{
    private static final Random rand;
    private static final int NUMBER_OF_CHOICE = 3;

    static {
        rand = new Random();
    }

    @Override
    public void selectChoice() {
        int randomInt = rand.nextInt(NUMBER_OF_CHOICE);
        switch(randomInt) {
            case 0:
                setChoice(GameChoice.ROCK);
                break;
            case 1:
                setChoice(GameChoice.PAPER);
                break;
            case 2:
                setChoice(GameChoice.SCISSORS);
                break;
        }

    }
}
