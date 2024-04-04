package Player;
import java.util.Arrays;
import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner guess = new Scanner(System.in);

    @Override
    public int makeGuess(int turn){
        System.out.println("What is your guess?");
        int number = guess.nextInt();
        this.guesses[turn] = number;
        // System.out.println(Arrays.toString(this.getGuesses()));
        return number;
    }
}
