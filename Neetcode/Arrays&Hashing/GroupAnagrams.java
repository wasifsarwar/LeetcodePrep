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
     * @param strs
     * @return
     * Time complexity = O( m * n) m is the number of strings, n is the length of the longest string
     * Space Complexity = O(m) to store m number of strings in HashMap
     */

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();

        for (String s: strs) {
            int[] charCount = new int[26];
            for (char c: s.toCharArray()) {
                
                charCount[c - 'a']++;
            }
            String key = Arrays.toString(charCount);
            strMap.putIfAbsent(key, new ArrayList<>());
            strMap.get(key).add(s);
        }
        return new ArrayList<>(strMap.values());
    }
}
