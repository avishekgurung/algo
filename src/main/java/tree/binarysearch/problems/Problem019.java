package tree.binarysearch.problems;

public class Problem019 {
  /**
   * This can be solved by creating a BST from pre-order and then performing post-order.
   * But it can be solved using the same approach, without creating a tree.
   */

  private static int preIndex = 0;

  public static void printPostOrder(int[] pre, int min, int max) {
    if(preIndex >= pre.length) return;
    int ele = pre[preIndex];
    if(min < ele && ele < max) {
      preIndex++;
      printPostOrder(pre, min, ele);
      printPostOrder(pre, ele, max);
      System.out.print(ele + " ");
    }
  }

  public static void main(String[] args) {
    int[] pre = new int[]{4,2,1,3,6,5,7};
    printPostOrder(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
}
