package tree.binary.problems;

import java.util.HashMap;
import java.util.Map;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem028 {

  static int inorder[];
  static int postOrderIndex;
  static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

  public static Node createTree(int[] inorder, int[] postOrder) {
    postOrderIndex = 0;
    Problem028.inorder = inorder;

    for(int i=0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    postOrder = reverse(postOrder);
    Node root = create(postOrder, 0, postOrder.length-1);
    return root;
  }


  private static int[] reverse(int arr[]) {
    int temp[] = new int[arr.length];
    for(int i=0; i < arr.length; i++) {
      temp[arr.length-i-1] = arr[i];
    }
    return temp;
  }

  public static Node create(int[] postOrder, int left, int right) {
    if(left > right) return null;
    int data = postOrder[postOrderIndex];
    postOrderIndex++;
    Node node = new Node(null, data, null);
    if(left == right) return node;
    int inorderIndex = map.get(data);
    node.right = create(postOrder, inorderIndex + 1, right);
    node.left = create(postOrder, left, inorderIndex - 1);
    return node;
  }

  public static void main(String[] args) {
    int[] inorder = new int[]   {4,2,5,1,6,3,7};
    int[] postorder = new int[] {4,5,2,6,7,3,1};
    Node root = createTree(inorder, postorder);
    BinaryTree.display(root);
  }



}

/**
 * This method is very similar to tree creation from inorder and pre-order. First, we reverse
 * the post order list and make similar changes as pre and inorder problem.
 *
 *     public static Integer[] inOrder = {4,2,5,1,6,3,7};
 *     public static Integer[] postOrder = {4,5,2,6,7,3,1};
 *     public static int postIndex = 0;
 *     public static Map<Integer, Integer> lookupIndex = new HashMap<>();
 *
 *     public static Node createTreeUtil() {
 *         Collections.reverse(Arrays.asList(postOrder));
 *         for(int i=0;  i< inOrder.length; i++) {
 *             lookupIndex.put(inOrder[i], i);
 *         }
 *
 *         return createTree(0, inOrder.length-1);
 *     }
 *
 *     public static Node createTree(int start, int end) {
 *         if(start > end) return null;
 *         if(postIndex >= postOrder.length) return null;
 *         int data = postOrder[postIndex];
 *         postIndex++;
 *         Node node = new Node(null, data, null);
 *         if(start == end) return node;
 *         int inIndex = lookupIndex.get(data);
 *         node.right = createTree(inIndex+1, end);
 *         node.left = createTree(start, inIndex-1);
 *         return node;
 *     }
 *
 */
