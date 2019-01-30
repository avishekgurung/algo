package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem047 {

  public static Node create(int arr[], int left, int right) {
    if(left > right) return null;
    int[] result = getMaxElementWithIndex(arr, left, right);
    Node node = new Node(null, result[1], null);
    if(left == right) return node;
    node.left = create(arr, left, result[0]-1);
    node.right = create(arr, result[0]+1, right);
    return node;
  }

  private static int[] getMaxElementWithIndex(int[] arr, int left, int right) {
    int max = Integer.MIN_VALUE;
    int index = -1;
    for(int i=left; i <= right; i++) {
      if(arr[i] > max) {
        max = arr[i];
        index = i;
      }
    }
    return new int[]{index, max};
  }

  private static void inorder(Node node) {
    if(node == null) return;
    System.out.print(node.data + " ");
    inorder(node.left);
    inorder(node.right);
  }

  public static void main(String[] args) {
    int arr[] = new int[]{5, 10, 40, 30, 28};
    Node root = create(arr, 0, arr.length-1);
    BinaryTree.display(root);
    inorder(root);
    System.out.println();
    System.out.println();
    arr = new int[]{1, 5, 10, 40, 30, 15, 28, 20};
    root = create(arr, 0, arr.length-1);
    BinaryTree.display(root);
    inorder(root);
  }
}
