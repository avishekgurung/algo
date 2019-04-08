package dp.classical;

public class Problem01 {

  /**
   * Time complexity is 2^n
   * Create a tree structure for every element. We are creating 2 nodes for every element and
   * these node value gets repeated. Giving us 2^n time complexity.
   */
  public static int fibWithNaive(int n) {
    if(n == 0 || n == 1) return n;
    return fibWithNaive(n-1) + fibWithNaive(n-2);
  }

  /**
   * Time and space is O(n)
   */
  public static int fibTopDown(int n, int mm[]) {
    if(n == 0 || n == 1) {
      mm[n] = n;
      return n;
    }
    if(mm[n] > 0) return mm[n];

    int fib = fibTopDown(n - 1, mm) + fibTopDown(n - 2, mm);
    mm[n] = fib;
    return fib;
  }

  /**
   * Time and Space O(n)
   */
  public static int fibBottomUp(int n) {
    int mm[] = new int[n+1];
    mm[0] = 0;
    mm[1] = 1;

    for(int i=2; i <= n; i++) {
      int fib = mm[i-1] + mm[i-2];
      mm[i] = fib;
    }
    return mm[n];
  }

  /**
   * The above problems are all performed to understand DP. However, the optimal soln to solve
   * the problem of Fibonacci series is below.
   * Time O(n) and Space O(1)
   */
  public static int fibWithoutDp(int n) {
    int a = 0, b = 1, sum = 0;
    for(int i=0; i < n - 1; i++) {
      sum = a + b;
      a = b;
      b = sum;
    }
    return sum;
  }

  public static void main(String[] args) {
    int n = 7;
    int[] mm = new int[n+1];

    System.out.println("Fibonacci of " + n + " is " + fibWithNaive(n));

    System.out.println("Fibonacci(Top-Down) of " + n + " is " + fibTopDown(n, mm));

    System.out.println("Fibonacci(Bottom-Up) of " + n + " is " + fibBottomUp(n));

    System.out.println("Fibonacci(Optimal) of " + n + " is " + fibWithoutDp(n));
  }
}
