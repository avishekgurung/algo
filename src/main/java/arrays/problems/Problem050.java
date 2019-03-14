package arrays.problems;

import java.util.Arrays;

public class Problem050 {

  public static void segregate(int arr[]) {
    int i=0, j=arr.length-1;

    while(i != j) {
      int element = arr[i];
      if(element % 2 == 1) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j--;
      }
      else {
        i++;
      }
    }
  }

  public static void util(int arr[]) {
    System.out.println(Arrays.toString(arr));
    segregate(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  public static void main(String[] args) {
    int arr[] = new int[]{4,2,3,6,7,4,9,1};
    util(arr);

    arr = new int[]{1,2,3,4,5,6,7,8,9};
    util(arr);
  }

}
