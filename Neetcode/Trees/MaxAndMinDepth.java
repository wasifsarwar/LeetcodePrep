package Trees;

public class MaxAndMinDepth {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Finds the maximum depth (height) of the binary tree.
     * Maximum depth is the number of nodes along the longest path from root to the
     * farthest leaf node.
     * 
     * @param root The root node of the binary tree
     * @return The maximum depth of the tree
     */
    public static int maxDepth(TreeNode root) {
        // Base case: if node is null, depth is 0
        if (root == null)
            return 0;

        // Recursively find the depth of left subtree
        int leftMaxDepth = maxDepth(root.left);

        // Recursively find the depth of right subtree
        int rightMaxDepth = maxDepth(root.right);

        // Return 1 (for current node) plus the deeper of the two subtrees
        // We always want the maximum, regardless of whether subtrees exist or not
        return 1 + Math.max(leftMaxDepth, rightMaxDepth);
    }

    /**
     * Finds the minimum depth of the binary tree.
     * Minimum depth is the number of nodes along the shortest path from root to the
     * nearest leaf node.
     * Important: A leaf node is a node with no children.
     * 
     * @param root The root node of the binary tree
     * @return The minimum depth of the tree
     */
    public static int minDepth(TreeNode root) {
        // Base case: if node is null, depth is 0
        if (root == null) {
            return 0;
        }

        // If this is a leaf node (no children), return 1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // If only right child exists, we MUST go that way
        // We can't return 0 for the null left side as that's not a path to a leaf
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        // If only left child exists, we MUST go that way
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // If both children exist, find the minimum depth of both subtrees
        // Return 1 (for current node) plus the minimum of the two paths
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("maxDepth: " + maxDepth(root));
        System.out.println("minDepth: " + minDepth(root));
    }
}
