package array.problems;

import java.util.Arrays;

public class Problem042 {

  public static void rearrangeTwoArray(int arr[], int index[]) {
    System.out.println(Arrays.toString(arr));
    for(int i=0; i < arr.length; i++) {
      while(index[i] != i) {
        int oldTargetI = index[index[i]];
        int oldTargetE = arr[index[i]];

        arr[index[i]] = arr[i];
        index[index[i]] = index[i];

        index[i] = oldTargetI;
        arr[i] = oldTargetE;
      }
    }
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  public static void main(String[] args) {
    rearrangeTwoArray(new int[]{10, 11, 12}, new int[]{1, 0, 2});
  }

}
