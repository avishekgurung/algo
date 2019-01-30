package tree.binary.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

/**
 * We cannot create a BT from any pre-order and post-order traversal as we need to have inorder
 * traversal. But we can create Full Binary Tree from these two traversals.
 */
public class Problem043 {

  private static int preIndex = 0;
  private static Node create(int pre[], int left, int right,
      Map<Integer, Integer> postLookUp) {
    if(left > right || preIndex >= pre.length) return null;
    int data = pre[preIndex];
    preIndex++;
    Node node = new Node(null, data, null);
    if(left == right || preIndex >= pre.length) return node;
    int postIndex = postLookUp.get(pre[preIndex]);
    if(postIndex < right) { //important
      node.left = create(pre, left, postIndex, postLookUp);
      node.right = create(pre,postIndex + 1, right, postLookUp);
    }
    return node;
  }

  private static Map<Integer, Integer> createLookUp(int arr[]) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < arr.length; i++)
      map.put(arr[i], i);
    return map;
  }

  public static Node createUtil(int pre[], int post[]) {
    preIndex = 0;
    Map<Integer, Integer> postLookUp = createLookUp(post);
    Node node = create(pre, 0, pre.length-1, postLookUp);
    return node;
  }

  public static void main(String[] args) {
    int pre[] = new int[] {1, 2, 4, 5, 3, 6, 7};
    int post[] = new int[] {4, 5, 2, 6, 7, 3, 1};
    BinaryTree.display(createUtil(pre, post));
  }
}
/**
 *
 * The solution is as follows:
 *
 * The first element of a pre order is always a root. Here 1 is the root.
 * Now the next element of 1 is 2. So we use 2 to find the left and right subtree of 1.
 * The elements in post order before 2 is left subtree of 1 and the elements after 2 is the
 * right subtree of 1.
 *
 * Likewise, for 2, we use 4 to find the left and right subtree.
 *
 * There are several edge conditions which has to fixed though.
 *
 *
 */
