/**
 * This versions of the problem has a complexity time and space of O(n^2) and O(n) respectively. The reasons of why the complexity is n^2 is because in each iteration i, the algorithm needs to compute the maximum of the former results k stored in the hashtable (array) for each k < i.
 * 
 * There is a better version of this problem, by calculating only two stored values. I'll go further with this later.
 * 
 * @author      Rubén Barragán
 * @version     1.0
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(maxOfA(8));
    }

    /** 
     * Main function to print the maximum of As in the textbox. It basically,
     * uses bottom-up dynamic programming and iterates until it reaches the
     * n value. At each iteration, it computes the maximum of the stored
     * values in the hashtable, meaning that it does not need to compute 
     * the values from scratch.
     *
     * @param n         number of operations that will be executed 
     *                  to obtain the max of As.
     * @return          the maximum of As that can be printed.
     * @since           1.0
     */
    public static int maxOfA(int n) {
        if (n <= 6) {
            return n;
        }
        int[] cache = new int[n + 1];
        for (int i = 1; i <= 6; i++) {
            cache[i] = i;
        }
        for (int i = 7; i <= n; i++) {
            int max = 0;
            for (int j = 2; j < i - 3; j++) {
                max = Math.max(max, cache[i - j - 1] * j);
            }
            cache[i] = max;
        }
        return cache[n];
    }
}