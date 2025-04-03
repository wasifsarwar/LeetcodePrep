package Trees;

import java.util.*;

/**
 * BFSTreeNode class represents a binary tree node structure with BFS traversal
 * capability.
 * This class demonstrates a breadth-first search (level-order traversal)
 * algorithm
 * for binary trees, printing the tree values level by level.
 */
public class BFSTreeNode {
    int val; // Value stored in the node
    BFSTreeNode left; // Reference to the left child
    BFSTreeNode right; // Reference to the right child

    /**
     * Constructor to initialize a tree node with a value.
     * 
     * @param val The integer value to be stored in the node
     */
    public BFSTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    /**
     * Performs a breadth-first (level-order) traversal of the binary tree,
     * printing each node's value grouped by level.
     * 
     * BFS uses a queue to track nodes to be processed, ensuring that nodes
     * are visited level by level from top to bottom, left to right.
     * 
     * Time Complexity: O(n) where n is the number of nodes in the tree
     * - Each node is processed exactly once
     * 
     * Space Complexity: O(w) where w is the maximum width of the tree
     * - In the worst case, the queue will hold all nodes at the widest level
     * - For a balanced binary tree, this could be up to n/2 nodes at the leaf level
     * 
     * @param root The root node of the binary tree to traverse
     */
    public static void breadthFirstSearchPrint(BFSTreeNode root) {
        // Initialize a queue to store nodes that need to be visited
        Deque<BFSTreeNode> queue = new ArrayDeque<BFSTreeNode>();

        // Add the root node to the queue if it's not null
        if (root != null)
            queue.add(root);

        // Initialize a counter to track the current level
        int level = 0;

        // Continue processing while there are nodes in the queue
        while (queue.size() > 0) {
            // Print the current level number
            System.out.println("level: " + level + ": ");

            // Store the number of nodes at the current level
            // This is crucial for processing nodes level by level
            int levelLength = queue.size();

            // Process all nodes at the current level
            for (int i = 0; i < levelLength; i++) {
                // Remove the first node from the queue
                BFSTreeNode curr = queue.removeFirst();

                // Print the value of the current node
                System.out.println(curr.val + " ");

                // Add the left child to the queue if it exists
                // This ensures left-to-right processing in the next level
                if (curr.left != null)
                    queue.add(curr.left);

                // Add the right child to the queue if it exists
                if (curr.right != null)
                    queue.add(curr.right);
            }

            // Increment the level counter after processing all nodes at current level
            level++;
        }
    }

    /**
     * Main method to demonstrate the BFS traversal on a sample binary tree.
     * Creates a binary tree and performs a breadth-first traversal.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        /*
         * Create a sample binary tree
         * 4
         * / \
         * 3 6
         * / / \
         * 2 5 7
         */
        BFSTreeNode treeNode = new BFSTreeNode(4);
        treeNode.left = new BFSTreeNode(3);
        treeNode.right = new BFSTreeNode(6);
        treeNode.left.left = new BFSTreeNode(2);
        treeNode.right.left = new BFSTreeNode(5);
        treeNode.right.right = new BFSTreeNode(7);

        // Perform BFS traversal on the created tree
        breadthFirstSearchPrint(treeNode);
    }
}
