import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class ValidAnagrams {

    public static void main(String[] args) {
        String s = "cat";
        String t = "tac";

        System.out.println("validAnagram for " + s + " " + t + " :" + validAnagrams(s, t));
        System.out.println("isAnagram for " + s + " " + t + ": " + isAnagram(s, t));

        String p = "pasa";
        String y = "asapo";
        System.out.println("validAnagram for " + p + " " + y + " :" + validAnagrams(p, y));
        System.out.println("isAnagram for " + p + " " + y + ": " + isAnagram(p, y));

        String x = "xx";
        String u = "x";
        System.out.println("validAnagram for " + x + " " + u + " :" + validAnagrams(x, u));
        System.out.println("isAnagram for " + x + " " + u + ": " + isAnagram(x, u));
    }

    /*
     * Time complexity: O(nlog⁡n + mlog⁡m)
     * Space complexity: O(1) or O(n+m) depending on the sorting algorithm.
     */
    public static boolean validAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        for (int i = 0; i < s1Array.length; i++) {
            if (s1Array[i] != s2Array[i]) {
                return false;
            }
        }
        return true;

    }

    /**
     * Using HashMap
     * Time complexity O(m + n)
     * Space Complexity O(1) as there's only 26 characters in english
     */

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
        }

        return s1Map.equals(s2Map);

    }
}
