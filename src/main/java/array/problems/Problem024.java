package array.problems;

import java.util.Arrays;

public class Problem024 {

  public static void searchIn2DAscendingArray(int arr[][], int element) {

    int i = arr.length-1, j = 0;

    while(i >= 0 && j >= 0) {
      int origin = arr[i][j];
      if(origin == element) {
        System.out.println("Element " +  element +" found at (" + j + "," + i + ")");
        break;
      }
      else if(element < origin) {
        i--;
      }
      else if(element > origin) {
        j++;
      }
    }
  }

  public static void printArr(int arr[][]) {
    for(int i=0; i < arr.length; i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
  }

  public static void main(String[] args) {
    int arr[][] = new int[][]{
        {2,5,8,20},
        {6,7,10,25},
        {9,11,15,30},
        {13,14,16,31}
    };
    printArr(arr);

    searchIn2DAscendingArray(arr, 10);
    searchIn2DAscendingArray(arr, 16);
    searchIn2DAscendingArray(arr, 13);
    searchIn2DAscendingArray(arr, 31);
  }

}
