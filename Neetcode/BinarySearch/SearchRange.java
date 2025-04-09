package BinarySearch;

public class SearchRange {

    public static void main(String[] args) {
        // Test case 1: Search in range 0-20 (should find 10)
        int result1 = binarySearchValue(0, 20);
        System.out.println("Searching in range 0-20: Found value " + result1); // Expected: 10

        // Test case 2: Search in range 0-5 (should not find 10)
        int result2 = binarySearchValue(0, 5);
        System.out.println("Searching in range 0-5: Found value " + result2); // Expected: -1

        // Test case 3: Search in range 15-25 (should not find 10)
        int result3 = binarySearchValue(15, 25);
        System.out.println("Searching in range 15-25: Found value " + result3); // Expected: -1
    }

    /**
     * Binary Search implementation that uses a comparison function to find a target
     * value
     * 
     * @param low:  starting index of search range
     * @param high: ending index of search range
     * @return the value that satisfies the condition (where isCorrect returns 0),
     *         or -1 if not found
     * 
     *         Time Complexity: O(log n) - divides search space in half each
     *         iteration
     *         Space Complexity: O(1) - uses only constant extra space
     */
    public static int binarySearchValue(int low, int high) {
        // Continue searching while there are elements to check
        while (low <= high) {
            // Calculate middle point, using (low + high)/2 can cause overflow
            int mid = (low + (high - low)) / 2;

            // Use comparison function to determine search direction
            int comparison = isCorrect(mid);

            if (comparison > 0) {
                // Value is too high, search in left half
                high = mid - 1;
            } else if (comparison < 0) {
                // Value is too low, search in right half
                low = mid + 1;
            } else {
                // Found the correct value
                return mid;
            }
        }

        // No value found that satisfies the condition
        return -1;
    }

    /**
     * Comparison function that determines if a number is too high, too low, or
     * correct
     * 
     * @param n: number to compare
     * @return 1 if n is too high, -1 if n is too low, 0 if n is correct
     */
    public static int isCorrect(int n) {
        if (n > 10) {
            return 1; // Number is too high
        } else if (n < 10) {
            return -1; // Number is too low
        } else {
            return 0; // Number is correct
        }
    }
}
