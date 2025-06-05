package Trees;

import java.util.*;

public class BinaryLevelOrderTraversal {

    // Stores the final result as a list of lists, where each inner list represents
    // a level
    public static List<List<Integer>> result;

    /**
     * Performs level order traversal of a binary tree
     * 
     * @param root The root node of the binary tree
     * @return A list of lists containing node values at each level
     */
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        // Initialize the result list
        result = new ArrayList<>();
        // Start DFS from root at depth 0
        dfs(root, 0);
        return result;
    }

    /**
     * Helper method that performs depth-first search to collect nodes at each level
     * 
     * @param node  Current node being processed
     * @param depth Current depth/level in the tree
     */
    private static void dfs(TreeNode node, int depth) {
        // Base case: if node is null, return
        if (node == null) {
            return;
        }

        // If we're at a new level, create a new list for that level
        if (result.size() == depth) {
            result.add(new ArrayList<>());
        }

        // Add current node's value to its corresponding level
        result.get(depth).add(node.val);

        // Recursively process left and right children, increasing depth by 1
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    public static List<List<Integer>> levelOrderTraversalBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelResult = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    levelResult.add(curr.val);
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
                if (levelResult.size() > 0) {
                    result.add(levelResult);
                }

            }
        }
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

        System.out.println(levelOrderTraversal(root));

    }
}
