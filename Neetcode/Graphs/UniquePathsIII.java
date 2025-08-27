/**
 * LeetCode 980 - Unique Paths III
 * 
 * Problem Description:
 * You are given an m x n integer array grid where grid[i][j] could be:
 * - 1 representing the starting square (exactly one starting square)
 * - 2 representing the ending square (exactly one ending square)
 * - 0 representing empty squares we can walk over
 * - -1 representing obstacles that we cannot walk over
 * 
 * Return the number of 4-directional walks from the starting square to the
 * ending square,
 * that walk over every non-obstacle square exactly once.
 * 
 * Example 1:
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * 
 * Example 2:
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * 
 * Example 3:
 * Input: grid = [[0,1],[2,0]]
 * Output: 0
 * 
 * Constraints:
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m, n <= 20
 * - 1 <= m * n <= 20
 * - -1 <= grid[i][j] <= 2
 * - There is exactly one starting cell and one ending cell.
 */

public class UniquePathsIII {

    /**
     * Solution using DFS with Backtracking
     * Time Complexity: O(4^(m*n)) in worst case
     * Space Complexity: O(m*n) for recursion stack and visited array
     */
    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Find starting position and count empty cells
        int startRow = 0, startCol = 0;
        int emptyCells = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                } else if (grid[i][j] == 0) {
                    emptyCells++;
                }
            }
        }

        // We need to visit all empty cells (0s) plus the starting cell (1)
        // The ending cell (2) will be visited but not counted in emptyCells
        return dfs(grid, startRow, startCol, emptyCells + 1);
    }

    /**
     * DFS helper function with backtracking
     * 
     * @param grid      the input grid
     * @param row       current row position
     * @param col       current column position
     * @param remaining number of cells remaining to visit
     * @return number of unique paths from current position
     */
    private int dfs(int[][] grid, int row, int col, int remaining) {
        // Base case: out of bounds or hitting an obstacle or visited cell
        if (row < 0 || row >= grid.length ||
                col < 0 || col >= grid[0].length ||
                grid[row][col] == -1) {
            return 0;
        }

        // If we reached the ending cell (2)
        if (grid[row][col] == 2) {
            // Valid path only if we've visited all required cells
            return remaining == 0 ? 1 : 0;
        }

        // Mark current cell as visited (temporarily mark as obstacle)
        int originalValue = grid[row][col];
        grid[row][col] = -1;

        // Explore all 4 directions
        int paths = 0;
        paths += dfs(grid, row + 1, col, remaining - 1); // Down
        paths += dfs(grid, row - 1, col, remaining - 1); // Up
        paths += dfs(grid, row, col + 1, remaining - 1); // Right
        paths += dfs(grid, row, col - 1, remaining - 1); // Left

        // Backtrack: restore original value
        grid[row][col] = originalValue;

        return paths;
    }

    /**
     * Alternative solution using explicit visited array
     * More memory but doesn't modify the original grid
     */
    public int uniquePathsIIIAlternative(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int startRow = 0, startCol = 0;
        int totalCells = 0;

        // Find start position and count walkable cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
                if (grid[i][j] != -1) {
                    totalCells++;
                }
            }
        }

        return dfsWithVisited(grid, visited, startRow, startCol, totalCells);
    }

    private int dfsWithVisited(int[][] grid, boolean[][] visited,
            int row, int col, int remaining) {
        // Base cases
        if (row < 0 || row >= grid.length ||
                col < 0 || col >= grid[0].length ||
                grid[row][col] == -1 || visited[row][col]) {
            return 0;
        }

        // Found the end
        if (grid[row][col] == 2) {
            return remaining == 1 ? 1 : 0;
        }

        // Mark as visited
        visited[row][col] = true;

        // Explore all directions
        int paths = 0;
        paths += dfsWithVisited(grid, visited, row + 1, col, remaining - 1);
        paths += dfsWithVisited(grid, visited, row - 1, col, remaining - 1);
        paths += dfsWithVisited(grid, visited, row, col + 1, remaining - 1);
        paths += dfsWithVisited(grid, visited, row, col - 1, remaining - 1);

        // Backtrack
        visited[row][col] = false;

        return paths;
    }

    public static void main(String[] args) {
        UniquePathsIII solution = new UniquePathsIII();

        // Test Case 1
        int[][] grid1 = {
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 2, -1 }
        };
        System.out.println("Test 1 Result: " + solution.uniquePathsIII(grid1)); // Expected: 2

        // Test Case 2
        int[][] grid2 = {
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 2 }
        };
        System.out.println("Test 2 Result: " + solution.uniquePathsIII(grid2)); // Expected: 4

        // Test Case 3
        int[][] grid3 = {
                { 0, 1 },
                { 2, 0 }
        };
        System.out.println("Test 3 Result: " + solution.uniquePathsIII(grid3)); // Expected: 0

        // Test with alternative method
        System.out.println("Test 1 Alternative: " + solution.uniquePathsIIIAlternative(grid1)); // Expected: 2
    }
}
