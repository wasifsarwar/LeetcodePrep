package MatrixProblems;

import java.util.*;

public class SpiralMatrix {

    /**
     * Easy and understandable approach using boundary pointers
     * 
     * Key idea: Use 4 boundaries (top, bottom, left, right) and shrink them
     * as we traverse each layer of the spiral
     * 
     * Time: O(m * n) - visit each element once
     * Space: O(1) - only using boundary variables (excluding result list)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        // Define boundaries
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // 1. Traverse RIGHT along the top row
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++; // Move top boundary down

            // 2. Traverse DOWN along the right column
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--; // Move right boundary left

            // 3. Traverse LEFT along the bottom row (if we still have rows)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--; // Move bottom boundary up
            }

            // 4. Traverse UP along the left column (if we still have columns)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++; // Move left boundary right
            }
        }

        return result;
    }

    // Test method to verify our solution
    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();

        // Test case 1: 3x3 matrix
        int[][] matrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("Test 1 - 3x3 matrix:");
        System.out.println("Input: " + Arrays.deepToString(matrix1));
        System.out.println("Output: " + solution.spiralOrder(matrix1));
        System.out.println("Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5]");
        System.out.println();

        // Test case 2: 3x4 matrix
        int[][] matrix2 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        System.out.println("Test 2 - 3x4 matrix:");
        System.out.println("Input: " + Arrays.deepToString(matrix2));
        System.out.println("Output: " + solution.spiralOrder(matrix2));
        System.out.println("Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]");
        System.out.println();

        // Test case 3: Single row
        int[][] matrix3 = { { 1, 2, 3, 4, 5 } };
        System.out.println("Test 3 - Single row:");
        System.out.println("Input: " + Arrays.deepToString(matrix3));
        System.out.println("Output: " + solution.spiralOrder(matrix3));
        System.out.println("Expected: [1, 2, 3, 4, 5]");
        System.out.println();

        // Test case 4: Single column
        int[][] matrix4 = { { 1 }, { 2 }, { 3 } };
        System.out.println("Test 4 - Single column:");
        System.out.println("Input: " + Arrays.deepToString(matrix4));
        System.out.println("Output: " + solution.spiralOrder(matrix4));
        System.out.println("Expected: [1, 2, 3]");
    }
}
