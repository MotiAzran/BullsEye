/*
 * Moti Azran
 *
 * The main game class
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * The class represent the bulls eye game
 * In this game the user try to guess what
 * is the 4-digits number the program generated.
 *
 * To start or reset a game, you must call startNewGame method.
 *
 * @author Moti Azran
 */
public class BullsEye {
    /*
     * The class generate 4-digits number and then
     * waits for the user to enter guess then it send
     * the user the result of the guess, if the guess
     * is correct than the class set the game as bulls eye
     */

    private static final int NUMBER_LENGTH = 4;
    private String _number;
    private boolean _isBullseye;
    private int _attempts;

    /**
     * Reset all game stats
     */
    public void startNewGame() {
        _number = _generateRandomNumber();
        _attempts = 0;
        _isBullseye = false;
    }

    /**
     * Checks if the guess is valid.
     * Valid guess is an 4-digits string
     * @param guess The user guess
     * @return true if the guess valid, otherwise false
     */
    private boolean _isValidGuess(String guess) {
        if (null == guess) {
            return false;
        }

        return guess.length() == NUMBER_LENGTH && guess.chars().allMatch(Character::isDigit);
    }

    /**
     * Generates a random 4-digits number
     *
     * @return string that represents the generated number
     */
    private String _generateRandomNumber() {
        ArrayList<Character> digits = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

        Random rand = new Random();

        String number = "";
        for (int i = 0; NUMBER_LENGTH > i; ++i) {
            // Generate random digit
            int index = rand.nextInt(digits.size());

            // Add digit to string number
            number = number.concat(Character.toString(digits.get(index)));

            // Remove the chosen digit to prevent digits duplication
            digits.remove(index);
        }

        return number;
    }

    /**
     * Return's the guess result, how many hits and
     * misses occurred
     *
     * @param guess The user guess
     * @return The result of the guess
     */
    public BullsEyeResult getResult(String guess) {
        if (!_isValidGuess(guess)) {
            return null;
        }

        int hitsCount = 0;
        int missesCount = 0;

        for (int i = 0; i < guess.length(); ++i) {
            if (_number.charAt(i) == guess.charAt(i)) {
                // The guess current digit and the number current digit are the same
                ++hitsCount;
            } else if (0 <= _number.indexOf(guess.charAt(i))) {
                // The guess current digit found in the number
                ++missesCount;
            }
        }

        _isBullseye = (guess.length() == hitsCount);

        return new BullsEyeResult(guess, hitsCount, missesCount);
    }

    /**
     * @return true if the last guess was bulls eye, otherwise false
     */
    public boolean isBullseye() {
        return _isBullseye;
    }

    /**
     * @return number of attempts in the round
     */
    public int getAttemptsCount() {
        return _attempts;
    }

    /**
     * Increases the attempts count
     */
    public void increaseAttemptsCount() {
        ++_attempts;
    }
}
