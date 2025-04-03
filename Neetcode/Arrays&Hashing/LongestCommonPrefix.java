public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flowchart" };
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        // we use the first string in this array to keep track of length
        for (int i = 0; i < strs[0].length(); i++) {
            for (String s : strs) {
                // if i matches the length of a string (that is going to be out of bounds)
                // or if character at i for a string doesn't match the character at i for first
                // string
                // return the subset of that string from 0 to i
                if (i == s.length() || s.charAt(i) != strs[0].charAt(i)) {
                    return s.substring(0, i);
                }
            }
        }
        return strs[0];

    }
}
