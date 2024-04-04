package Player;
import java.util.Arrays;
import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner guess = new Scanner(System.in);

    @Override
    public int makeGuess(){
        System.out.println("What is your guess?");
        int number = guess.nextInt();
        guesses.add(number);
//        System.out.println(this.getGuesses());
        return number;
    }
}
