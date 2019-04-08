package dp.classical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Ref: https://www.youtube.com/watch?v=CE2b_-XfVDk&t=147s
 */
public class Problem03 {

  public static void longestIncreasingSubSequence(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int n = arr.length;
    int[] lcs = new int[n]; //stores the longest increasing subsequence till i

    //For every element, the minimum increasing subsequence is 1
    for(int i=0; i < n; i++) lcs[i] = 1;

    for(int i=1; i < n; i++) {
      for(int j=0; j < i; j++) {
        if(arr[j] < arr[i]) {
          int lcs_at_j = lcs[j];
          lcs[i] = Math.max(lcs_at_j + 1, lcs[i]);
        }
      }
    }

    //result computation
    int largest_element_index = 0;
    List<Integer> lcs_elements = new ArrayList<Integer>();

    //Just find the maximum element
    for(int i=1; i < n; i++) {
      if(lcs[i] > lcs[largest_element_index]) {
        largest_element_index = i;
      }
    }

    //find all the elements which form the lcs
    int largest = lcs[largest_element_index];

    for(int j=largest_element_index; j >=0; j--) {
      if(lcs[j] == largest) {
        lcs_elements.add(arr[j]);
        largest--;
      }
    }



    Collections.reverse(lcs_elements);

    System.out.println("The longest increasing subsequence has length " +
        lcs[largest_element_index]);
    System.out.println("The subsequence is " + lcs_elements);
    System.out.println();
  }


  public static void main(String[] args) {
    longestIncreasingSubSequence(new int[]{4,3,6,4,8,6,7});
    longestIncreasingSubSequence(new int[]{5,2,3,1,6});
    longestIncreasingSubSequence(new int[]{2,8,5,6,3,7,4});
  }

}
