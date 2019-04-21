package array.problems;

import java.util.Arrays;

public class Problem010 {

  public static int getMajorityElement(int arr[]) {
    int count = 1; int element = arr[0];
    for(int i=1; i < arr.length; i++) {
      if(arr[i] == element) {
        count++;
      }
      else {
        count--;
        if(count == 0) {
          count = 1;
          element = arr[i];
        }
      }
    }
    System.out.println(Arrays.toString(arr));
    System.out.println(element);
    System.out.println();
    return element;
  }

  public static void main(String[] args) {
    int arr[] = new int[] {1,2,2};
    getMajorityElement(arr);

    arr = new int[]{2,1,2,3,2};
    getMajorityElement(arr);

    arr = new int[]{2,3,4,2,1};
    getMajorityElement(arr);
  }

}
