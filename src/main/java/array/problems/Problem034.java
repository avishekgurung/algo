package array.problems;

import java.util.Arrays;

public class Problem034 {

  public static int getSingleOccurrenceNumber(int arr[]) {
    int size = arr.length;
    for(int i=0; i < size; i++) {
      int index = arr[i] % size;
      arr[index] = arr[index] + size;
    }

    for(int i=0; i < size; i++) {
      if(arr[i]/size == 1) return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    int arr[] = new int[] {3,2,3,2,1,2,3};
    System.out.println(Arrays.toString(arr));
    System.out.println("Single occurrence: " + getSingleOccurrenceNumber(arr));
  }

}
