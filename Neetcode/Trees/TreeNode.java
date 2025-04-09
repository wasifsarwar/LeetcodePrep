package Trees;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int n) {
        this.val = n;
        this.left = null;
        this.right = null;
    }

    /**
     * Search for a target value in a Binary Search Tree
     * 
     * @param root   root node of the BST
     * @param target value to search for
     * @return true if target exists in tree, false otherwise
     * 
     *         Time complexity: O(h) where h is height of tree
     *         For balanced BST: O(log n)
     *         For skewed BST: O(n)
     */
    public static boolean contains(TreeNode root, int target) {
        if (root == null) { // ran out of nodes to search
            return false;
        }
        if (target > root.val) {
            return contains(root.right, target);
        } else if (target < root.val) {
            return contains(root.left, target);
        } else {
            return true;
        }
    }

    /**
     * Insert a value into a Binary Search Tree
     * 
     * @param root root node of the BST
     * @param val  value to insert
     * @return the root node of the modified BST
     * 
     *         Time complexity: O(h) where h is height of tree
     *         For balanced BST: O(log n)
     *         For skewed BST: O(n)
     * 
     *         The method recursively traverses the tree:
     *         - If root is null, creates a new node with the value
     *         - If value > root.val, inserts into right subtree
     *         - If value < root.val, inserts into left subtree
     *         - If value = root.val, no insertion needed (BST property)
     */
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            root.right = insert(root.right, val);
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        }
        return root;
    }

    /**
     * Remove a node with the target value from a Binary Search Tree
     * 
     * @param root   root node of the BST
     * @param target value to remove from the BST
     * @return the root node of the modified BST
     * 
     *         Time complexity: O(h) where h is height of tree
     *         For balanced BST: O(log n)
     *         For skewed BST: O(n)
     * 
     *         The method handles three cases for node deletion:
     *         1. Node has no children (leaf node) - simply remove it
     *         2. Node has one child - replace node with its child
     *         3. Node has two children - replace node with its inorder successor
     *         (minimum value in right subtree) and remove that successor
     */
    public static TreeNode remove(TreeNode root, int target) {
        // Base case: if tree is empty or node not found
        if (root == null) {
            return null;
        }

        // Recursively search for the target node
        if (target > root.val) {
            // Target is in right subtree
            root.right = remove(root.right, target);
        } else if (target < root.val) {
            // Target is in left subtree
            root.left = remove(root.left, target);
        } else {
            // Found the target node - handle deletion based on number of children

            // Case 1 & 2: Node has 0 or 1 child
            if (root.left == null) {
                // No left child - return right child (could be null)
                return root.right;
            } else if (root.right == null) {
                // No right child - return left child
                return root.left;
            } else {
                // Case 3: Node has 2 children
                // Find the inorder successor (minimum value in right subtree)
                TreeNode minNode = minTreeNode(root.right);
                // Replace current node's value with successor's value
                root.val = minNode.val;
                // Remove the successor node from right subtree
                root.right = remove(root.right, minNode.val);
            }
        }
        return root;
    }

    /**
     * Find the node with the minimum value in a Binary Search Tree
     * 
     * @param root root node of the BST
     * @return the node containing the minimum value in the BST
     * 
     *         Time complexity: O(h) where h is height of tree
     *         For balanced BST: O(log n)
     *         For skewed BST: O(n)
     * 
     *         The method traverses the leftmost path of the BST:
     *         - In a BST, the minimum value is always in the leftmost node
     *         - Follows left pointers until reaching a null left pointer
     *         - Returns the last non-null node encountered
     */
    public static TreeNode minTreeNode(TreeNode root) {
        TreeNode curr = root; // set a pointer at root
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    /**
     * Find the node with the maximum value in a Binary Search Tree
     * 
     * @param root root node of the BST
     * @return the node containing the maximum value in the BST
     * 
     *         Time complexity: O(h) where h is height of tree
     *         For balanced BST: O(log n)
     *         For skewed BST: O(n)
     * 
     *         The method traverses the rightmost path of the BST:
     *         - In a BST, the maximum value is always in the rightmost node
     *         - Follows right pointers until reaching a null right pointer
     *         - Returns the last non-null node encountered
     */
    public static TreeNode maxTreeNode(TreeNode root) {
        TreeNode curr = root;
        while (curr != null && curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);

        System.out.println(contains(treeNode, 3));
        System.out.println(contains(treeNode, 7));
        System.out.println(maxTreeNode(treeNode).val); // returns 8
        System.out.println(minTreeNode(treeNode).val); // returns 3
    }
}