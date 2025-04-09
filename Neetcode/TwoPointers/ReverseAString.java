package TwoPointers;

public class ReverseAString {

    public static void reverseAString(char[] c) {
        int l = 0;
        int r = c.length - 1;
        while (l < r) {
            char tempL = c[l];
            char tempR = c[r];
            c[l] = tempR;
            c[r] = tempL;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] c = { 'a', 'e', 'i', 'o', 'u' };
        reverseAString(c);
        System.out.println(new String(c));
    }
}
