public class BctciProblems {
    public static void main(String[] args) {

        String[] commits;
        commits = new String[] { "pass", "pass", "pass", "fail", "fail" };
        System.out.println(firstFail(commits));
        commits = new String[] { "fail", "fail", "fail" };
        System.out.println(firstFail(commits));

        int[] nums = new int[] { 2, 3, 4, 5, 6, 7, 8, 11, 20, 21, 23, 25, 25 };
        System.out.println("largest square target 36: " + largestSquare(nums, 36));
        System.out.println("largest square target 476: " + largestSquare(nums, 476));

        nums = new int[] { -21, -15, -9, -5, -5, -1, -1, 0, 0, 4, 7, 12, 21 };
        System.out.println("first non negative index: " + firstNonNegative(nums));

        System.out.println("nearest element target for 5: " + nearestElement(nums, 5));

    }

    /**
     * Find the first commit that fails a test in a sequence of Git commits. We know
     * that the test was passing
     * for every commit until it started failing at one point
     * ["pass", "pass", "pass", "fail", "fail"] Ans: 4
     */

    public static int firstFail(String[] commits) {
        int l = 0;
        int r = commits.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            String commit = commits[mid];
            if (commit.equals("fail")) {
                if (mid > 0 && commits[mid - 1].equals("pass")) {
                    r = mid;
                } else {
                    r--;
                }
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    /**
     * Given a sorted array of positive integers and a target value, find the
     * largest number in the array that can be squared and still be less than or
     * equal to the target, if any. Return the number (not the index)
     * [2, 3, 4, 5, 6, 7, 8, 11, 20, 21, 23, 25, 25], target = 36
     * answer: 11
     */

    public static int largestSquare(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int largest = 0;
        while (l < r) {
            int mid = (l + r) / 2;
            int square = nums[mid] * nums[mid];
            if (square <= target) {
                largest = Math.max(nums[mid], largest);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return largest;
    }

    /**
     * Return the index of the first non-negative integer in a sorted array
     * (duplicates allowed), if any.
     * [-21, -15, -9, -5, -5, -1, -1, 0 , 0 , 4, 7, 12, 21] ans: 7
     */

    public static int firstNonNegative(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            int num = nums[mid];
            if (num >= 0) {
                if (mid > 0 && nums[mid - 1] < 0) {
                    r = mid;
                } else {
                    r--;
                }
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    /**
     * nearest element: In a sorted array of integers, duplicates allowed find the
     * last occurence of a given target value. if the target
     * does not exist, return the index of the closest value (it could be
     * smaller/largeer than the target)
     * [1, 3, 5, 6, 7, 7, 8, 11, 13, 21] target = 7. ans: 5
     */

    public static int nearestElement(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int closestIndex = 0;
        while (l <= r) {
            int mid = (l + r) / 2;

            // update closest to current mid if applicable
            if ((Math.abs(nums[mid] - target) < Math.abs(nums[closestIndex] - target))
                    || (Math.abs(nums[mid] - target) == Math.abs(nums[closestIndex] - target)
                            && mid > closestIndex)) {
                closestIndex = mid;

            }

            if (nums[mid] <= target) {
                l = mid + 1;

            } else {
                r = mid - 1;
            }
        }
        return closestIndex;
    }

    /**
     * You're given an array that contains each number from 1 to 52 once,
     * representing a deck of playing cards
     * The deck started in order, but it was then "cut". Determine the index at
     * which
     * where you must cut the deck again to return to sorted order.
     * [36, 37, 38 ,... , 50, 51, 52, 1, 2, 3, ..., 33, 34, 35];
     */

}
