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
    getMajorityElement1(arr);

    arr = new int[]{2,1,2,3,2};
    getMajorityElement1(arr);

    arr = new int[]{2,3,4,2,1};
    getMajorityElement1(arr);
  }

  /**
   * One simple logic, we can think of is that, if any element in an array is occurring more than n/2, then this condition can be true.
   * arr[i] = arr[i+1] || arr[i] == arr[i+2].
   *
   * In the above example, for this array {2,3,4,2,1}, there is no repeating element. Because repeating element has to be MORE then n/2,
   * if its frequency should be more than 2.
   *
   */

  public static void getMajorityElement1(int arr[]) {
    int majorityElement = -1;
    for(int i=0; i < arr.length; i++) {
      if((i+1) < arr.length && arr[i] == arr[i+1]) {
        majorityElement =  arr[i];
        break;
      }

      if((i+2) < arr.length && arr[i] == arr[i+2]) {
        majorityElement = arr[i];
        break;
      }
    }
    System.out.println(Arrays.toString(arr));
    System.out.println(majorityElement);
    System.out.println();
  }

}
