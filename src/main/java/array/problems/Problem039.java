package array.problems;

import java.util.Arrays;

/**
 * Perform a simple operation as specified when arr[i] = arr[i+1]
 * find the first index of 0
 * find the first index of valid element after first index of 0
 * iterate and when a valid element is encountered, keep swapping.
 */

public class Problem039 {
  
  public static void rearrange0s(int arr[]) {
    System.out.println(Arrays.toString(arr));
    for(int i=0; i < arr.length - 1; i++) {
      if(arr[i] == arr[i+1]) {
        arr[i] = arr[i] * 2;
        arr[i+1] = 0;
      }
    }
    
    int zero_index = -1;
    int valid_index = 0;
    
    for(int i=0; i < arr.length; i++) {
      if(arr[i] == 0) {
        zero_index = i;
        break;
      }
    }
    
    if(zero_index == -1 || zero_index == arr.length -1) {
      //The array is full of 0 or with no zero.
      return;
    }
    
    for(int i=zero_index + 1; i < arr.length; i++) {
      if(arr[i] != 0) {
        valid_index = i;
        break;
      }
    }
    
    while(valid_index < arr.length) {
      if(arr[valid_index] != 0) {
        int temp = arr[valid_index];
        arr[valid_index] = arr[zero_index];
        arr[zero_index] = temp;
        zero_index++;
      }
      valid_index++;
    }

    System.out.println(Arrays.toString(arr));
    System.out.println();

    //This can be done in one iteration as well.
  }

  public static void main(String[] args) {
    rearrange0s(new int[]{2, 2, 0, 4, 0, 8});
    rearrange0s(new int[]{0, 2, 2, 2, 0, 6, 6, 0, 0, 8,0,0,0,8,8});
  }
  
}
