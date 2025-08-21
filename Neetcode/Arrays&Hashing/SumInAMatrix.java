import java.util.Arrays;
import java.util.*;

/**
 * You are given a 0-indexed 2D integer array nums. Initially, your score is 0.
 * Perform the following operations until the matrix becomes empty:
 * From each row in the matrix, select the largest number and remove it. In the
 * case of a tie, it does not matter which number is chosen.
 * Identify the highest number amongst all those removed in step 1. Add that
 * number to your score.
 * Return the final score.
 */

public class SumInAMatrix {

    public static void main(String[] args) {

    }

    public static int sumInMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        int res = 0;
        // After sorting each row, the largest elements are at the rightmost positions
        // We need to iterate through columns from right to left (largest to smallest)
        // In each iteration, we find the maximum among the largest remaining elements
        // from each row

        // iterate per column
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            // iterate per row
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            res += max;
        }
        return res;
    }

    public static int sumMatrixHeap(int[][] grid) {
        List<PriorityQueue<Integer>> queueList = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(
                    (a, b) -> Integer.compare(b, a));
            for (int j = 0; j < grid[0].length; j++) {
                queue.offer(grid[i][j]);
            }
            queueList.add(i, queue);
        }

        int sum = 0;
        while (!queueList.get(0).isEmpty()) {
            int max = 0;
            for (int i = 0; i < queueList.size(); i++) {
                max = Math.max(max, queueList.get(i).poll());
            }
            sum += max;
        }
        return sum;
    }

    /**
     * SAME IDEA FOR THIS PROBLEM
     * 
     * Delete Greatest Value in Each Row
     * 
     * You are given an m x n matrix grid consisting of positive integers.
     * 
     * Perform the following operation until grid becomes empty:
     * 
     * Delete the element with the greatest value from each row. If multiple such
     * elements exist, delete any of them.
     * Add the maximum of deleted elements to the answer.
     * 
     * Note that the number of columns decreases by one after each operation.
     * 
     * Return the answer after performing the operations described above.
     */

    public static int deleteGreatestValue(int[][] grid) {
        // sort each row in ascending order
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }

        // we calculate the totalSum by finding the max value per column
        int total = 0;
        // we look at per column
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            // for each column, we go top to bottom so we look through each row
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            total += max;
        }
        return total;
    }
}
