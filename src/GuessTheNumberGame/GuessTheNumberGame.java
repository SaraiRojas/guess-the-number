package GuessTheNumberGame;

import java.util.Objects;
import java.util.Random;
import Player.Player;
import Player.HumanPlayer;
import Player.ComputerPlayer;

public class GuessTheNumberGame {
    private static final Random random = new Random();
    private static int targetNumber;

    private static String winner;

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

        statistics(computerPlayer, humanPlayer);
    }

    private static void generateRandomNumber() {
        GuessTheNumberGame.targetNumber = random.nextInt(1, 10);
    }

    public static void statistics(Player computerPlayer, Player humanPlayer){
        int humanNumberGuesses = humanPlayer.getGuesses().size();
        int computerNumberGuesses = computerPlayer.getGuesses().size();
        int size = Math.max(humanNumberGuesses, computerNumberGuesses);

        System.out.println("~The winner is " + GuessTheNumberGame.winner + "~");
        System.out.println("Number " + GuessTheNumberGame.targetNumber + " was the target");

        System.out.printf("%-10s | %-10s | %-10s\n", "Round", "Computer", humanPlayer.getName());
        for(int i=0; i < size; i++ ) {

            Object humanGuess = i < humanNumberGuesses ? humanPlayer.getGuesses().get(i) : "-";
            Object computerGuess = i < computerNumberGuesses ? computerPlayer.getGuesses().get(i) : "-";
            System.out.printf("%-10s | %-10s | %-10s\n", i+1 , computerGuess, humanGuess);
        }
    }

    private static boolean checkGuess(Player player) {
        int playerGuess = player.makeGuess();
        boolean isGuessCorrect = playerGuess == targetNumber;

        if(!isGuessCorrect){
            boolean isPlayerGuessBiggerThanRandomNumber = playerGuess > targetNumber;
            String biggerOrSmaller = isPlayerGuessBiggerThanRandomNumber ? "bigger" : "smaller";
            boolean isComputerPlayer = Objects.equals(player.getName(), "Computer");
            String whichPlayer = isComputerPlayer ? player.getName() : "Your";
            String hintMessage =  whichPlayer + " guess is " + biggerOrSmaller + " than the target value\n";
            System.out.println(hintMessage);
        }else{
            GuessTheNumberGame.winner = player.getName();
            System.out.println(player.getName() + " guessed correctly!!!\n");
        }

        return isGuessCorrect;
    }
}
