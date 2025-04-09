import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = { 2, 4, 6, 8, 10 };
        int[] nums2 = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf(nums2)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] postfixProduct = new int[nums.length];

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            /**
             * we calculate the product of element before the element we are looking at
             * for 1st element, it'll be 1 because there's no element before that
             * we then multiply current element with prefix
             * 
             */

            prefixProduct[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            postfixProduct[i] = postfix;
            postfix *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefixProduct[i] * postfixProduct[i];
        }

        return nums;
    }
}
