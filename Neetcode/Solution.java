import java.util.*;

class Solution {
    public int reverse(int x) {
        String ans;
        if (x < 0) {
            ans = new StringBuilder(String.valueOf(-x)).append("-").reverse().toString();
        } else {
            ans = new StringBuilder(String.valueOf(x)).reverse().toString();
        }

        try {
            long result = Long.parseLong(ans);
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) result;
        } catch (Exception e) {
            return 0;
        }
    }

    public void moveZeroes(int[] nums) {
        int l = 0; // left pointer for placing non-zero elements

        // First pass: move all non-zero elements to the front
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
        }
    }

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '*' && sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1); // remove the last character
            } else if (c != '*') {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * Generates all combinations of well-formed parentheses for a given number n.
     * 
     * @param n The number of pairs of parentheses.
     * @return A list of strings, where each string is a valid combination of
     *         parentheses.
     */
    public List<String> generateParenthesis(int n) {
        // List to store all valid combinations of parentheses found.
        List<String> result = new ArrayList<>();
        // Stack to build the current combination of parentheses.
        // Using Stack<String> to easily join into a string later, though
        // Stack<Character> is also common.
        Stack<String> stack = new Stack<>();
        // Initiate the backtracking process.
        // Starts with 0 open parentheses, 0 closed parentheses, for n pairs.
        backTrack(0, 0, n, result, stack);
        return result; // Return the list of all found combinations.
    }

    /**
     * Recursive helper function to perform backtracking to find all valid
     * parentheses combinations.
     *
     * @param openCount    The current count of open parentheses '(' in the stack.
     * @param closedCount  The current count of closed parentheses ')' in the stack.
     * @param n            The target number of pairs of parentheses.
     * @param resultList   The list to add valid combinations to.
     * @param currentStack The stack representing the current combination being
     *                     built.
     */
    public void backTrack(int openCount, int closedCount, int n, List<String> resultList, Stack<String> currentStack) {
        // Base Case: If the number of open parentheses equals the number of closed
        // parentheses,
        // and both equal n, then a valid combination of n pairs has been formed.
        if (openCount == closedCount && openCount == n) {
            // Join the characters in the stack to form a string and add it to the result
            // list.
            resultList.add(String.join("", currentStack));
            return; // Backtrack from this path as a complete valid combination is found.
        }

        // Recursive Step 1: Try adding an open parenthesis '('.
        // Condition: Only add an open parenthesis if the count of open parentheses is
        // less than n.
        if (openCount < n) {
            currentStack.push("("); // Add '(' to the current combination.
            // Recursively call backTrack with an incremented openCount.
            backTrack(openCount + 1, closedCount, n, resultList, currentStack);
            currentStack.pop(); // Backtrack: Remove the last added '(' to explore other possibilities.
        }

        // Recursive Step 2: Try adding a closed parenthesis ')'.
        // Condition: Only add a closed parenthesis if the count of closed parentheses
        // is less than the count of open parentheses.
        // This ensures that we don't have more closing brackets than opening ones at
        // any point, maintaining validity.
        if (closedCount < openCount) {
            currentStack.push(")"); // Add ')' to the current combination.
            // Recursively call backTrack with an incremented closedCount.
            backTrack(openCount, closedCount + 1, n, resultList, currentStack);
            currentStack.pop(); // Backtrack: Remove the last added ')' to explore other possibilities.
        }
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        if (n == 0)
            return arr; // Handle empty list case
        d = d % n;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
        return arr;
    }

    public static void reverse(List<Integer> arr, int l, int r) {
        while (l < r) {
            int temp = arr.get(l);
            arr.set(l, arr.get(r)); // Use set to replace element
            arr.set(r, temp); // Use set to replace element
            l++;
            r--;
        }
    }
}