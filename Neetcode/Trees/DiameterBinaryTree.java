package Trees;

public class DiameterBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int diameter;

    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        dfs(root);
        return diameter;
    }

    public static int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(5);

        System.out.println("diameter of this tree: " + diameterOfBinaryTree(root));
    }
}
