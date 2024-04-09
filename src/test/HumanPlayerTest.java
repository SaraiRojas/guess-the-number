package test;

import Player.HumanPlayer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HumanPlayerTest {

    private InputStream originalSystemIn;

    @BeforeEach
    void setUp() {
        originalSystemIn = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    @DisplayName("The player's name is save correctly")
    void isPlayerNameSavedCorrectly(){

        String playerName = "Luisa";
        ByteArrayInputStream in = new ByteArrayInputStream(playerName.getBytes());
        System.setIn(in);

        HumanPlayer humanPlayer = new HumanPlayer();
        String name = humanPlayer.getName();
        assertEquals(playerName, name);
    }


    @Test
    @DisplayName("The player's guess is returned correctly")
    void isPlayerGuessReturnedCorrectly(){

        // Add more than one input https://stackoverflow.com/questions/23653875/how-to-simulate-multiple-user-input-for-junit
        String playerInput = "Luisa" + System.lineSeparator() + "8";
        ByteArrayInputStream in = new ByteArrayInputStream(playerInput.getBytes());
        System.setIn(in);

        HumanPlayer humanPlayer = new HumanPlayer();
        int guess = humanPlayer.makeGuess();
        assertEquals(8, guess);
    }

    @Test
    @DisplayName("The player's guess is saved correctly")
    void isPlayerGuessSavedCorrectly(){

        String playerInput = "Luisa" + System.lineSeparator() + "8";
        ByteArrayInputStream in = new ByteArrayInputStream(playerInput.getBytes());
        System.setIn(in);

        HumanPlayer humanPlayer = new HumanPlayer();
        humanPlayer.makeGuess();
        int guess = humanPlayer.getGuesses().getFirst();

        assertEquals(8, guess);
    }

    @Test
    @DisplayName("The player's guess should be a number")
    void isPlayerGuessANumber(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String playerInput = "Luisa" + System.lineSeparator() + "p" + System.lineSeparator() + "6";
        ByteArrayInputStream in = new ByteArrayInputStream(playerInput.getBytes());
        System.setIn(in);

        HumanPlayer humanPlayer = new HumanPlayer();
        humanPlayer.makeGuess();
        boolean hasMessage = outContent.toString().contains("Please enter a number.");
        assertTrue(hasMessage);
    }
}