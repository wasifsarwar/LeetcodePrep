package Trees;

import java.util.*;

public class ConstructBinaryTreeFromPreOrderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Base case: if either array is empty, return null
        if (preorder.length == 0 || inorder.length == 0)
            return null;

        // First element in preorder is always the root of current subtree
        TreeNode root = new TreeNode(preorder[0]);

        // Find position of root in inorder array
        // Elements before this position form left subtree
        // Elements after this position form right subtree
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
            }
        }

        // Create left subtree arrays:
        // leftPreOrder: elements after root in preorder, length = size of left subtree
        // leftInOrder: elements before root in inorder
        int[] leftpreOrder = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree(leftpreOrder, leftInOrder); // Recursive call for left subtree

        // Create right subtree arrays:
        // rightPreOrder: remaining elements in preorder
        // rightInOrder: elements after root in inorder
        int[] rightpreOrder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightInOrder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        root.right = buildTree(rightpreOrder, rightInOrder); // Recursive call for right subtree

        return root;
    }

    public static void main(String[] args) {
        // Example 1:
        // Input:
        // preorder = [3,9,20,15,7]
        // inorder = [9,3,15,20,7]
        // Output: [3,9,20,null,null,15,7]
        // 3
        // / \
        // 9 20
        // / \
        // 15 7
        int[] preorder1 = { 3, 9, 20, 15, 7 };
        int[] inorder1 = { 9, 3, 15, 20, 7 };

        ConstructBinaryTreeFromPreOrderAndInorderTraversal solution = new ConstructBinaryTreeFromPreOrderAndInorderTraversal();
        TreeNode root1 = solution.buildTree(preorder1, inorder1);
        System.out.println("Example 1 tree: " + root1);

        // Example 2:
        // Input:
        // preorder = [1,2,4,5,3,6]
        // inorder = [4,2,5,1,3,6]
        // Output: [1,2,3,4,5,6]
        // 1
        // / \
        // 2 3
        // / \ \
        // 4 5 6
        int[] preorder2 = { 1, 2, 4, 5, 3, 6 };
        int[] inorder2 = { 4, 2, 5, 1, 3, 6 };

        TreeNode root2 = solution.buildTree(preorder2, inorder2);
        System.out.println("Example 1 tree: " + root2);
    }
}
