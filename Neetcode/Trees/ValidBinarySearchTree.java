package Trees;

import Trees.TreeNode;

/**
 * Solution for validating if a binary tree is a valid Binary Search Tree (BST).
 * A valid BST has the following properties:
 * 1. The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * 2. The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * 3. Both the left and right subtrees must also be binary search trees.
 */
public class ValidBinarySearchTree {

    /**
     * Main method to check if a binary tree is a valid BST.
     * Uses a helper method with value range validation.
     * 
     * @param root The root node of the binary tree
     * @return true if the tree is a valid BST, false otherwise
     */
    public boolean isValidBST(TreeNode root) {
        // Call helper method with initial bounds as minimum and maximum possible values
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Recursive helper method that validates if a node and its subtrees form a
     * valid BST.
     * Each node's value must be within the valid range defined by left and right
     * bounds.
     * 
     * @param node  The current node being validated
     * @param left  The minimum value the current node can have (lower bound)
     * @param right The maximum value the current node can have (upper bound)
     * @return true if the node and its subtrees form a valid BST, false otherwise
     */
    public boolean isValid(TreeNode node, long left, long right) {
        // Base case: empty trees are valid BSTs
        if (node == null)
            return true;

        // Check if current node's value is within the valid range
        if (node.val <= left || node.val >= right)
            return false;

        // Recursively validate left and right subtrees with updated bounds:
        // - For left subtree: upper bound becomes current node's value
        // - For right subtree: lower bound becomes current node's value
        return isValid(node.left, left, node.val) && isValid(node.right, node.val, right);
    }
}
