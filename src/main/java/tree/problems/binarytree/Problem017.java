package tree.problems.binarytree;

import tree.util.binarytree.BinaryTree;
import tree.util.binarytree.Node;

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
