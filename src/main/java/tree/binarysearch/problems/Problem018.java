package tree.binarysearch.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem018 {
  /**
   * The naive way its to create tree from pre-order and in-order traversal. As sorting
   * the pre-order is the in-order series.
   * This will take O(n2). And if we use lookup map then it takes O(n) time and space.
   *
   * The efficient way to solve it in O(n) is below.
   *
   * If a pre-order traversal of a BST is give, then remember to solve that problem by
   * considering the range.
   */

  private static int preIndex = 0;
  public static Node create(int[] pre, int min, int max) {
    if(preIndex >= pre.length) return null;
    Node node = null;
    int ele = pre[preIndex];
    if(min < ele && ele < max) {
      preIndex++;
      node = new Node(null, ele, null);
      node.left = create(pre, min, ele);
      node.right = create(pre, ele, max);
    }
    return node;
  }

  public static void main(String[] args) {
    int[] pre = new int[]{4,2,1,3,6,5,7};
    Node root = create(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
    BinarySearchTree.display(root);
  }

}
