import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class GuessingGame {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();
    private static ArrayList<Integer> SCORE_BOARD = scoreBoard;
    public GuessingGame() {
    }
    public static void main(String[] args) {
        final GuessingGame methodChange = new GuessingGame();
        methodChange.menu(SCORE_BOARD);
    }
    public void menu(ArrayList<Integer> scoreBoard) {
        GuessingGame methodChange = new GuessingGame();
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Welcome to the Gussing game");
        System.out.println("1) Play the Game");
        System.out.println("2) Score Board");
        System.out.println("3) Exit the game");
       
        System.out.println("--------------------");
        try {
            System.out.print("What would you perform ");
            int Option = input.nextInt();
            switch (Option) {
                case 1:
                    System.out.print("\n"+"choose your range ");
                    int RangeNumber = input.nextInt();
                    int rNumber = methodChange.rNumber(RangeNumber);
                    methodChange.guessNumber(rNumber);
                    break;
                case 2:
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"Thanks for playing the game!");
                    System.exit(1);
                    break;
                   
                 default:
                    throw new InputMismatchException("Invalid number entry. Try again later");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(scoreBoard);
        }
    }
    public int rNumber(int numberRange) {
        Random random = new Random();
        int rNumber = random.nextInt(numberRange) + 1;
        return rNumber;
    }
    public void guessNumber(int rNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Enter your guess number: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > rNumber) {
                System.out.println("Lower");
            } else if (userGuess < rNumber) {
                System.out.println("Higher");
            }
        } while (rNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You answered number is right in " + guess + " try!");
        } else {
            System.out.println("You answered number is right in " + guess + " tries!");
        }
        SCORE_BOARD.add(guess);
        System.out.println(" ");

        menu(SCORE_BOARD);
    }
    public <T> void displayScoreBoard() {
        System.out.println("--------------------");
        System.out.println("Score Board");
        System.out.println("--------------------");
        System.out.println("today  all tries is: " +"\n");
    }
       
    public static ArrayList<Integer> getScoreBoard() {
        return SCORE_BOARD;
    }
    public static void setScoreBoard(ArrayList<Integer> scoreBoard) {
        GuessingGame.SCORE_BOARD = scoreBoard;
    }
}
