package AmexInterviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class RemoveDuplicateInAnArray {

    public static List<Integer> removeDuplicate(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            int index = cur - 1;
            if (nums[index] < 0) {
                res.add(cur);
            } else {
                nums[index] = -1 * nums[index];
            }
        }
        return res;
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }

    // Time complexity: O(n) because we iterate through all the numbers in the
    // array. This works for both
    // sorted list, and unsorted list.
    public static boolean linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

    // 6, 7 , 8 , 9 , 10
    // 0 1 2 3 4
    // target = 7

    /**
     * 1st iteration:
     * mid = 0 + 4 / 2 = 2; = nums[mid] = 8 << 7. So, 8.compareTo(7) = 1;
     */

    public static <T extends Comparable<T>> boolean binarySearch(T[] data, int min, int max, T target) {
        boolean found = false;
        
        if (min > max) {
            return false;
        }

        int mid = (min + max) / 2;

        if (data[mid].compareTo(target) == 0) {
            found = true;
        } else if (data[mid].compareTo(target) > 0) { // // 9.compareTo(8) -> 1
            found = binarySearch(data, min, mid - 1, target);
        } else { // // 9.compareTo(10) -> -1
            found = binarySearch(data,  )
        }


    }

    public static void main(String[] args) {
        int[] nums = new int[] {
                1, 3, 5, 3, 6, 7, 2, 1
        };
        System.out.println(removeDuplicate(nums));
    }
}
