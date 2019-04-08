package dp.general;

public class Problem004 {

  /**
   * function that gives us the ways an nth person can be paired.
   * Explanation.
   * Lets consider a nth person. This person can either remain single or pair up with other.
   *
   * case 1. Remain single.
   * If this person remains single then the remaining n-1 people can be paired in f(n-1)
   * So the first term is 1*f(n-1)
   *
   * case 2. Pair up
   * If this person pairs up then he can pair up with n-1 people. And the remaining n-2 people
   * can pair up in f(n-2) ways.
   * So the second term (n-1) * f(n-2).
   *
   * Add both the terms.
   */
  public static int pair(int n) {
    if(n == 0 || n == 1 || n == 2) return n;

    return pair(n - 1) +  (n-1) * pair(n - 2);
  }

  /**
   * This can be easily solved to DP in recursion or in iteration.
   * @param args
   */

  public static void main(String[] args) {
    System.out.println(pair(3));
  }
}
