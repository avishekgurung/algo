package array.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem057 {

  public static void subsetsWithProductLessThanK(int arr[], int k) {
    Arrays.sort(arr);
    Set<String> set = new HashSet<String>();

    for(int i=0; i < arr.length-1; i++) {
      set.add(arr[i] + "");
      if(i == arr.length-2) {
        set.add(arr[i+1] + "");
      }
      for(int j=i+1; j < arr.length; j++) {
        int prod = arr[i] * arr[j];
        if(prod <= k) set.add("("+arr[i] + "," + arr[j]+")");
      }
    }
    System.out.println(set);
  }

  public static void main(String[] args) {
    subsetsWithProductLessThanK(new int[]{2, 4, 5, 3}, 12);
  }
}
