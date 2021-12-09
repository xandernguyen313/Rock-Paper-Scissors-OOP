public class Main {
    public enum Choice  {
        ROCK, PAPER, SCISSORS;

        public boolean beats(Choice other)
        {
            switch (this)
            {
                case ROCK:
                    return other == SCISSORS;
                case PAPER:
                    return other == ROCK;
                case SCISSORS:
                    return other == PAPER;
            }

            return false;
        }
    }
    public static void main(String[] args) {
        Choice choice = Choice.PAPER;
        Choice otherChoice = Choice.ROCK;
        System.out.println(choice.beats(otherChoice));

    }
}
