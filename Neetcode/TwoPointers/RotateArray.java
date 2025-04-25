package TwoPointers;

public class RotateArray {

/**
 * Rotate Array
 * 
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3     
 * Output: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * 
 * The reason why we need to take modulo is because if k is greater than the length of the array, we need to rotate the array more than once.
 * For example, if k = 10, we need to rotate the array 2 times (10 % 7 = 3).    
 * 
 * The reason why we need to reverse the array is because we want to rotate the array to the right by k steps, which is equivalent to reversing the array k times.
 * For example, if k = 3, we need to reverse the array 3 times.
 * 
 * The reason why we need to reverse the array is because we want to rotate the array to the right by k steps, which is equivalent to reversing the array k times.
 * 
 */


    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public void rotate(int[] nums, int k) {
        // Get array length
        int n = nums.length;
        
        // Handle case where k > n by taking modulo
        k = k % n;
        
        // To rotate right by k:
        // 1. Reverse entire array
        reverse(nums, 0, n - 1);
        // 2. Reverse first k elements 
        reverse(nums, 0, k - 1);
        // 3. Reverse remaining elements
        reverse(nums, k, n - 1);
        
        // Example for k=3:
        // Original:     [1,2,3,4,5,6,7]
        // Full reverse: [7,6,5,4,3,2,1]
        // Reverse k:    [5,6,7,4,3,2,1]
        // Reverse rest: [5,6,7,1,2,3,4]
    }   

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotateLeft(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // in case k is out of bounds

          // Step 1: Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Step 2: Reverse the remaining elements
        reverse(nums, k, n - 1);
        // Step 3: Reverse the entire array
        reverse(nums, 0, n - 1);
  }
}
