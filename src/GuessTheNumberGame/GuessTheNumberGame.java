package GuessTheNumberGame;

import java.util.Objects;
import java.util.Random;
import Player.Player;
import Player.HumanPlayer;
import Player.ComputerPlayer;

public class GuessTheNumberGame {
    private static final Random random = new Random();
    private static int targetNumber;

    public static void main(String[] args) {

        Player humanPlayer = new HumanPlayer();
        Player computerPlayer = new ComputerPlayer();
        boolean doesPlayerGuess;
        boolean isHumanPlayerTurn = true;

        generateRandomNumber();

        do {
            if(isHumanPlayerTurn){
                doesPlayerGuess = checkGuess(humanPlayer);
            }else{
                doesPlayerGuess = checkGuess(computerPlayer);
            }

            isHumanPlayerTurn = !isHumanPlayerTurn;

        } while (!doesPlayerGuess);
    }

    private static void generateRandomNumber() {
        GuessTheNumberGame.targetNumber = random.nextInt(1, 10);
    }

    private static boolean checkGuess(Player player) {
        int playerGuess = player.makeGuess();
        boolean isGuessCorrect = playerGuess == targetNumber;

        if(!isGuessCorrect){
            boolean isPlayerGuessBiggerThanRandomNumber = playerGuess > targetNumber;
            String biggerOrSmaller = isPlayerGuessBiggerThanRandomNumber ? "bigger" : "smaller";
            boolean isComputerPlayer = Objects.equals(player.getName(), "Computer");
            String whichPlayer = isComputerPlayer ? player.getName() : "Your";
            String hintMessage =  whichPlayer + " guess is " + biggerOrSmaller + " than the target value";
            System.out.println(hintMessage);
        }else{
            System.out.println(player.getName() + " guessed correctly!!!");
        }

        return isGuessCorrect;
    }
}
