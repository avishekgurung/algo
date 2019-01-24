package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem031 {

  private static int index = 0;
  private static void store(Node node, int arr[]) {
    if(node == null) return;
    store(node.left, arr);
    arr[index++] = node.data;
    store(node.right, arr);
  }

  private static int getCount(Node node) {
    if(node == null) return 0;
    return getCount(node.left) + 1 + getCount(node.right);
  }

  public static void replace(Node node, int arr[]) {
    if(node == null) return;
    replace(node.left, arr);
    int prev = index == 0 ? 0 : arr[index-1];
    int next = index == arr.length-1 ? 0 : arr[index + 1];
    index++;
    node.data = prev + next;
    replace(node.right, arr);
  }

  public static void replaceNodeUtil(Node node) {
    int count = getCount(node);
    int[] arr = new int[count];
    store(node, arr);
    index = 0;
    replace(node, arr);
  }

  public static void main(String[] args) {
    Node node = BinaryTree.getTree();
    BinaryTree.display(node);
    replaceNodeUtil(node);
    System.out.println();
    BinaryTree.display(node);
  }

  /**
   * We also follow another logic where we perform a inorder traversal and store the
   * node in an array. Now create another array that has the values of these nodes.
   * And we can now replace the node's by prev and next value, making sure that the
   * prev and next value is retrieved using the value array and change is done on the
   * node array.
   */

}
