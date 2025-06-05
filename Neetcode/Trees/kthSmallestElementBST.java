package Trees;

import java.util.*;;

public class kthSmallestElementBST {

    /**
     * If the BST is modified often (i.e., we can do insert and delete operations)
     * and you need to find the kth smallest frequently, how would you optimize?
     * 
     * 
     * 
     * 
     * @param root
     * @param k
     * @return
     */

    // Method to find kth smallest element in a BST using iterative inorder
    // traversal
    public static int kthSmallest(TreeNode root, int k) {
        // Counter to keep track of nodes visited
        int n = 0;
        // Stack to help with iterative traversal
        Stack<TreeNode> stack = new Stack<>();
        // Current node pointer
        TreeNode curr = root;

        // Continue traversal while we have nodes to process
        while (curr != null || !stack.isEmpty()) {
            // Go as far left as possible, pushing all nodes onto stack
            // This ensures we process smaller elements first
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Pop the smallest unprocessed node
            curr = stack.pop();
            // Increment our counter - we've found the next smallest element
            n += 1;

            // If we've found the kth element, return its value
            if (n == k) {
                return curr.val;
            }

            // Move to the right child - next larger element
            curr = curr.right;
        }
        // Return count if k is larger than tree size
        return n;
    }

    public static void main(String[] args) {
        // Create a BST:
        // 5
        // / \
        // 3 7
        // / \ \
        // 2 4 8
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);

        int k = 3;
        System.out.println("The " + k + "rd smallest element is: " + kthSmallest(root, k));
        k = 4;
        System.out.println("The " + k + "th smallest element is: " + kthSmallest(root, k));
    }
}
