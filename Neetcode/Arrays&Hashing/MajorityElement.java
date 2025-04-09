/**
 * Solution for the Majority Element problem.
 * 
 * The majority element is defined as the element that appears more than ⌊n/2⌋
 * times
 * in an array of size n. This implementation uses the Boyer-Moore Voting
 * Algorithm.
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums)); // Output: 2
        int[] nums2 = { 2, 3, 3, 3, 3, 4, 5, 5, 6, 7, 9, 9, 9, 9, 9, 9, 9, 10 };
        System.out.println(majorityElement(nums2)); // Output: 9
    }

    /**
     * Finds the majority element using the Boyer-Moore Voting Algorithm.
     * 
     * Time Complexity: O(n) - single pass through the array
     * Space Complexity: O(1) - only uses two variables regardless of input size
     * 
     * @param nums Array of integers containing a majority element
     * @return The majority element
     * 
     *         Example walkthrough with [2, 2, 1, 1, 1, 2, 2]:
     *         Initial: result = 0, count = 0
     * 
     *         Step 1: n = 2, count = 0 → Set result = 2, increment count to 1
     *         Step 2: n = 2, result = 2 → Increment count to 2
     *         Step 3: n = 1, result = 2 → Decrement count to 1
     *         Step 4: n = 1, result = 2 → Decrement count to 0
     *         Step 5: n = 1, count = 0 → Set result = 1, increment count to 1
     *         Step 6: n = 2, result = 1 → Decrement count to 0
     *         Step 7: n = 2, count = 0 → Set result = 2, increment count to 1
     * 
     *         Final result = 2, which is the majority element
     */
    public static int majorityElement(int[] nums) {
        // The potential majority element
        int result = 0;

        // Counter to track if the current element is in the lead
        int count = 0;

        // Boyer-Moore Voting Algorithm
        for (int n : nums) {
            // If count is 0, set the current element as the potential majority element
            // This happens at the start or when previous element's count is neutralized
            if (count == 0)
                result = n;

            // If current element is the same as our potential majority, increase its count
            // Otherwise, decrease the count (representing "voting against" the potential
            // majority)
            if (result == n) {
                count++;
            } else {
                count--;
            }

            /*
             * The algorithm works because:
             * 1. If there is a majority element (appears > n/2 times), it will always be
             * the final result
             * 2. Non-majority elements can at most cancel out an equal number of majority
             * elements
             * 3. Since the majority element has more occurrences than all others combined,
             * it will always have at least one "vote" left at the end
             */
        }
        return result;
    }
}
