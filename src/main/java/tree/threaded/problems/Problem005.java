package tree.threaded.problems;

import tree.threaded.utils.Node;
import tree.threaded.utils.ThreadedTree;

public class Problem005 {

  public static void preorder(Node node) {
    Node dummy = node;
    node = node.left;
    while(node != dummy) {
      System.out.print(node.data + " ");
      node = getPreorderSuccessor(node);
    }
  }

  private static Node getPreorderSuccessor(Node node) {
    if(node.leftTag == 1) return node.left;
    while(node.rightTag == 0) node = node.right;
    return node.right;
  }

  public static void main(String[] args) {
    Node node = ThreadedTree.getTree();
    preorder(node);
  }
}
