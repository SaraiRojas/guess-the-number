package Player;

import java.util.Random;

public class ComputerPlayer extends Player{

    private static final Random random = new Random();

    public ComputerPlayer() {
        setName("Computer");
    }

    @Override
    public int makeGuess() {
        System.out.println(" _________Computer's turn__________");
        int guess = random.nextInt(1, 10);
        System.out.println("The computer guess is number " + guess);
        return guess;
    }
}
