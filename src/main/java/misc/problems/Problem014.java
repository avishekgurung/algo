package misc.problems;

public class Problem014 {

  public static void replace0With5(int n) {
    System.out.print("Input: " + n);
    int multiplier = 1;
    int sum = 0;

    while(n != 0) {
      int remainder = n % 10;
      n = n / 10;
      if(remainder == 0) remainder = 5;
      sum = remainder * multiplier + sum;
      multiplier = multiplier * 10;
    }
    System.out.println(", Output: " + sum);
  }

  public static void main(String[] args) {
    replace0With5(105);
    replace0With5(1020);
    replace0With5(100890);
  }

}
