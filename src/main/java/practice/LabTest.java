package practice;

import java.util.*;

public class LabTest {

  public static void main(String[] args) {
    System.out.println(count(new int[100000]));

  }

  private static boolean isPrime(int n) {
    for(int i=2; i < n/2; i++) {
      if(n%i == 0) return false;
    }
    return true;
  }

  private static int count(int arr[]) {
    int c = 0;
    int last = arr.length - 1;
    while(last != 0) {
      int i=0, j=last;
      while(i < j) {
        c++;
        i++;
        j--;
        if (i >= j) {
          last = j;
        }
      }
    }
    return c;
  }
}
