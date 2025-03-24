import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
       int[] nums = {1,2, 3, 5}; 
       int target = 6;

        for (int n : twoSum(nums, target)) {
            System.out.println(n);
        };
    }

    /**
     * 
     * @param nums
     * @param target
     * @return
     * Time Complexity: O(n) as we are iterating through the entire array
     * Space Complexity: O(n) as we are storing every value in hashMap
     */
    public static int[] twoSum(int[] nums, int target) {
        // key: num, value: index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{i, map.get(diff)};
            }
        }
        return new int[0];
    }
}
