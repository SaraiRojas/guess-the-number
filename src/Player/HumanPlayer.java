package Player;
import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner scanner = new Scanner(System.in);

    public HumanPlayer() {
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        setName(name);
    }

    @Override
    public int makeGuess(){
        System.out.println(getName() + " what is your guess?");
        int guess = scanner.nextInt();
        guesses.add(guess);
        return guess;
    }
}
