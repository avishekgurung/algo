package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

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
