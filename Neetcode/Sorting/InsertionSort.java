package Sorting;

import java.util.Arrays;

public class InsertionSort {
    
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 6};
        int[] result = insertionSort(arr);
        System.out.println(Arrays.toString(result));

    }

    // Time complexity worst case = O(n^2) (entire array is reverse)
    // Time complexity best case = O(n) (entire array is sorted)
    public static int[] insertionSort(int[] arr) {
        // [2, 3, 4, 1, 6]
        
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1; // set j one index before i for comparison
            // j >= 0 so we don't run into index out of bounds
            while (j >= 0 && arr[j+1] < arr[j]) { // 1 is less than 3 .. ascending order. For descending, arr[j + 1] > arr[j]
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        return arr;
    }

}
