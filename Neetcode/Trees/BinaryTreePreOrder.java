package Trees;

import java.util.*;

public class BinaryTreePreOrder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> result;

    public static List<Integer> binaryTreePreOrderTraversal(TreeNode root) {
        result = new ArrayList<>();
        preOrder(root);
        return result;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static List<Integer> preOrderIterative(TreeNode root) {
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
        // Either curr is not null (we have a node to process)
        // or stack is not empty (we have nodes waiting to be processed)
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                // PRE-ORDER: Process current node BEFORE children
                result.add(curr.val);

                // Save right child for later processing (push to stack)
                // This ensures we'll process right child after left subtree
                if (curr.right != null) {
                    stack.push(curr.right);
                }

                // Move to left child (process left subtree first)
                curr = curr.left;
            } else {
                // When curr is null, we've reached the end of a left subtree
                // Pop from stack to process the right subtree
                curr = stack.pop();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(binaryTreePreOrderTraversal(root));
        System.out.println(preOrderIterative(root));
    }
}
