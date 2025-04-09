package TwoPointers;

public class isValidPalindrome {
    public static void main(String[] args) {
        String carRace = "race a car";
        String panama = "A man, a plan, a canal: Panama";

        System.out.println("carRace palindrome: " + validPalindrome(carRace));
        System.out.println("panama palindrome: " + validPalindrome(panama));
    }

    public static boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {

            /**
             * check for symbols and whitespace
             */
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }

            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
