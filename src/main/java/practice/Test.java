package practice;

import java.util.*;

public class Test {

  public static void main(String[] args) {

    int arr[] = new int[]{1,2,3,4,5};
    System.out.println(Arrays.toString(arr));
    int last = arr.length - 1;

    while(last != 0) {
      int i=0, j=last;
      while(i < j) {
        System.out.println("("+arr[i]+","+arr[j]+")");
        i++;
        j--;
        if(i >= j) last = j;
      }
    }



  }

  //private static int combine()

}
