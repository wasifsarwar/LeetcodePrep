package Trees;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

}

public class BinaryTreeInOrder {
    public static List<Integer> result;

    public static List<Integer> binaryTreeInOrderTraversal(TreeNode root) {
        result = new ArrayList<>();
        inOrder(root);
        return result;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        result.add(root.val);
        inOrder(root.right);

    }

    public static List<Integer> inOrderIterative(TreeNode root) {
        // Initialize result list to store the traversal values
        result = new ArrayList<>();

        // If tree is empty, return empty result
        if (root == null) {
            return result;
        }

        // Create stack to simulate recursion
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        // Continue until we've processed all nodes
        while (curr != null || !stack.isEmpty()) {
            // First, go as far left as possible, pushing each node onto stack
            while (curr != null) {
                // Save current node for later processing
                stack.push(curr);
                // Move to left child
                curr = curr.left;
            }

            // When we can't go further left, pop node from stack
            curr = stack.pop();

            // IN-ORDER: Process node AFTER left subtree but BEFORE right subtree
            result.add(curr.val);

            // Move to right child
            // If right is null, curr becomes null and next iteration will pop from stack
            curr = curr.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(binaryTreeInOrderTraversal(root));
        System.out.println(inOrderIterative(root));
    }

}
