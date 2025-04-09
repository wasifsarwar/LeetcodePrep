package Trees;

import java.util.*;

/**
 * TreeMaze represents a binary tree structure used to find valid paths to leaf
 * nodes.
 * In this context, a leaf node is a node without any children.
 * Nodes with value 0 are considered invalid/blocked and cannot be part of a
 * valid path.
 */
public class TreeMaze {
    int val; // Value of the current node
    TreeMaze left; // Reference to the left child
    TreeMaze right; // Reference to the right child

    /**
     * Constructor to create a TreeMaze node with a specified value.
     * 
     * @param n The integer value to be stored in the node
     */
    public TreeMaze(int n) {
        this.val = n;
        this.left = null;
        this.right = null;
    }

    /**
     * Finds a valid path from the root to any leaf node and stores it in the
     * provided list.
     * A valid path must not contain any nodes with value 0.
     * 
     * This method uses depth-first search (DFS) to traverse the tree and find the
     * first
     * valid path to a leaf node. Once a valid path is found, the search stops.
     * 
     * Time Complexity: O(n) where n is the number of nodes in the tree
     * - In the worst case, we might need to visit all nodes before finding a valid
     * path
     * - Each node is processed at most once
     * 
     * Space Complexity: O(h) where h is the height of the tree
     * - The recursion stack can go as deep as the height of the tree
     * - Additionally, the path list will store at most h nodes
     * 
     * @param root The root node of the tree to be traversed
     * @param path An ArrayList to store the nodes in the valid path from root to
     *             leaf
     * @return true if a valid path to a leaf is found, false otherwise
     */
    public static boolean leafPath(TreeMaze root, ArrayList<Integer> path) {
        // Base cases:
        // 1. If node is null or has value 0, this is not a valid path
        if (root == null || root.val == 0)
            return false;

        // Add current node to the path being constructed
        path.add(root.val);

        // Check if we've found a leaf node (a node with no children)
        // If so, we've found a valid path to a leaf
        if (root.left == null && root.right == null)
            return true;

        // Recursively try the left subtree first
        // If a valid path is found in the left subtree, return true immediately
        if (leafPath(root.left, path))
            return true;

        // If no valid path in left subtree, try the right subtree
        // If a valid path is found in the right subtree, return true
        if (leafPath(root.right, path))
            return true;

        // If we reach here, no valid path was found through this node
        // We should remove this node from the path (backtracking)
        path.remove(path.size() - 1);
        return false;
    }


    public static void main(String[] args) {
        TreeMaze treeNode = new TreeMaze(4);
        treeNode.left = new TreeMaze(3);
        treeNode.right = new TreeMaze(6);
        treeNode.left.left = new TreeMaze(0);
        treeNode.right.left = new TreeMaze(5);
        treeNode.right.right = new TreeMaze(7);

        System.out.println(leafPath(treeNode, new ArrayList<Integer>()));
    }
}
