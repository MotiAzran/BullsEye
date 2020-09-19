package com.moti;

import java.util.Random;

public class BullsEye {
    private final String _number;
    private boolean _is_bullseye;
    private int _attempts;
    private static final int INDEX_NOT_FOUND = -1;
    private static final int NUMBER_LENGTH = 4;

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

    public String get_user_output(String guess) {
        ++_attempts;

        int hits_count = 0;
        int misses_count = 0;

        for (int i = 0; i < guess.length(); ++i) {
            if (_number.charAt(i) == guess.charAt(i)) {
                ++hits_count;
            } else if (INDEX_NOT_FOUND != _number.indexOf(guess.charAt(i))) {
                ++misses_count;
            }
        }

        _is_bullseye = NUMBER_LENGTH == hits_count;

        return String.format("Hits count: %d, Misses count: %d", hits_count, misses_count);
    }

    public boolean is_bullseye(String guess) {
        return _is_bullseye;
    }

    public int get_attempts_count() {
        return _attempts;
    }
}
