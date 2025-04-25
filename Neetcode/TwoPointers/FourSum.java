package TwoPointers;
import java.util.*;
public class FourSum {

    public static List<List<Integer>> result;
    public static List<Integer> currentQuadruple;
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
    
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        currentQuadruple = new ArrayList<>();
        findQuadruples(nums, 4, 0, target);
        return result;
    }

    public static void findQuadruples(int[] nums, int k,  int start, int target) {
        if (k == 2) {
            int l = start;
            int r = nums.length - 1;
            while(l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    result.add(new ArrayList<>(currentQuadruple));
                    result.get(result.size() - 1).add(nums[l]);
                    result.get(result.size() - 1).add(nums[r]);
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
            return;
        }

        /**
         * Why nums.length - k + 1:
         * nums.length is the total number of elements in the array.
         * k is the number of elements we need to select to form a valid k-tuple.
         * nums.length - k gives the index of the last possible starting point for a k-tuple.
         * We add 1 because the loop is zero-indexed, and we want to include the element at nums.length - k as a possible starting point.
         */
        for (int i = start; i < nums.length - k + 1; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            currentQuadruple.add(nums[i]);
            findQuadruples(nums, k - 1, i + 1, target - nums[i]);
            currentQuadruple.remove(currentQuadruple.size() - 1);
        }
    }
    


}
