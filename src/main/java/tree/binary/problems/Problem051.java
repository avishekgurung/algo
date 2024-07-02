package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem051 {

  public static Node modify(Node node) {
    if(node == null) return null;
    Node left = modify(node.left);
    Node right = modify(node.right);
    if(left != null && right != null) {
      node.data = left.data + right.data;
    }
    return node;
  }

  private static int modifySimple(Node node) {
    if(node == null) return 0;
    int left = modifySimple(node.left);
    int right = modifySimple(node.right);
    int data = node.data;
    node.data = left + right;
    return data;
  }


  public static void main(String[] args) {

    Node node = BinaryTree.getTree();
    BinaryTree.display(node);
    modifySimple(node);
    //modify(node);
    System.out.println();
    BinaryTree.display(node);

  }

}
