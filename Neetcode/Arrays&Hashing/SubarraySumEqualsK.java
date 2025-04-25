import java.util.*;
import java.util.HashMap;

public class SubarraySumEqualsK {
    /**
     * Given an array of integers nums and an integer k, return the total number of
     * subarrays whose sum equals to k.
     * 
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * 
     * Algorithm:
     * 1. We use a prefix sum approach with a HashMap to solve this efficiently
     * 2. The key insight is: if prefixSum[j] - prefixSum[i] = k, then the sum of
     * elements from index i+1 to j equals k
     * 
     * Time Complexity: O(n) - we traverse the array once
     * Space Complexity: O(n) - in worst case the HashMap stores n different prefix
     * sums
     * 
     * Example:
     * nums = [1,1,1], k = 2
     * 
     * iterations:
     * - start: res=0, curSum=0, map={0:1}
     * - num=1: curSum=1, diff=1-2=-1, res+=0, map={0:1, 1:1}
     * - num=1: curSum=2, diff=2-2=0, res+=1, map={0:1, 1:1, 2:1}
     * - num=1: curSum=3, diff=3-2=1, res+=1, map={0:1, 1:1, 2:1, 3:1}
     * - result: 2 subarrays with sum=2 ([1,1] at positions 0-1 and 1-2)
     */

    public static int subarraySumEqualsK(int[] nums, int k) {
        int res = 0, curSum = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);

        for (int num : nums) {
            curSum += num; // Calculate running sum
            int diff = curSum - k; // Check if we've seen a prefix sum that creates a subarray of sum k
            res += prefixSums.getOrDefault(diff, 0); // Add count of such prefix sums to result
            prefixSums.put(curSum, prefixSums.getOrDefault(curSum, 0) + 1); // Update prefix sum frequency
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };
        int k = 2;
        System.out.println(subarraySumEqualsK(nums, k)); // Should print 2
    }
}
