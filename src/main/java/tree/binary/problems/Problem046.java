package tree.binary.problems;

import java.util.Arrays;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem046 {

  public static void fillAncestorArray(Node node, int arr[][], int index, int[] lookUp) {
    if(node == null) return;

    /*for(int i=0; i < index; i++) {
      if(lookUp[i] != 0) {
        arr[lookUp[i]][node.data] = 1;
      }
    }*/
    lookUp[index] = node.data;
    index++;
    if(node.left == null && node.right == null) {
      fillArray(arr, index, lookUp);
    }
    fillAncestorArray(node.left, arr, index, lookUp);
    fillAncestorArray(node.right, arr, index, lookUp);
  }

  public static void fillArray(int arr[][], int index, int[] lookUp) {
    for(int i=0;i < index; i++) {
      int x = lookUp[i];
      for(int j=i+1; j < index; j++) {
        int y = lookUp[j];
        arr[x][y] = 1;
      }
    }
  }

  public static void fillAncestorArrayUtil(Node node, int nodeCount) {
    int arr[][] = new int[nodeCount][nodeCount];
    int[] lookUp = new int[nodeCount];
    fillAncestorArray(node, arr, 0, lookUp);
    System.out.println();
    for(int i=0; i < arr.length; i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
  }

  public static void main(String[] args) {
    Node root = BinaryTree.createTree(new int[]{5,1,2,0,4,3});
    BinaryTree.display(root);
    fillAncestorArrayUtil(root, 6);
  }
}
/***
 * I maintain a lookUp array which holds the ancestor. And every time I travers a node, I check
 * the looUp array upto that index and update the actual array. Once a node is traversed, its
 * value is again added to the looUp list.
 */
