package dp.recursive;

public class Problem002 {

    /**
     * The time complexity of this problem is 3^n as we are making three recursive calls. The space complexity is O(n)
     * due to recursion.
     */
    private int recursion(int step, int target) {
        if(step == target) return 1; // Reached the destination
        if(step > target) return 0; // False case
        int step1 = recursion(step + 1, target);
        int step2 = recursion(step + 2, target);
        int step3 = recursion(step + 3, target);
        return step1 + step2 + step3;
    }

    /**
     * We can also think that we are starting from the end backwards. When we reach 0, then we have reached the
     * destination.
     */
    private int recursion1(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(n == 2) return 2;
        return recursion1(n-1) + recursion1(n-2) + recursion1(n-3);
    }

    private int bottomUp(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        return dp[n];
    }
    private void util() {
        int n = 6;
        System.out.println(recursion(0, n));
        System.out.println(recursion1(n));
        System.out.println(bottomUp(n));
    }

    public static void main(String[] args) {
        new Problem002().util();
    }
}
