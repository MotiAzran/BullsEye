package com.moti;

import java.util.Random;

public class BullsEye {
    private static final int NUMBER_LENGTH = 4;
    private final String _number;
    private boolean _is_bullseye;
    private int _attempts;

    public BullsEye() {
        _number = _generate_random_number();
        _attempts = 0;
        _is_bullseye = false;
    }

    public static boolean is_valid_guess(String guess) {
        return guess.length() == NUMBER_LENGTH && guess.chars().allMatch(Character::isDigit);
    }

    private String _generate_random_number() {
        Random rand = new Random();

        String number = "";
        for (int i = 0; NUMBER_LENGTH > i; ++i) {
            // Generate random digit
            int num = rand.nextInt(10);

            // Add digit to string number
            number = number.concat(Integer.toString(num));
        }

        return number;
    }

    public int get_hits_count(String guess) {
        int hits_count = 0;

        for (int i = 0; i < guess.length(); ++i) {
            // Check the digits at the i position are the same
            if (_number.charAt(i) == guess.charAt(i)) {
                ++hits_count;
            }
        }

        return hits_count;
    }

    public int get_misses_count(String guess) {
        int misses_count = 0;

        for (int i = 0; i < guess.length(); ++i) {
            // Check the current guess digit appears at the number in different index
            if (_number.charAt(i) != guess.charAt(i) &&
                    0 <= _number.indexOf(guess.charAt(i))) {
                ++misses_count;
            }
        }

        return misses_count;
    }

    public boolean is_bullseye(String guess) {
        return _is_bullseye;
    }

    public void set_is_bullseye(boolean is_bullseye) {
        _is_bullseye = is_bullseye;
    }

    public int get_attempts_count() {
        return _attempts;
    }

    public void increase_attempts_count() {
        ++_attempts;
    }
}
