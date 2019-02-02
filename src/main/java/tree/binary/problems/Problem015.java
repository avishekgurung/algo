package tree.binary.problems;

import java.util.Arrays;
import java.util.Stack;

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

  public static void printRootToLeafByIteration(Node node) {
    System.out.println();
    Stack<Node> stack = new Stack<Node>();
    int arr[] = new int[10];
    int index = 0;
    while(true) {
      while(node != null) {
        arr[index++] = node.data;
        stack.push(node);
        if(node.left == null && node.right == null) {
          for(int i=0; i < index; i++) System.out.print(arr[i] + " ");
          System.out.println();
        }
        node = node.left;
      }
      if(stack.isEmpty()) break;
      node = stack.pop();
      node = node.right;
      if(node != null) index--;
    }
  }


  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    printRootToLeaf(root, new int[10], 0);
    printRootToLeafByIteration(root);
  }

}
