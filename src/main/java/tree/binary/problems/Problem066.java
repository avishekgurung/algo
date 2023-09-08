package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem066 {

  public static void printSum(Node node, int arr[], int index, int sum) {
    if(node == null) return;
    arr[index] = node.data;
    index++;
    if(node.left == null && node.right == null) {
      printNodes(arr, index, sum);
    }
    printSum(node.left, arr, index, sum);
    printSum(node.right, arr, index, sum);
  }

  /**
   * We have an array and the value of sum. So this problem is more of a subarray if we want to optimise the time.
   * Its like, given an array, find all the subarrays whose sum are equal to sum.
   * @param arr
   * @param index
   * @param sum
   */
  public static void printNodes(int arr[], int index, int sum) {
    for(int i=0; i < index; i++) {
      int nodeSum = arr[i];
      for(int j=i+1; j < index; j++) {
         nodeSum = nodeSum + arr[j];
        if(nodeSum == sum) {
          for(int k=i; k <=j;k++) {
            System.out.print(arr[k] + " ");
          }
          System.out.println();
          return;
        }
      }
    }
  }

  public static void main(String[] args) {
    Node node = BinaryTree.createTree(new int[]{2,3,4,1,2,1,2,1});
    BinaryTree.display(node);
    System.out.println();
    printSum(node, new int[7], 0, 7);
  }
}

/**
 * The solution has awful time complexity.
 */
