
/**
 * Distinct Combinations Problem
 * 
 * Description:
 * Implement a function to select three workers for a construction project
 * according to specific criteria:
 * 
 * • Workers and their capacities are represented as an array of integers.
 * • You must select a triplet (3 workers) from the capacity array.
 * • At least 2 of the selected workers must be adjacent in the array.
 * • The product of the capacities of the selected workers must equal a
 * specified capacity, desiredCapacity.
 * 
 * Return the number of ways to pick distinct triplets. Two triplets are
 * distinct if the index of at least
 * one chosen worker differs in the two triplets.
 * 
 * Example:
 * For n = 5 workers with capacity levels of capacity = [1, 3, 5, 3, 5]. The
 * desiredCapacity = 15.
 * The following 4 triplets satisfy the conditions. The array uses 0-based
 * indexing.
 * 
 * i) 1, 3, 5 -> capacity[0], capacity[1], capacity[2]
 * ii) 1, 3, 5 -> capacity[0], capacity[1], capacity[4]
 * iii) 1, 5, 3 -> capacity[0], capacity[2], capacity[3]
 * iv) 1, 3, 5 -> capacity[0], capacity[3], capacity[4]
 * 
 * There are four distinct triplets, so return 4.
 * 
 * Function Description:
 * Complete the function totalTriplets with the following parameter(s):
 * • int capacity[n]: the capacity of each worker
 * • int desiredCapacity: the desiredCapacity per triplet
 * 
 * Returns:
 * int: the number of distinct triplets that can be formed
 * 
 * Constraints:
 * • 3 ≤ n ≤ 10^5
 * • -10^5 ≤ capacity[i] ≤ 10^5
 * • -10^10 ≤ desiredCapacity ≤ 10^10
 * 
 * Sample Input:
 * 5
 * 1
 * 2
 * 2
 * 2
 * 4
 * 8
 * 
 * Sample Output:
 * 3
 * 
 * Explanation:
 * The following triplets satisfy the conditions:
 * i) 1,2,4 -> capacity[0], capacity[1], capacity[4]
 * ii) 2,2,2 -> capacity[1], capacity[2], capacity[3]
 * iii) 1,2,4 -> capacity[0], capacity[3], capacity[4]
 */

import java.util.*;

public class WalmartHackerRank {

    /**
     * Function to count distinct triplets that satisfy the given conditions
     * Optimized O(n^2) solution using HashMap
     * 
     * @param capacity        list of worker capacities
     * @param desiredCapacity target product for the triplet
     * @return number of distinct triplets
     */
    public static long totalTriplets(List<Integer> capacity, long desiredCapacity) {
        int n = capacity.size();
        long count = 0;

        // Use HashMap to store value -> list of indices mapping
        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();

        // Build the HashMap
        for (int i = 0; i < n; i++) {
            valueToIndices.computeIfAbsent(capacity.get(i), k -> new ArrayList<>()).add(i);
        }

        // Case 1: Adjacent pairs (i, i+1) + third element k
        for (int i = 0; i < n - 1; i++) {
            long product = (long) capacity.get(i) * capacity.get(i + 1);

            if (product == 0) {
                if (desiredCapacity == 0) {
                    // Any third element works when product is 0 and desired is 0
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != i + 1) {
                            count++;
                        }
                    }
                }
            } else if (desiredCapacity % product == 0) {
                int target = (int) (desiredCapacity / product);

                if (valueToIndices.containsKey(target)) {
                    for (int k : valueToIndices.get(target)) {
                        // k can be anywhere except the adjacent pair positions
                        if (k != i && k != i + 1) {
                            count++;
                        }
                    }
                }
            }
        }

        // Case 2: Adjacent pairs (j, j+1) where i < j and j+1 is the last element
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                // Triplet: (i, j, j+1) where j and j+1 are adjacent
                long product = (long) capacity.get(i) * capacity.get(j) * capacity.get(j + 1);
                if (product == desiredCapacity) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Alternative O(n^2) implementation with clearer logic
     * This version is more readable and handles edge cases better
     */
    public static long totalTripletsOptimized(List<Integer> capacity, long desiredCapacity) {
        int n = capacity.size();
        long count = 0;
        Map<Integer, List<Integer>> valueMap = new HashMap<>();

        // Build value to indices mapping
        for (int i = 0; i < n; i++) {
            valueMap.computeIfAbsent(capacity.get(i), k -> new ArrayList<>()).add(i);
        }

        // Case 1: Adjacent pairs (i, i+1) + third element
        for (int i = 0; i < n - 1; i++) {
            long product = (long) capacity.get(i) * capacity.get(i + 1);

            if (product != 0 && desiredCapacity % product == 0) {
                int target = (int) (desiredCapacity / product);

                if (valueMap.containsKey(target)) {
                    for (int k : valueMap.get(target)) {
                        // k can be before i or after i+1
                        if (k < i || k > i + 1) {
                            count++;
                        }
                    }
                }
            } else if (product == 0 && desiredCapacity == 0) {
                // Special case: product is 0 and desired is 0
                for (int k = 0; k < n; k++) {
                    if (k < i || k > i + 1) {
                        count++;
                    }
                }
            }
        }

        // Case 2: Adjacent pairs (j, j+1) where j is the middle element
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                // Check triplet (i, j, j+1) where j and j+1 are adjacent
                long product = (long) capacity.get(i) * capacity.get(j) * capacity.get(j + 1);
                if (product == desiredCapacity) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Test with the given example
        List<Integer> capacity1 = Arrays.asList(1, 3, 5, 3, 5);
        long desiredCapacity1 = 15;
        System.out.println("Example 1 Result: " + totalTriplets(capacity1, desiredCapacity1)); // Expected: 4

        // Test with sample input
        List<Integer> capacity2 = Arrays.asList(1, 2, 2, 2, 4);
        long desiredCapacity2 = 8;
        System.out.println("Sample Input Result: " + totalTriplets(capacity2, desiredCapacity2)); // Expected: 3

        // Test with optimized version
        System.out.println("Optimized Example 1 Result: " + totalTripletsOptimized(capacity1, desiredCapacity1)); // Expected:
                                                                                                                  // 4
        System.out.println("Optimized Sample Input Result: " + totalTripletsOptimized(capacity2, desiredCapacity2)); // Expected:
                                                                                                                     // 3
    }
}
