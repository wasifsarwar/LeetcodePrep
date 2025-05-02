package Trees;

import java.util.*;;

public class kthSmallestElementBST {

    public int kthSmallest(TreeNode root, int k) {
        int n = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            n += 1;
            if (n == k) {
                return curr.val;
            }
            curr = curr.right;
        }
        return n;

    }

    public static void main(String[] args) {

    }
}
