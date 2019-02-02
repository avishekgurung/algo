package tree.binary.problems;

import java.util.Arrays;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem060 {

  public static Node search (Node node, int ele) {
    if(node == null) return null;
    if(node.data == ele) return node;
    Node left = search(node.left, ele);
    Node right = search(node.right, ele);
    if(left != null) return left;
    return right;
  }

  public static boolean checkPath (Node node, int arr[], int index) {
    if(node == null) return false;
    if(arr[index] != node.data) return false;
    index++;
    if(index == arr.length) return true;
    boolean left = checkPath(node.left, arr, index);
    boolean right = checkPath(node.right, arr, index);
    return left || right;
  }


  public static boolean checkPathWithSingleIteration (Node node, int arr[], int index) {
    if(node == null) return false;

    if(arr[index] == node.data)index++;
    if(index == arr.length) return true;

    boolean left = checkPathWithSingleIteration(node.left, arr, index);
    boolean right = checkPathWithSingleIteration(node.right, arr, index);
    return left || right;
  }

  public static void main(String[] args) {
    Node node = BinaryTree.getTree();
    BinaryTree.display(node);

    System.out.println();
    int path[] = new int[]{1,2,3};
    System.out.println(Arrays.toString(path) + ": " + checkPathWithSingleIteration(search(node, path[0]),
        path, 0));
    path = new int[]{1,2,4};
    System.out.println(Arrays.toString(path) + ": " + checkPathWithSingleIteration(search(node, path[0]),
        path, 0));

    path = new int[]{3,6};
    System.out.println(Arrays.toString(path) + ": " + checkPathWithSingleIteration(search(node, path[0]),
        path, 0));
  }

  /**
   * We are following a simple logic to first find the node from where the comparison has to
   * start and then we keep comparing.
   *
   * The second logic is the smarter one. Here, we do it in single iteration. Whenever we find
   * an element or when the element matches only then we increment the index. So if the index
   * has reached the size of an array then this means that all the elements has been matched and
   * we return true.
   *
   */
}
