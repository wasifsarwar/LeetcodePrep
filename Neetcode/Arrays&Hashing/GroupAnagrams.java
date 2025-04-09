import java.util.*;
import java.util.Map;
import java.util.HashMap;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = { "ant", "eat", "reed", "tea", "deer", "deaf", "tan", "chocolate", "deer" };
        List<List<String>> result = groupAnagrams(strs);
        for (List<String> strList : result) {
            System.out.println(strList);
        }

        // Test the alternative solution
        System.out.println("\nAlternative solution:");
        List<List<String>> result2 = groupAnagramsCharCount(strs);
        for (List<String> strList : result2) {
            System.out.println(strList);
        }
    }

    /**
     * Group anagrams by using sorted strings as keys
     *
     * @param strs array of strings to group
     * @return List of anagram groups
     * 
     *         Time complexity = O(m * n log n) where m is the number of strings, n
     *         is the max string length
     *         Space Complexity = O(m) to store the strings in the HashMap
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Sort the characters to create a key
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Add to corresponding group
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * Alternative approach using character counting
     * 
     * @param strs array of strings to group
     * @return List of anagram groups
     * 
     *         Time complexity = O(m * n) where m is the number of strings, n
     *         is the max string length (more efficient than sorting approach)
     *         Space Complexity = O(m) to store the strings in the HashMap
     */
    public static List<List<String>> groupAnagramsCharCount(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Create character frequency counter
            int[] charCount = new int[26]; // Assuming only lowercase English letters
            for (char c : s.toCharArray()) {
                charCount[c - 'a']++;
            }

            // Convert count array to string key
            // Using a custom format to create a unique key
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                // Only include counts > 0 to make key more compact
                if (charCount[i] > 0) {
                    keyBuilder.append((char) ('a' + i));
                    keyBuilder.append(charCount[i]);
                }
            }
            String key = keyBuilder.toString();

            // Add to corresponding group
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
