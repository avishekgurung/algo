package practice;

import java.util.*;

public class Test {

  public static void main(String[] args) {
    int[][] arr = new int[][]{{1,2},{1,2,},{1,2}};
    System.out.println(arr.length);
    System.out.println(arr[0].length);

  }

  private static boolean isPrime(int n) {
    for(int i=2; i < n/2; i++) {
      if(n%i == 0) return false;
    }
    return true;
  }
}
