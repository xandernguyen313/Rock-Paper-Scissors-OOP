import java.util.Scanner;

// Inherits from Player abstract class
public class User extends Player {
    private static final Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }


    // Display 3 choices: Rock, paper, or scissors
    // Ask user for an integer input of 1,2,3
    @Override
    public void selectChoice() {
        System.out.println("==============");
        System.out.println("Select your choice(1,2,3): ");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
        System.out.println();
        int choice = validateInput();

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

}
