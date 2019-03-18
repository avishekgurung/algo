package array.problems;

import java.util.Arrays;

public class Problem010 {

  public static int getMajorityElement(int arr[]) {
    int count = 0; int element = -1;

    for(int i=0; i < arr.length; i++) {
      if(count == 0) {
        element = arr[i];
      }
      else if(element == arr[i]) {
        count++;
      }
      else {
        count--;
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
  }

}
