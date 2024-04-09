package test;

import Player.ComputerPlayer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

    @Test
    @DisplayName("Generate number should be in range of 1 to 9")
    void isComputerGuessInRange() {
        ComputerPlayer computerPlayer = new ComputerPlayer();
        int guess = computerPlayer.makeGuess();
        boolean isInRange = guess > 0 && guess < 10;
        assertTrue(isInRange);
    }

    @Test
    @DisplayName("Generated number should be add to computer guesses")
    void isGuessAddedToComputerGuesses() {
        ComputerPlayer computerPlayer = new ComputerPlayer();
        int guess = computerPlayer.makeGuess();
        boolean isGuessAdded = computerPlayer.getGuesses().getFirst().equals(guess);
        assertTrue(isGuessAdded);
    }

}