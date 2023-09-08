package tree.binary.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem030 {

  private static Map<Integer, Integer> lookup = new HashMap<Integer, Integer>();
  private static int preIndex = 0;

  public static void printPostOrder(int[] pre, int left, int right) {
    if(left > right) return;
    int ele = pre[preIndex++];
    int inorderIndex = lookup.get(ele);
    printPostOrder(pre, left, inorderIndex-1);
    printPostOrder(pre, inorderIndex+1, right);
    System.out.print(ele + " ");
  }

  public static void main(String[] args) {
    int[] inorder = new int[]{4,2,5,1,3,6};
    int[] preorder = new int[]{1,2,4,5,3,6};
    for(int i=0; i < inorder.length; i++) {
      lookup.put(inorder[i], i);
    }

    printPostOrder(preorder, 0, preorder.length-1);
  }

  /**
   * The solution is same as creating a tree from preorder and inorder, just that we will be printing the element
   * rather than creating a tree.
   */

}
