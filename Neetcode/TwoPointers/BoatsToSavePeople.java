package TwoPointers;

import java.util.*;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int left = 0;
        int right = people.length - 1;
        // Single Element: If there's a single person left (when left == right), they
        // still need to be processed, which is why <= is used.
        while (left <= right) {
            int remainingWeight = limit - people[right];
            right--;
            count++;
            // Checks if the current lightest person (pointed to by left) can fit in the
            // boat with the current heaviest person (pointed to by right).
            if (left <= right && remainingWeight >= people[left]) {
                left++;
            }
        }
        return count;
    }
}
