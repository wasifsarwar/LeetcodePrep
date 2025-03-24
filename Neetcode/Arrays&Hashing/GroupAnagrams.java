import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args)  {
        String[] strs = {"ant", "eat", "reed", "tea", "deer", "deaf", "tan", "chocolate", "deer"};
        List<List<String>> result = groupAnagrams(strs);
        for (List<String> strList: result) {
            System.out.println(strList);
        }
    }

    /**
     * 
     * Key Insight: Instead of sorting characters (which would be O(k log k) for each string), 
     * this approach uses a character count array as a "signature" for each anagram group.
     *
     * @param strs
     * @return
     * Time complexity = O( m * n) m is the number of strings, n is the length of the longest string
     * Space Complexity = O(m) to store m number of strings in HashMap
     */

    public static List<List<String>> groupAnagrams(String[] strs) {
        /**
         * Keys: String representations of character frequency arrays
         * Values: Lists of strings that share the same character frequency pattern
         */
        Map<String, List<String>> strMap = new HashMap<>();

        for (String s: strs) {
            int[] charCount = new int[26];
            for (char c: s.toCharArray()) {
               //Create character frequency counter:
                charCount[c - 'a']++;
            }
            // Convert count array to string key:
            String key = Arrays.toString(charCount);
            
            /**
             * If this signature hasn't been seen, create a new list
             * Add the current string to its anagram group
             */
             
            // Add string to appropriate group:
            strMap.putIfAbsent(key, new ArrayList<>());
            strMap.get(key).add(s);
        }
        return new ArrayList<>(strMap.values());
    }
}
