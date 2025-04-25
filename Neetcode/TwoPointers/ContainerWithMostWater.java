package TwoPointers;

public class ContainerWithMostWater {
    //Brute force solution
    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    //Two pointer solution
    public int maxAreaTwoPointers(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            /**
             * width = right - left
             * height = min(height[left], height[right])
             */
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            // we increment left if we have a greater height on the right
            // we increment towards whichever position has greater height
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

