package Trees;

public class CountGoodNodes {

    public static int result = 0;

    public static int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return result;
    }

    public static int dfs(TreeNode node, int maxVal) {
        /**
         * base case. Pre order traversal, process current node first
         */
        if (node == null)
            return 0;
        if (node.val >= maxVal) {
            result = 1;
        } else {
            result = 0;
        }

        result += dfs(node.left, Math.max(node.val, maxVal));
        result += dfs(node.right, Math.max(node.val, maxVal));
        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(goodNodes(root));
    }
}
