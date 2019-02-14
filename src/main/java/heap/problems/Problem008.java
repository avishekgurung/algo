package heap.problems;

import java.util.Arrays;

public class Problem008 {

  private static int getLeftChild(int i) {
    return 2 * i + 1;
  }

  private static int getRightChild(int i) {
    return 2 * i + 2;
  }

  public static boolean check(int arr[]) {
    for(int i=0; i < arr.length; i++) {
      int node = arr[i];
      int leftChild = getLeftChild(i);
      int rightChild = getRightChild(i);

      if(leftChild < arr.length) {
        int leftNode = arr[leftChild];
        if(node < leftNode) return false;
      }

      if(rightChild < arr.length) {
        int rightNode = arr[rightChild];
        if(node < rightNode) return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int arr[] = new int[]{90, 15, 10, 7, 12, 2};
    System.out.print(Arrays.toString(arr));
    System.out.println("\t" + check(arr));

    arr = new int[]{9, 15, 10, 7, 12, 11};
    System.out.print(Arrays.toString(arr));
    System.out.println("\t" + check(arr));
  }

}

/**
 *
 *
 *
 */
