package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem015 {

  public static void printRootToLeaf(Node root, int arr[], int index) {
    if(root == null) return;
    arr[index] = root.data;
    if(root.left == null && root.right == null) {
      for(int i=0; i <=index; i++) {
        System.out.print(arr[i] + " -> ");
      }
      System.out.println();
      return;
    }
    index++;
    printRootToLeaf(root.left, arr, index);
    printRootToLeaf(root.right, arr, index);
  }


  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    printRootToLeaf(root, new int[10], 0);
  }

}
