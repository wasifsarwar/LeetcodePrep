
/**
 * Solution for searching a target value in a sorted 2D matrix.
 * The matrix has the following properties:
 * - Each row is sorted in ascending order from left to right
 * - The first element of each row is greater than the last element of the
 * previous row
 * 
 * The algorithm uses a two-phase binary search approach:
 * 1. First binary search to find the correct row
 * 2. Second binary search to find the target within that row
 * 
 * Time Complexity: O(log(m) + log(n)) where m is number of rows and n is number
 * of columns
 * Space Complexity: O(1) - constant extra space
 */
public class SearchMatrix {

    /**
     * Searches for a target value in a sorted matrix.
     * 
     * @param matrix The sorted 2D matrix to search in
     * @param target The value to search for
     * @return true if target is found, false otherwise
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        // PHASE 1: Binary search to find which row might contain the target
        int top = 0; // Start with the first row
        int bottom = rowLength - 1; // End with the last row

        while (top <= bottom) {
            int midRow = top + (bottom - top) / 2; // Calculate middle row safely to avoid overflow

            // If target is greater than the largest element in this row,
            // it must be in a row below the current middle row
            if (target > matrix[midRow][columnLength - 1]) {
                top = midRow + 1; // Search in the bottom half
            }
            // If target is less than the smallest element in this row,
            // it must be in a row above the current middle row
            else if (target < matrix[midRow][0]) {
                bottom = midRow - 1; // Search in the top half
            }
            // Target is within range of this row, so we break out of the loop
            // and will search within this row in phase 2
            else {
                break;
            }
        }

        // If top > bottom, we didn't find a suitable row, so target doesn't exist
        if (!(top <= bottom)) {
            return false;
        }

        // PHASE 2: Binary search within the identified row
        int row = (top + bottom) / 2; // The row that might contain our target
        int left = 0; // Start with the first column
        int right = columnLength - 1; // End with the last column

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate middle column safely

            // If target is greater than the middle element,
            // search in the right half of the row
            if (target > matrix[row][mid]) {
                left = mid + 1;
            }
            // If target is less than the middle element,
            // search in the left half of the row
            else if (target < matrix[row][mid]) {
                right = mid - 1;
            }
            // Found the target!
            else {
                return true;
            }
        }

        // If we reach here, we've searched the entire row and didn't find the target
        return false;
    }
}
