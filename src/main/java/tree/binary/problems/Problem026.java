package tree.binary.problems;

import java.util.Arrays;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem026 {

  private static int index = 0;

  public static Node createTree(int arr[]) {
    if(index >= arr.length) return null;
    int data = arr[index++];
    Node node = new Node(null, data, null);
    if(data == 0) return node;
    node.left = createTree(arr);
    node.right = createTree(arr);
    return node;
  }

  public static void main(String[] args) {
    int arr[] = new int[] {1,0,1,0,0};
    Node root = createTree(arr);
    System.out.println(Arrays.toString(arr));
    BinaryTree.display(root);

    index = 0;
    System.out.println();
    arr = new int[] {1,1,0,0,1,0,0};
    root = createTree(arr);
    System.out.println(Arrays.toString(arr));
    BinaryTree.display(root);
  }

}
