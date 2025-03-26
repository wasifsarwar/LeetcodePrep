package Sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 6, 8, 5, 3};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * Pick a Pivot:
     * Choose any number from your array (usually the last or first element)
     * Think of this as your "comparison number"
     * Partition:
     * Put all numbers smaller than the pivot to its left
     * Put all numbers larger than the pivot to its right
     * The pivot ends up in its final sorted position
 
     * Repeat:
     * Do the same thing for the left group of numbers
     * Do the same thing for the right group of numbers
     * Keep doing this until each group has 1 or 0 numbers
     */

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    /**
     * Key Points:
     * Average time complexity: O(n log n)
     * Worst case: O(n²) when array is already sorted or reverse sorted
     * It's called "Quick" Sort because it's usually very fast in practice
     * It sorts "in-place" (doesn't need much extra memory)
     * The choice of pivot can greatly affect performance
     * The main idea is "divide and conquer" - 
     * break the big problem into smaller ones by putting smaller elements on one side 
     * and larger elements on the other side of the pivot.
     */
}
