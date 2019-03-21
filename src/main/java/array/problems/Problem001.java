package array.problems;

import java.util.Arrays;

public class Problem001 {

  public static void maxVoteWinner(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int len = arr.length;

    for(int i=0; i < arr.length; i++) {
      int index = arr[i] % len;
      arr[index] = arr[index] + len;
    }

    int index = 0, max = -1;
    for(int i=0; i < len; i++) {
      if(arr[i] > max) {
        max = arr[i];
        index = i;
      }
    }

    System.out.println("Candidate " + index + " wins by votes " + (max / len));
  }

  public static void main(String[] args) {
    maxVoteWinner(new int[]{4,1,1,2,4,5,3,2,3,4,5,1,2,1,2,3,4,5,4,4,3,3,2,2,1,3,1,3,5,4,2,3});
  }

}
