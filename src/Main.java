import Player.Player;
import Player.HumanPlayer;

public class Main {
    public static void main(String[] args) {
        Player humanPlayer = new HumanPlayer();
        int guess = humanPlayer.makeGuess(0);
        System.out.println(guess);
    }
}
