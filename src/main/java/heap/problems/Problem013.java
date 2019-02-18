package heap.problems;

import java.util.Arrays;

public class Problem013 {

  /**
   * This does not work.
   * @param a
   * @param b
   * @param k
   */
  private static void kMaxSumCombinations(int a[], int b[], int k) {
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));
    sort(a);
    sort(b);

    int i = 0, j = 0;
    while(k != 0) {
      System.out.println(a[i] + " + " + b[j] + " = " + (a[i] + b[j]));
      if(i + 1 >= a.length || j + 1 >= a.length) break;
      int sum1 = a[i] + b[j+1];
      int sum2 = a[i+1] + b[j];
      if(sum1 > sum2)j++;
      else i++;
      k--;
    }
    System.out.println();
  }

  /**
   * This method should use some efficient sort algo with O(nlogn)
   * @param arr
   */
  private static void sort(int arr[]) {
    Arrays.sort(arr);
    for(int i=0; i < arr.length/2;i++) {
      int temp = arr[i];
      arr[i] = arr[arr.length-i-1];
      arr[arr.length-i-1] = temp;
    }
  }

  public static void main(String[] args) {
    int a[] = new int[]{3,2};
    int b[] = new int[]{1,4};
    int k = 2;
    kMaxSumCombinations(a,b,k);

    k = 10;
    kMaxSumCombinations(a,b,k);

    a = new int[]{1,4,5,2};
    b = new int[]{3,0,9,7};
    k = 2;
    kMaxSumCombinations(a,b,k);

    a = new int[]{1,4,5,2};
    b = new int[]{3,0,9,7};
    k = 3;
    kMaxSumCombinations(a,b,k);

  }

}
