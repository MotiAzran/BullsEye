import javax.swing.*;
import java.util.ArrayList;

/**
 * The main program class
 * Implements the program entry point
 */
public class Main {

    static private BullsEye game;
    static private ArrayList<BullsEyeResult> results;

    /**
     * The program entry point. Start the game
     * and after every round ask the user for another
     * one until the user exit
     * @param args command line arguments
     */
    public static void main(String[] args) {
        game = new BullsEye();
        results = new ArrayList<>();

        while (true) {
            play();

            // Ask the user for another round
            int selectedOption = JOptionPane.showConfirmDialog(null, "Another round?",
                    "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (JOptionPane.OK_OPTION != selectedOption) {
                // User want to exit
                return;
            }

            game.resetGame();
            results.clear();
        }
    }

    /**
     * The class represent game round.
     * Initialize bullseye object and ask
     * the user for guesses, until the guess
     * is right.
     */
    public static void play() {
        String guess;

        do {
            String answers = "";
            for (BullsEyeResult res : results) {
                answers = answers.concat(res + "\n");
            }

            // Get user guess
            guess = JOptionPane.showInputDialog(answers + "Enter guess:");
            if (null == guess) {
                System.exit(0);
            }

            if (BullsEye.isValidGuess(guess)) {
                // Increase attempts count
                game.increaseAttemptsCount();

                // Get guess result
                BullsEyeResult result = game.getResult(guess);

                results.add(result);
            } else {
                JOptionPane.showMessageDialog(null, "Error: Invalid guess");
            }
        } while (!game.isBullseye());

        JOptionPane.showMessageDialog(null,
                String.format("Bull's eye! You succeeded in %d attempts\n", game.getAttemptsCount()));
    }
}
