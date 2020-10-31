/*
 * Moti Azran
 *
 * Guess result
 */

/**
 * The class represent the result
 * of an user guess
 */
public class BullsEyeResult {
    private final String _guess;
    private final int _hitsCount;
    private final int _missesCount;

    /**
     * The class constructor, initializes the class members
     * @param guess the user guess
     * @param hitsCount the number of hits of the guess
     * @param missesCount the number of misses of the guess
     */
    public BullsEyeResult(String guess, int hitsCount, int missesCount) {
        _guess = guess;
        _hitsCount = hitsCount;
        _missesCount = missesCount;
    }

    /**
     * @return string representation of the class
     */
    public String toString() {
        return String.format("%s - Hits count: %d, Misses count: %d", _guess, _hitsCount, _missesCount);
    }
}
