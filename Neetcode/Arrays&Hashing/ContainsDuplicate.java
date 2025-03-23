/**
 * Contains Duplicate

Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

Input: nums = [1, 2, 3, 3]

Output: true

Input: nums = [1, 2, 3, 4]

Output: false

Input: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]

Output: true
 */

import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        int[] n = {1, 1, 3, 4, 5, 6, 66};
        System.out.println(hasDuplicate(n));
    }

    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int n: nums) {
            if (seen.contains(n)) {
                return true;
            }
            seen.add(n);
        }
        return false;
        
    }
}

