package heap.problems;

import java.util.Arrays;

public class Problem020 {

  static int count = 0;

  private static int getLeft(int i) {
    int left = 2 * i + 1;
    return left >= count ? -1 : left;
  }

  private static int getRight(int i) {
    int right = 2 * i + 2;
    return right >= count ? -1 : right;
  }

  private static void percolateDown(int i, int arr[]) {
    int left = getLeft(i);
    int right = getRight(i);
    if(left == -1 && right == -1) return;

    int max;

    if(left != -1 && arr[left] > arr[i]) {
      max = left;
    }
    else {
      max = i;
    }

    if(right != -1 && arr[right] > arr[max]) {
      max = right;
    }

    if(max != i) {
      int temp = arr[i];
      arr[i] = arr[max];
      arr[max] = temp;
    }
    else {
      return;
    }
    percolateDown(max, arr);
  }

  public static int[] convertMinToMaxHeap(int min[]) {
    count = min.length-1;
    for(int i=min.length/2; i >=0 ;i--) {
      percolateDown(i, min);
    }
    return min;
  }

  private static void insert(int data, int arr[]) {
    int i = count;
    while(i > 0 && data > arr[(i-1)/2]) {
      arr[i] = arr[(i-1)/2];
      i = (i-1)/2;
    }
    arr[i] = data;
    count++;
  }


  public static void main(String[] args) {
    int minHeap[] = new int[]{3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
    System.out.println(Arrays.toString(minHeap));
    int maxHeap[] = convertMinToMaxHeap(minHeap);
    System.out.println(Arrays.toString(maxHeap));
  }

  /**
   * The solution might look like O(nlogn) but building heap takes O(n).
   *
   * If we are allowed to use.
   *
   */

}
