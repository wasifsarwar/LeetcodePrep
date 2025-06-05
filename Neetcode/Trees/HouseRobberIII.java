package Trees;

import java.util.*;

public class HouseRobberIII {

    /**
     * 
     * @param root
     * @return
     * 
     *         two cases: [1st case: withRoot, 2nd case: withoutRoot]
     *         Depth first search: O(n) as we need to visit each nodes once
     * 
     *         The thief has found himself a new place for his thievery again. There
     *         is only one entrance to this area, called root.
     * 
     *         In this new place, there are houses and each house has its only one
     *         parent house. All houses in this place form a binary tree. It will
     *         automatically contact the police if two directly-linked houses were
     *         broken.
     * 
     *         You are given the root of the binary tree, return the maximum amount
     *         of money the thief can rob without alerting the police
     */

    /**
     * House Robber III - Dynamic Programming on Binary Tree
     * 
     * Problem:
     * - Thief wants to rob houses arranged in a binary tree
     * - Can't rob directly connected houses (parent-child) as it triggers alarm
     * - Need to find maximum money possible without alerting police
     * 
     * Approach:
     * For each node, we have two choices:
     * 1. Rob this node: Then we can't rob its children (but can rob grandchildren)
     * 2. Skip this node: Then we can rob its children
     * 
     * Time: O(n) where n is number of nodes
     * Space: O(h) where h is height of tree (recursion stack)
     */
    public static int rob(TreeNode root) {
        // Base case: empty tree has no value
        if (root == null)
            return 0;

        // Option 1: Rob current house
        int robThisHouse = root.val;

        // If we rob this house, we can only rob grandchildren
        if (root.left != null) {
            // Add possible money from left grandchildren
            robThisHouse += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            // Add possible money from right grandchildren
            robThisHouse += rob(root.right.left) + rob(root.right.right);
        }

        // Option 2: Skip this house
        // If we skip this house, we can rob its children
        int skipThisHouse = rob(root.left) + rob(root.right);

        // Return the maximum of the two options
        return Math.max(robThisHouse, skipThisHouse);
    }

    public static int robMemo(TreeNode root) {
        // Initialize memoization map
        Map<TreeNode, Integer> memo = new HashMap<>();
        return robHelper(root, memo);
    }

    private static int robHelper(TreeNode root, Map<TreeNode, Integer> memo) {
        // Base case: empty tree has no value
        if (root == null) {
            return 0;
        }

        // Check if the result for this node is already computed
        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        // Option 1: Rob current house
        int robThisHouse = root.val;

        // If we rob this house, we can only rob grandchildren
        if (root.left != null) {
            // Add possible money from left grandchildren
            robThisHouse += robHelper(root.left.left, memo) + robHelper(root.left.right, memo);
        }
        if (root.right != null) {
            // Add possible money from right grandchildren
            robThisHouse += robHelper(root.right.left, memo) + robHelper(root.right.right, memo);
        }

        // Option 2: Skip this house
        // If we skip this house, we can rob its children
        int skipThisHouse = robHelper(root.left, memo) + robHelper(root.right, memo);

        // Calculate the maximum for the current node
        int result = Math.max(robThisHouse, skipThisHouse);

        // Store the result in the memoization map
        memo.put(root, result);

        return result;
    }

    public static void main(String[] args) {
        // Example Tree 1:
        // 3
        // / \
        // 2 3
        // \ \
        // 3 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(1);

        int maxMoney1 = rob(root1);
        System.out.println("Example 1: Maximum money = " + maxMoney1); // Expected output: 7

        // Example Tree 2:
        // 3
        // / \
        // 4 5
        // / \ \
        // 1 3 1
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(1);

        int maxMoney2 = rob(root2);
        System.out.println("Example 2: Maximum money = " + maxMoney2); // Expected output: 9
    }
}
