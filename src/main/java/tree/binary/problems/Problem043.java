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
    BinaryTree.display(myLogic(pre, post ));
  }

  public static Node myLogic(int[] pre, int post[]) {
    //reverse post order
    int len = post.length;
    for(int i=0; i < (int)(post.length/2);i++) {
      int temp = post[i];
      post[i] = post[len-1-i];
      post[len-1-i] = temp;
    }

    //create post order lookup
    Map<Integer, Integer> lookUp = new HashMap<Integer, Integer>();
    for(int i=0; i < post.length; i++) {
      lookUp.put(post[i],i);
    }

    //Create a set to store the traversed elements
    Set<Integer> traversed = new HashSet<Integer>();

    Node node = new Node(null, pre[0], null);
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(node);
    Node root = node;
    int i = 1;
    while(!queue.isEmpty()) {
      node = queue.remove();
      int data = node.data;

      int leftIndex = i+1;
      int rightIndex = lookUp.get(data) + 1;

      if(leftIndex < len && rightIndex < len) {
        int leftData = pre[leftIndex];
        int rightData = post[rightIndex];
        if(!traversed.contains(leftData) && !traversed.contains(rightData)) {
          node.left = new Node(null, leftData, null);
          node.right = new Node(null, rightData, null);
          traversed.add(leftData);
          traversed.add(rightData);
          queue.add(node.left);
          queue.add(node.right);
        }
      }
      i++;
    }
    return root;
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
