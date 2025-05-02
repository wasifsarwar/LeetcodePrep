package Trees;

public class InsertIntoBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Recursive solution to insert a node into a Binary Search Tree
     * 
     * Approach:
     * 1. If the tree is empty (root is null), create a new node with the given
     * value
     * 2. If the value is greater than the current node's value, recursively insert
     * into the right subtree
     * 3. If the value is less than the current node's value, recursively insert
     * into the left subtree
     * 4. Return the root node after insertion
     * 
     * Time Complexity: O(h) where h is the height of the tree
     * - In the worst case (skewed tree), h = n, making it O(n)
     * - In the best case (balanced tree), h = log(n), making it O(log n)
     * 
     * Space Complexity: O(h) due to the recursion stack
     * - In the worst case (skewed tree), h = n, making it O(n)
     * - In the best case (balanced tree), h = log(n), making it O(log n)
     * 
     * @param root The root of the BST
     * @param val  The value to be inserted
     * @return The root of the BST after insertion
     */
    public TreeNode insertNodeRecursive(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val > root.val) {
            root.right = insertNodeRecursive(root.right, val);
        } else {
            root.left = insertNodeRecursive(root.left, val);
        }
        return root;
    }

    /**
     * Iterative solution to insert a node into a Binary Search Tree
     * 
     * Approach:
     * 1. If the tree is empty (root is null), create a new node with the given
     * value
     * 2. Traverse the tree while maintaining a current node pointer
     * 3. If the value is less than current node's value, move to left child
     * 4. If the value is greater than current node's value, move to right child
     * 5. When we reach a null child, insert the new node there
     * 
     * Time Complexity: O(h) where h is the height of the tree
     * - In the worst case (skewed tree), h = n, making it O(n)
     * - In the best case (balanced tree), h = log(n), making it O(log n)
     * 
     * Space Complexity: O(1)
     * - Uses constant extra space as it doesn't use recursion
     * - Only maintains a current node pointer
     * 
     * @param root The root of the BST
     * @param val  The value to be inserted
     * @return The root of the BST after insertion
     */
    public TreeNode insertIntoBSTiterative(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        TreeNode curr = root;
        while (true) {
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    return root;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    return root;
                }
                curr = curr.right;
            }
        }
    }

    public static void main(String[] args) {

    }
}
