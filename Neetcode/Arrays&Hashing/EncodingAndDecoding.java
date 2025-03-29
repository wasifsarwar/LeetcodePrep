import java.util.*;

public class EncodingAndDecoding {

    public static void main(String[] args) {
        // Test encoding and decoding
        List<String> original = Arrays.asList("Hello", "World", "Coding", "is", "fun");
        System.out.println("Original strings: " + original);

        String encoded = encode(original);
        System.out.println("Encoded string: " + encoded);

        List<String> decoded = decodeSimple(encoded);
        System.out.println("Decoded strings: " + decoded);

        // Verify if the decoded list matches the original
        System.out.println("Match: " + original.equals(decoded));
    }

    /**
     * Encodes a list of strings into a single string.
     * Format: [length]#[string][length]#[string]...
     * 
     * @param strs list of strings to encode
     * @return the encoded string
     */
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder(); // More efficient than String concatenation

        for (String s : strs) {
            // For each string, append its length, a # delimiter, and then the string itself
            // Example: "Hello" becomes "5#Hello"
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public static List<String> decodeSimple(String s) {
        List<String> result = new ArrayList<>(); // Initialize result list to store decoded strings
        int i = 0; // Starting position in the encoded string
        while (i < s.length()) { // Continue until we've processed the entire string
            int delimiterPos = s.indexOf("#", i); // Find the position of the next delimiter (#) starting from position
                                                  // i
            int length = Integer.parseInt(s.substring(i, delimiterPos)); // Extract and parse the length value before
                                                                         // the #

            String str = s.substring(delimiterPos + 1, delimiterPos + 1 + length); // Extract the actual string based on
                                                                                   // its length
            result.add(str); // Add the extracted string to our result list

            // Update i to move past the current string to the start of the next length
            // indicator
            i = delimiterPos + 1 + length;
        }
        return result; // Return the list of decoded strings
    }

    /**
     * Decodes an encoded string back into a list of strings.
     * The encoded format is: [length]#[string][length]#[string]...
     * Example: "5#Hello5#World" -> ["Hello", "World"]
     * 
     * @param str the encoded string
     * @return the decoded list of strings
     */
    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>(); // Will hold our decoded strings
        int i = 0; // Current position in the encoded string

        // Process the entire encoded string
        while (i < str.length()) {
            // STEP 1: Find the # delimiter
            int j = i; // Start from current position
            while (j < str.length() && str.charAt(j) != '#') {
                j++; // Move forward until we find #
            }

            // STEP 2: Extract the length
            // Convert the substring from i to j (exclusive) to an integer
            // Example: in "5#Hello", this extracts "5" and converts to int 5
            int length = Integer.parseInt(str.substring(i, j));

            // STEP 3: Extract the actual string using the length
            // Start after the # (position j+1)
            // End at j+1+length (the exact number of characters)
            // Example: in "5#Hello", this extracts "Hello" (5 characters after #)
            String s = str.substring(j + 1, j + 1 + length);

            // STEP 4: Add the extracted string to our result
            result.add(s);

            // STEP 5: Move to the start of the next encoded string
            // Skip past the current string to where the next length should be
            // Example: After processing "5#Hello" in "5#Hello5#World", i becomes 7
            i = j + 1 + length;
        }

        return result;
    }

}