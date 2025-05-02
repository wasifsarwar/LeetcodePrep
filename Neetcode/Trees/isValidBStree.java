package Trees;

public class isValidBStree {

    public static boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean dfs(TreeNode node, long left, long right) {
        if (node == null)
            return true;
        if (node.val <= left || node.val >= right) {
            return false;
        }

        return dfs(node.left, left, node.val) && dfs(node.right, node.val, right);
    }

    public static void main(String[] args) {
        // Create a valid BST:
        // 5
        // / \
        // 3 7
        // / \ \
        // 2 4 8
        TreeNode validRoot = new TreeNode(5);
        validRoot.left = new TreeNode(3);
        validRoot.right = new TreeNode(7);
        validRoot.left.left = new TreeNode(2);
        validRoot.left.right = new TreeNode(4);
        validRoot.right.right = new TreeNode(8);

        System.out.println("Valid BST test should return true: " + isValidBST(validRoot));

        // Create an invalid BST:
        // 5
        // / \
        // 3 7
        // / \ \
        // 2 6 8
        // Note: 6 is invalid because it's in left subtree but greater than 5
        TreeNode invalidRoot = new TreeNode(5);
        invalidRoot.left = new TreeNode(3);
        invalidRoot.right = new TreeNode(7);
        invalidRoot.left.left = new TreeNode(2);
        invalidRoot.left.right = new TreeNode(6); // This makes it invalid
        invalidRoot.right.right = new TreeNode(8);

        System.out.println("Invalid BST test should return false: " + isValidBST(invalidRoot));
    }
}
