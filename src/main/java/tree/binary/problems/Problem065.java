package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem065 {

  public static boolean trim(Node node, int sum, int k) {
    if(node == null) return false;
    sum = sum + node.data;
    if(node.left == null && node.right == null) {
      if(sum < k) return true;
      else return false;
    }

    boolean left = trim(node.left, sum, k);
    boolean right = trim(node.right, sum, k);

    if(left) {
      node.left = null;
      if(node.right == null) {
        return true;
      }
    }

    if(right) {
      node.right = null;
      if(node.left == null) {
        return true;
      }
    }

    return left && right;
  }


  public static void main(String[] args) {
    Node node = BinaryTree.getTree();
    BinaryTree.display(node);
    trim(node, 0, 12); //Keep tuning the value of k from 7 to 12 and see the change.
    System.out.println();
    BinaryTree.display(node);

  }


}
