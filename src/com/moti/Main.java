package com.moti;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main program class
 * Implements the program entry point
 */
public class Main {

    /**
     * The program entry point. Start the game
     * and after every round ask the user for another
     * one until the user exit
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        while (true) {
            play();

            // Ask the user for another round
            System.out.print("Another round? ");

            String input = stdin.nextLine();
            if (!input.equalsIgnoreCase("yes")) {
                // User want to exit
                System.out.println("Good bye!");
                return;
            }
        }
    }

    /**
     * The class represent game round.
     * Initialize bullseye object and ask
     * the user for guesses, until the guess
     * is right.
     */
    public static void play() {
        ArrayList<BullsEyeResult> results = new ArrayList<>();
        Scanner stdin = new Scanner(System.in);
        BullsEye game = new BullsEye();
        String guess;

        do {
            // Get user guess
            System.out.print("Enter your guess: ");
            guess = stdin.nextLine();

            if (BullsEye.isValidGuess(guess)) {
                // Increase attempts count
                game.increaseAttemptsCount();

                // Get guess result
                BullsEyeResult result = game.getResult(guess);

                results.add(result);

                // Print all answers
                for (BullsEyeResult res : results) {
                    System.out.println(res);
                }
            } else {
                System.out.println("Error: Invalid guess");
            }
        } while (!game.isBullseye());

        System.out.printf("Bull's eye! You succeeded in %d attempts\n", game.getAttemptsCount());
    }
}
