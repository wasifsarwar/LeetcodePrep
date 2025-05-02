package Trees;

public class DeleteNodeBST {

    /**
     * Deletes a node with the given key from a Binary Search Tree
     * 
     * Approach:
     * 1. If the tree is empty, return null
     * 2. If the key is less than current node's value, recursively delete from left
     * subtree
     * 3. If the key is greater than current node's value, recursively delete from
     * right subtree
     * 4. If we find the node to delete (key == root.val):
     * a. If node has no left child, return right child
     * b. If node has no right child, return left child
     * c. If node has both children:
     * - Find the inorder successor (smallest node in right subtree)
     * - Replace current node's value with successor's value
     * - Recursively delete the successor node
     * 
     * Time Complexity: O(h) where h is the height of the tree
     * - In the worst case (skewed tree), h = n, making it O(n)
     * - In the best case (balanced tree), h = log(n), making it O(log n)
     * 
     * Space Complexity: O(h) due to recursion stack
     * - In the worst case (skewed tree), h = n, making it O(n)
     * - In the best case (balanced tree), h = log(n), making it O(log n)
     * 
     * @param root The root of the BST
     * @param key  The value of the node to be deleted
     * @return The root of the BST after deletion
     */
    public static TreeNode delTreeNode(TreeNode root, int key) {
        if (root == null)
            return root;
        if (key < root.val) {
            root.left = delTreeNode(root.left, key);
        } else if (key > root.val) {
            root.right = delTreeNode(root.right, key);
        } else {
            // Case 1: Node has no left child
            if (root.left == null)
                return root.right;
            // Case 2: Node has no right child
            if (root.right == null)
                return root.left;

            // Case 3: Node has both children
            // Find the inorder successor (smallest node in right subtree)
            TreeNode curr = root.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            // Replace current node's value with successor's value
            root.val = curr.val;
            // Delete the successor node
            root.right = delTreeNode(root.right, root.val);
        }
        return root;
    }

    public static void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        inOrder(delTreeNode(root, 6));
    }
}
