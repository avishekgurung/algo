package dp.recursive;

import java.util.HashMap;
import java.util.Map;

public class Problem001 {

    /**
     * This function makes a 2 recursion calls, so the time complexity = 2^n
     * and the space complexity is O(n) due to recursion.
     * @param n
     * @return
     */
    private int recursion(int n) {
        if(n == 0 || n == 1) return n;
        return recursion(n-1) + recursion(n-2);
    }

    /**
     * The time and space complexity of this function is O(n).
     * @param n
     * @param cache
     * @return
     */
    private int recursionWithDp(int n, Map<Integer, Integer> cache) {
        if(n == 0 || n == 1) return n;
        if(cache.containsKey(n)) return cache.get(n);
        int result =  recursion(n-1) + recursion(n-2);
        cache.put(n, result);
        return result;
    }

    /**
     * The time and space complexity of this function is O(n).
     * @param n
     * @return
     */
    private int bottomUp(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }

    private void util() {
        int n = 6;
        System.out.println(recursion(n));
        System.out.println(recursionWithDp(n, new HashMap<>()));
        System.out.println(bottomUp(n));
    }

    public static void main(String[] args) {
        new Problem001().util();
    }

}
