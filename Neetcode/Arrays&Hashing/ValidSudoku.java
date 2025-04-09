import java.util.*;
import java.util.HashSet;
import java.util.HashMap;

public class ValidSudoku {

    /**
     * Determines if a 9x9 Sudoku board is valid.
     * A valid Sudoku board must satisfy three rules:
     * 1. Each row must contain digits 1-9 without repetition
     * 2. Each column must contain digits 1-9 without repetition
     * 3. Each of the nine 3x3 sub-boxes must contain digits 1-9 without repetition
     *
     * @param board A 9x9 char array representing the Sudoku board
     * @return true if the board is valid, false otherwise
     */
    public static boolean isValidSudoku(char[][] board) {
        // Data structures to track digits in each row, column, and 3x3 square
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        // traverse through the board cell by cell
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                // skip empty cell if the value is '.'
                if (val == '.')
                    continue;

                /**
                 * Calculate the 3x3 square index (0-8) using the formula:
                 * (r / 3) + "," + (c / 3)
                 * This maps each cell to one of 9 squares:
                 * - r/3 gives the row group (0,1,2)
                 * - c/3 gives the column group (0,1,2)
                 * - Dividing row group by 3 and adding column group gives unique index
                 */
                String squareKey = (r / 3) + "," + (c / 3);

                /**
                 * computeIfAbsent retrieves the HashSet for row r, creating one if it doesn't
                 * exist
                 * .contains(val) checks if this value already exists in this row
                 */
                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(val) ||
                // checks if the value already exists in the current column
                        cols.computeIfAbsent(c, k -> new HashSet<>()).contains(val) ||
                        // Uses the formula to calculate which 3x3 square this cell belongs to
                        // Checks if the value already exists in that square
                        squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(val)) {
                    return false;
                }

                /**
                 * Retrieves the HashSet for row r from the rows map
                 * Adds the current digit (val) to that set
                 * This marks that we've seen this digit in this row
                 */
                rows.get(r).add(val);

                /**
                 * Retrieves the HashSet for column c from the cols map
                 * Adds the current digit to that set
                 * This marks that we've seen this digit in this column
                 */
                cols.get(c).add(val);

                /**
                 * retrieves the HashSet for the current 3x3 square
                 * The key is squareKey, which was defined as (r / 3) + "," + (c / 3)
                 * This marks that we've seen this digit in this particular 3x3 square
                 */
                squares.get(squareKey).add(val);
            }
        }
        return true;
    }
}
