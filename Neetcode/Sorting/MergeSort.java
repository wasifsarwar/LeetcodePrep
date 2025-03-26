package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 12, 1, 3};
        arr = mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] mergeSort(int[] arr, int start, int end) {
        if (start < end) {  // array, starting index of array, last index of array
            int middle = (start + end)/2;
            mergeSort(arr, start, middle); // sort left half
            mergeSort(arr, middle + 1, end); // sort right half
            merge(arr, start, middle, end);
        }
        return arr;
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[start - > middle]
    // Second subarray is arr[middle + 1 -> end]
    public static void merge(int[] arr, int start, int middle, int end) {
        // Find lengths of two subarrays to be merged
        int leftLength = middle - start + 1;
        int rightLength = end - middle;

        //Create temporary arrays
        int left[] = new int[leftLength];
        int right[] = new int[rightLength];


        //copy the sorted left and right halfs to temp arrays
        for (int i = 0; i < leftLength; i++) {
            left[i] = arr[start + i];
        }

        for (int i = 0 ; i < rightLength; i++) {
            right[i] = arr[middle + 1 + i];
        }

        // initial indexes of left and right sub-arrays
        int i = 0; //index for left
        int j = 0; // index for right
        int k = start; // index for merged subarray array

        // merge the two sorted halves into the original array
        while (i < leftLength && j < rightLength) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // copy remaining elements of left[] array
         while (i < leftLength){   
            arr[k] = left[i];
            i++;
            k++;
        }

        // copy remaining elements of right array
        while (j < rightLength) {
            arr[k] = right[j];
            j++;
            k++;
        }

    }
}
