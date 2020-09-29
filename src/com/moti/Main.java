package com.moti;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            play();

            // Ask the user for another round
            System.out.print("Another round? ");
            Scanner stdin = new Scanner(System.in);
            String input = stdin.nextLine();

            if (!input.equalsIgnoreCase("yes")) {
                // User want to exit
                System.out.println("Good bye!");
                break;
            }
        }
    }

    public static void play() {
        ArrayList<String> answers = new ArrayList<>();
        Scanner stdin = new Scanner(System.in);
        BullsEye game = new BullsEye();
        String guess;

        do {
            // Get user guess
            System.out.print("Enter your guess: ");
            guess = stdin.nextLine();

            if (BullsEye.is_valid_guess(guess)) {
                // Increase attempts count
                game.increase_attempts_count();

                // Get hits and misses count
                int hits_count = game.get_hits_count(guess);
                int misses_count = game.get_misses_count(guess);

                // Check if the guess was bulls eye
                game.set_is_bullseye(guess.length() == hits_count);

                answers.add(String.format("%s - Hits count: %d, Misses count: %d", guess, hits_count, misses_count));

                // Print all answers
                for (String answer : answers) {
                    System.out.println(answer);
                }
            } else {
                System.out.println("Error: Invalid guess");
            }
        } while (!game.is_bullseye(guess));

        System.out.printf("Bull's eye! You succeeded in %d attempts\n", game.get_attempts_count());
    }
}
