
import java.util.*;

public class SearchArray {

    public static void main(String[] args) {
        int[] arr = { 1, 9, 3, 12, 18, 19, 51 };
        int binaryResult = binarySearch(arr, 9);
        System.out.println("for " + Arrays.toString(arr) + " the indice for " + 9 + " is " + binaryResult);
    }

    /**
     * Binary Search Algorithm
     * 
     * @param arr:    sorted array to search
     * @param target: value to find
     * @return index of target if exists, -1 if not found
     * 
     *         Time Complexity: O(log n) - divides search space in half each
     *         iteration
     *         Space Complexity: O(1) - uses only constant extra space
     */
    public static int binarySearch(int[] arr, int target) {
        // Initialize pointers to start and end of array
        int left = 0;
        int right = arr.length - 1;

        // Continue searching while there are elements to check
        while (left <= right) {
            // Calculate middle point, using (left + right)/2 can cause overflow
            int middle = left + (right - left) / 2;

            if (target > arr[middle]) {
                // Target is in right half, move left pointer past middle
                left = middle + 1;
            } else if (target < arr[middle]) {
                // Target is in left half, move right pointer before middle
                right = middle - 1;
            } else {
                // Found target at middle index
                return middle;
            }
        }

        // Target not found in array
        return -1;
    }

}
