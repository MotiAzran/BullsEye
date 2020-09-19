package com.moti;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            play();

            // Ask user or another round
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
                // Get user guess output
                String user_answer = game.get_user_output(guess);

                answers.add(String.format("%s - %s", guess, user_answer));

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
