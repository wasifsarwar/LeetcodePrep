package Trees;

public class DFSTreeNode {

    int val;
    DFSTreeNode left;
    DFSTreeNode right;

    public DFSTreeNode(int n) {
        this.val = n;
        this.left = null;
        this.right = null;
    }

    /**
     * Performs an inorder traversal of a binary tree and prints the node values.
     * Inorder traversal follows the pattern: left subtree -> root -> right subtree
     * 
     * @param root The root node of the binary tree to traverse
     * 
     *             Example tree:
     *             6
     *             / \
     *             4 8
     *             / \
     *             3 5
     * 
     *             Output would be: 3, 4, 5, 6, 8
     * 
     *             Line-by-line explanation:
     *             1. if (root == null) - Base case: if we reach a null node, return
     *             2. inOrderSearch(root.left) - Recursively traverse the left
     *             subtree
     *             3. System.out.println(root.val) - Print the current node's value
     *             4. inOrderSearch(root.right) - Recursively traverse the right
     *             subtree
     */
    public static void inOrderSearch(DFSTreeNode root) {
        if (root == null) {
            return;
        }
        inOrderSearch(root.left);
        System.out.println(root.val);
        inOrderSearch(root.right);
    }

    /**
     * Performs a preorder traversal of a binary tree and prints the node values.
     * Preorder traversal follows the pattern: root -> left subtree -> right subtree
     * This traversal is useful for creating a copy of the tree or getting prefix
     * expression
     * of an expression tree.
     * 
     * @param root The root node of the binary tree to traverse
     * 
     *             Example tree:
     *             6
     *             / \
     *             4 8
     *             / \
     *             3 5
     * 
     *             Output would be: 6, 4, 3, 5, 8
     * 
     *             Line-by-line explanation:
     *             1. if (root == null) - Base case: if we reach a null node, return
     *             2. System.out.println(root.val) - Print the current node's value
     *             first
     *             3. preOrderSearch(root.left) - Recursively traverse the left
     *             subtree
     *             4. preOrderSearch(root.right) - Recursively traverse the right
     *             subtree
     * 
     *             Time Complexity: O(n) where n is the number of nodes in the tree
     *             Space Complexity: O(h) where h is the height of the tree
     *             (recursion stack)
     */
    public static void preOrderSearch(DFSTreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        preOrderSearch(root.left);
        preOrderSearch(root.right);
    }

    /**
     * Performs a postorder traversal of a binary tree and prints the node values.
     * Postorder traversal follows the pattern: left subtree -> right subtree ->
     * root
     * This traversal is particularly useful for:
     * - Deleting a tree (need to delete children before parent)
     * - Computing directory sizes in file systems
     * - Evaluating mathematical expressions in postfix notation
     * 
     * @param root The root node of the binary tree to traverse
     * 
     *             Example tree:
     *             6
     *             / \
     *             4 8
     *             / \
     *             3 5
     * 
     *             Output would be: 3, 5, 4, 8, 6
     * 
     *             Line-by-line explanation:
     *             1. if (root == null) - Base case: if we reach a null node, return
     *             2. postOrderSearch(root.left) - Recursively traverse the left
     *             subtree
     *             3. postOrderSearch(root.right) - Recursively traverse the right
     *             subtree
     *             4. System.out.println(root.val) - Print the current node's value
     *             last
     * 
     *             Time Complexity: O(n) where n is the number of nodes in the tree
     *             Space Complexity: O(h) where h is the height of the tree
     *             (recursion stack)
     */
    public static void postOrderSearch(DFSTreeNode root) {
        if (root == null)
            return;
        postOrderSearch(root.left);
        postOrderSearch(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        DFSTreeNode treeNode = new DFSTreeNode(6);
        treeNode.left = new DFSTreeNode(4);
        treeNode.right = new DFSTreeNode(8);
        treeNode.left.left = new DFSTreeNode(3);
        treeNode.left.right = new DFSTreeNode(5);

        inOrderSearch(treeNode);
        System.out.println();
        preOrderSearch(treeNode);
        System.out.println();
        postOrderSearch(treeNode);
    }
}
