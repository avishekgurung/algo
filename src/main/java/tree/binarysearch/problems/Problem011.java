package tree.binarysearch.problems;



import java.util.Arrays;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem011 {

  public static Node convertArrayToBst(int arr[], int left, int right) {
    if(left > right) return null;
    int mid = (left + right) / 2;
    Node node = new Node(null, arr[mid], null);
    if(left == right) return node;
    node.left = convertArrayToBst(arr, left, mid - 1);
    node.right = convertArrayToBst(arr, mid + 1, right);
    return node;
  }

  public static void main(String[] args) {

    int arr[] = new int[]{1,2,3,4,5,6,7};
    System.out.println(Arrays.toString(arr));
    Node root = convertArrayToBst(arr, 0, arr.length - 1);
    BinarySearchTree.display(root);


    System.out.println();
    arr = new int[]{3,4,6,8,9};
    System.out.println(Arrays.toString(arr));
    root = convertArrayToBst(arr, 0, arr.length - 1);
    BinarySearchTree.display(root);
  }

}
