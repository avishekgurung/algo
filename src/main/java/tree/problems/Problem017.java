package tree.problems;

import tree.util.BinaryTree;
import tree.util.Node;

public class Problem017 {

  public static int getSum(Node root) {
    if(root == null) return 0;
    return getSum(root.left) + root.data + getSum(root.right);
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    System.out.println("Sum: " + getSum(root));
  }
}
