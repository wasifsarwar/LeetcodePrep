package Sorting;

import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 12, 1, 3 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int m = (l + r) / 2;

        // divide
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        // conquer
        merge(arr, l, m, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        ArrayList<Integer> temp = new ArrayList<>();
        int i = l; // pointer to left sub array
        int j = m + 1; // pointer to right sub array

        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
            }
        }

        /**
         * The first while loop ends when either:
         * We finish the first subarray (i > m) OR
         * We finish the second subarray (j > r)
         * But we might still have elements in the other subarray that haven't been
         * processed yet. This happens because:
         * The subarrays might be different lengths
         * One subarray might have larger elements than the other
         */

        /**
         * Without the cleanup while loops, we would lose any remaining elements in
         * either subarray. That's why we need both:
         */

        /**
         * Only one of these cleanup loops will actually execute in any given merge
         * operation, depending on which subarray still has elements remaining.
         */

        // If there are remaining elements in the first sub array (i <= m), add them to
        // temp
        while (i <= m) {
            temp.add(arr[i]);
            i++;
        }

        // If there are remaining elements in the second sub array (j <= r), add them to
        // temp
        while (j <= r) {
            temp.add(arr[j]);
            j++;
        }

        // copy the elements from temp to array
        for (i = l; i <= r; i++) {
            /**
             * i - l is the offset calculation
             * When i = l, i - l = 0, which accesses the first element of temp.
             * When i = r, i - l accesses the last element of temp.
             * 
             * Suppose l = 2, r = 5, and temp contains [1, 2, 3, 4]:
             * For i = 2, i - l = 0, so arr[2] = temp.get(0).
             * For i = 3, i - l = 1, so arr[3] = temp.get(1).
             * For i = 4, i - l = 2, so arr[4] = temp.get(2).
             * For i = 5, i - l = 3, so arr[5] = temp.get(3).
             */

            arr[i] = temp.get(i - l);
        }
    }

}
