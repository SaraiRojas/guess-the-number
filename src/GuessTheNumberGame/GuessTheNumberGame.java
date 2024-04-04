package GuessTheNumberGame;

import java.util.Random;
import Player.Player;
import Player.HumanPlayer;

public class GuessTheNumberGame {
    private static final Random random = new Random();
    private static int targetNumber;

    public static void main(String[] args) {

        Player playerTest = new HumanPlayer();
        boolean doesPlayerGuess;

        targetNumber = random.nextInt(1, 10);

        do {
            doesPlayerGuess = checkGuess(playerTest);
        } while (!doesPlayerGuess);
    }

    private static boolean checkGuess(Player player) {
        int playerGuess = player.makeGuess();

        if(!(playerGuess == targetNumber)){
            boolean isPlayerGuessBiggerThanRandomNumber = playerGuess > targetNumber;
            String biggerOrSmaller = isPlayerGuessBiggerThanRandomNumber ? "bigger" : "smaller";
            String hintMessage = "Your guess is " + biggerOrSmaller + " than the target value";
            System.out.println(hintMessage);
        }else{
            System.out.println("You guess correctly!!!");
        }

        return playerGuess == targetNumber;
    }
}
