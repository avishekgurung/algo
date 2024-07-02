package misc;

/**
 * Find the number of bits for a given number. Let it be 'k'.
 * So the answer will be 2^k.
 */
public class Problem010 {

  public static void highestPowerOf2(int n) {
    System.out.print("The highest power of 2 less than or equal to " + n + " is ");
    int k = 0;
    while(n != 0) {
      n = n / 2;
      k++;
    }

    System.out.println(Math.pow(2, k - 1) + "\n");
  }

  public static void main(String[] args) {
    highestPowerOf2(10);
    highestPowerOf2(19);
    highestPowerOf2(32);
  }

}
