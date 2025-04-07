package TwoPointers;

public class isValidPalindromeII {

    public static void main(String[] args) {

        String carRace = "race a car";
        String panama = "A man, a plan, a canal: Panama";

        System.out.println("carRace palindrome: " + validPalindromeII(carRace));
        System.out.println("panama palindrome: " + validPalindromeII(panama));
    }

    public static boolean validPalindromeII(String s) {

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
