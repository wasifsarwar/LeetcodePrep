package Trees;

/**
 * Problem: Find the diameter of a binary tree
 * The diameter is defined as the length of the longest path between any two
 * nodes in a tree
 * This path may or may not pass through the root
 */
public class DiameterBinaryTree {

    // TreeNode class to represent each node in the binary tree
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Global variable to track the maximum diameter found
    public static int diameter;

    /**
     * Finds the diameter of the binary tree
     * Time Complexity: O(n) where n is the number of nodes
     * Space Complexity: O(h) where h is the height of tree (recursion stack)
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        dfs(root);
        return diameter;
    }

    /**
     * Helper method that performs depth-first search
     * Returns the height of the tree rooted at node
     * While calculating heights, also updates the global diameter variable
     */
    public static int dfs(TreeNode node) {
        // Base case: empty tree has height 0
        if (node == null)
            return 0;

        // Recursively find the height of left and right subtrees
        int left = dfs(node.left);
        int right = dfs(node.right);

        // Update diameter if the path going through current node is longer
        // The path through current node has length = left height + right height
        diameter = Math.max(diameter, left + right);

        // Return the height of tree rooted at current node
        // Height = 1 (current node) + max height of its subtrees
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        // Create a sample tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(5);

        // Calculate and print the diameter
        System.out.println("diameter of this tree: " + diameterOfBinaryTree(root));
    }
}
