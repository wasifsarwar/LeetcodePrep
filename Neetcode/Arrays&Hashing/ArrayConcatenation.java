public class ArrayConcatenation {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(arrayConcatenation(nums).length);
        int[] result = arrayConcatenation(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] arrayConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[i + nums.length] = nums[i];
        }
        return result;
    }
}
