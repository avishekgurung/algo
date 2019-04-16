package practice;

import java.util.Arrays;

public class LabTest {

  static int countSetBitsUtil( int x)
  {
    if (x <= 0)
      return 0;
    return (x % 2 == 0 ? 0 : 1) +
        countSetBitsUtil(x / 2);
  }

  public static void main(String[] args) {
    //System.out.println(countSetBitsUtil(1));
    //System.out.println(countSetBitsUtil(2));
    System.out.println(countSetBitsUtil(5));
  }

}
