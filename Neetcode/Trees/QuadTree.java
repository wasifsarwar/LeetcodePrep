package Trees;

/**
 * Definition for a QuadTree node.
 * A QuadTree is a tree data structure where:
 * 1. Each node has exactly four children or none (leaf)
 * 2. Each node represents a square section of a 2D space
 * 3. Leaf nodes contain true/false values
 * 4. Non-leaf nodes split their square into four equal quadrants
 */
class Node {
    public boolean val; // For leaf nodes: true = 1, false = 0
    public boolean isLeaf; // Indicates if this is a leaf node
    public Node topLeft; // Top-left quadrant
    public Node topRight; // Top-right quadrant
    public Node bottomLeft; // Bottom-left quadrant
    public Node bottomRight; // Bottom-right quadrant

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

class Solution {
    /**
     * Constructs a QuadTree from a 2D grid of 1s and 0s
     * 
     * @param grid The input grid where 1 represents true and 0 represents false
     * @return The root node of the constructed QuadTree
     */
    public Node construct(int[][] grid) {
        return dfs(grid, grid.length, 0, 0);
    }

    /**
     * Recursively constructs the QuadTree using depth-first search
     * 
     * @param grid The input grid
     * @param n    The size of the current square section (both width and height)
     * @param r    The starting row of the current section
     * @param c    The starting column of the current section
     * @return A node representing the current section of the grid
     */
    public Node dfs(int[][] grid, int n, int r, int c) {
        // Check if all values in the current section are the same
        boolean allSame = true;
        int val = grid[r][c]; // Get the first value to compare against

        // Iterate through all cells in the current section
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // If any value differs from the first value,
                // we can't make this a leaf node
                if (grid[r + i][c + j] != val) {
                    allSame = false;
                    break;
                }
            }
            if (!allSame)
                break;
        }

        // If all values are the same, we can create a leaf node
        if (allSame) {
            return new Node(val == 1, true); // val == 1 converts int to boolean
        }

        // If values are different, split into four quadrants
        int mid = n / 2; // Calculate size of sub-squares

        // Recursively construct each quadrant:
        // topLeft: starts at (r, c)
        Node topLeft = dfs(grid, mid, r, c);

        // topRight: starts at (r, c + mid)
        Node topRight = dfs(grid, mid, r, c + mid);

        // bottomLeft: starts at (r + mid, c)
        Node bottomLeft = dfs(grid, mid, r + mid, c);

        // bottomRight: starts at (r + mid, c + mid)
        Node bottomRight = dfs(grid, mid, r + mid, c + mid);

        // Create and return an internal node with the four quadrants
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}