package tree.threaded.problems;

import tree.threaded.utils.Node;
import tree.threaded.utils.ThreadedTree;

public class Problem003 {

  public static void preorder(Node node) {
    Node dummy = node;
    node = node.left;
    node = getLeftMostNode(node);
    while(node != dummy) {
      System.out.print(node.data + " ");
      node = getInorderSuccessor(node);
    }
    System.out.println();
  }

  private static Node getLeftMostNode(Node node) {
    while(node.leftTag == 1) {
      node = node.left;
    }
    return node;
  }

  private static Node getInorderSuccessor(Node node) {
    if(node.rightTag == 0) return node.right;
    Node pointer = node.right;
    while(pointer.left != node) {
      pointer = pointer.left;
    }
    return pointer;
  }

  public static void main(String[] args) {
    Node node = ThreadedTree.getTree();
    preorder(node);
  }

}
