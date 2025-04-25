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

public class BinaryTreePostOrder {

    public static List<Integer> result;

    public static List<Integer> postOrderTraversal(TreeNode root) {
        result = new ArrayList<>();
        postOrder(root);
        return result;
    }

    public static void postOrder(TreeNode root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        result.add(root.val);
    }

    public static List<Integer> postOrderIterative(TreeNode root) {
        // Initialize result list to store traversal values
        result = new ArrayList<>();

        // If tree is empty, return empty result
        if (root == null) {
            return result;
        }

        // Create stack to simulate recursion
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        // This algorithm does a modified pre-order traversal (Root->Right->Left)
        // and then reverses it to get post-order (Left->Right->Root)
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                // Visit the current node first (Root)
                result.add(curr.val);

                // Save left child for later processing
                // Note: This is the opposite of normal pre-order
                stack.push(curr.left);

                // Move to right child first (process Right before Left)
                // This is the key difference from standard pre-order
                curr = curr.right;
            } else {
                // When curr is null, we've finished the right subtree
                // Pop from stack to process the left subtree
                curr = stack.pop();
            }
        }

        // Reverse the result to transform Root->Right->Left into Left->Right->Root
        // This is what converts our modified pre-order into post-order
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(postOrderTraversal(root));
        System.out.println(postOrderIterative(root));

    }
}
