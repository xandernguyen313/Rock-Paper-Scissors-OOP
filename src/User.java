import java.util.Scanner;

public class User extends Player {
    private static final Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }


    @Override
    public void selectChoice() {
        System.out.println("==============");
        System.out.println("Select your choice(1,2,3): ");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
        System.out.println();
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                setChoice(GameChoice.ROCK);
                break;
            case 2:
                setChoice(GameChoice.PAPER);
                break;
            case 3:
                setChoice(GameChoice.SCISSORS);
                break;
            default:
                System.out.println("Invalid Choice!");
                selectChoice();
        }
    }

}
