package array.problems;

public class Problem035 {
  /**
   * If we observe a factorial number pattern, then a number greater than 5 will start having 0
   * at their end. Eg,
   * 5! has one 0.
   * 6! has one 0.
   * 9! has one 0.
   * 10! has two 0s.
   * 15! has three 0s.
   * This just means that any number when divided by 5 gives us the number of trailing 0s.
   *
   */

  public static void main(String[] args) {
    System.out.println(getTrailingZeros(5));
    System.out.println(getTrailingZeros(9));
    System.out.println(getTrailingZeros(10));
  }

  public static int getTrailingZeros(int n) {
    return n/5;
  }
}
