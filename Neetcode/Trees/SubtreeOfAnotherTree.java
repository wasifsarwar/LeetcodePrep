package Trees;

/**
 * Problem: Check if a binary tree is a subtree of another binary tree
 * A subtree is a tree consisting of a node and all of its descendants
 */
public class SubtreeOfAnotherTree {
    // TreeNode class to represent each node in the binary tree
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Checks if subTreeNode is a subtree of root
     * Time Complexity: O(m*n) where m is nodes in root, n is nodes in subTree
     * Space Complexity: O(h) where h is height of tree (recursion stack)
     */
    public static boolean isSubtree(TreeNode root, TreeNode subTreeNode) {
        // Base cases
        if (root == null)
            return false; // Empty tree cannot have a non-empty subtree

        if (subTreeNode == null)
            return true; // Empty tree is always a subtree of any tree

        // Check if trees match at current node
        if (isSame(root, subTreeNode)) {
            return true;
        }

        // Recursively check left and right subtrees
        return isSubtree(root.left, subTreeNode) || isSubtree(root.right, subTreeNode);
    }

    /**
     * Utility method to check if two trees have identical structure and values
     */
    public static boolean isSame(TreeNode p, TreeNode q) {
        // If both nodes are null, they are identical
        if (p == null && q == null)
            return true;

        // If one is null or values don't match, they're not identical
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // Recursively check if left and right subtrees are identical
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public static void main(String[] args) {
        // Create main tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(5);

        // Create potential subtree
        TreeNode subNode = new TreeNode(1);
        subNode.right = new TreeNode(2);
        subNode.right.left = new TreeNode(3);
        subNode.right.right = new TreeNode(4);

        // Note: subNode is not a subtree of root because root values differ (7 vs any
        // node in root)
        // However, subNode.right would be a subtree of root.right as they have
        // identical structure and values
        System.out.println(isSubtree(root, subNode));

        TreeNode anotherRoot = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.left = new TreeNode(6);

        System.out.println(isSubtree(anotherRoot, subNode));
    }
}
