import java.util.*;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
    }

    /**
     * Finds the length of the longest consecutive elements sequence in an unsorted
     * array.
     * A consecutive sequence is a sequence of integers where each value is one more
     * than the previous value.
     * 
     * @param nums An array of integers
     * @return The length of the longest consecutive elements sequence
     * 
     *         Example:
     *         Input: [100, 4, 200, 1, 3, 2]
     *         Output: 4 (the consecutive sequence is [1, 2, 3, 4])
     * 
     *         Time Complexity: O(n) where n is the length of the array
     *         Space Complexity: O(n) for storing elements in the HashSet
     */
    public static int longestConsecutive(int[] nums) {
        // Handle empty array case
        if (nums.length == 0) {
            return 0;
        }

        // Create a HashSet to store all numbers for O(1) lookups
        Set<Integer> set = new HashSet<>();

        // Add all numbers from the array to the HashSet
        // This allows us to check if a number exists in O(1) time
        for (int n : nums) {
            set.add(n);
        }

        // Variable to track the longest consecutive sequence found
        int longestSequence = 0;

        // Iterate through each number in the SET instead of the array
        // This avoids processing duplicate numbers multiple times
        for (int n : set) {
            // Only consider numbers that are the start of a sequence.
            // Start of a sequence if n - 1 doesn't exist in the set
            // If n-1 exists in the set, then n is not the start of a sequence
            if (!set.contains(n - 1)) {
                // Initialize current number and length counter
                int currentNum = n;
                int length = 1;

                // Count consecutive numbers starting from n
                // Keep checking if the next number exists in the set
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                // Update the longest sequence if the current one is longer
                longestSequence = Math.max(longestSequence, length);
            }
        }

        // Return the length of the longest consecutive sequence found
        return longestSequence;
    }
}
