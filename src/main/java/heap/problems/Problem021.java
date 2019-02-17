package heap.problems;

import java.util.Arrays;

public class Problem021 {



  public static boolean isMinHeap(int level[]) {
    for(int i=0; i < level.length; i++) {

      int data = level[i];
      int leftIndex = 2 * i + 1;
      int rightIndex = 2 * i + 2;

      if(leftIndex < level.length) {
        int leftChild = level[leftIndex];
        if(data > leftChild) return false;
      }

      if(rightIndex < level.length) {
        int rightChild = level[rightIndex];
        if(data > rightChild) return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int level[] = new int[]{10, 15, 14, 25, 30};
    System.out.println(Arrays.toString(level));
    System.out.println("Is Min Heap: " + isMinHeap(level));
    System.out.println();

    level = new int[]{30, 56, 22, 49, 30, 51, 2, 67};
    System.out.println(Arrays.toString(level));
    System.out.println("Is Min Heap: " + isMinHeap(level));
    System.out.println();
  }
}
