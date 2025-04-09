public class Recursion {
    

    public static void main(String[] args) {
        System.out.println("factorial of " + 10  + " " + factorial(10));
        System.out.println("fibonacci number of " + 5 + " " + fibonacci(5));
    }

    public static int factorial(int n) {
        // base case
        if (n == 1) return 1;
        return n * factorial(n-1);
    }

    /**
     * The big O for this algorithm is O(2 ^ n)
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
