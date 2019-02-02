package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem50 {

  private static Node head;
  private static Node prev;

  public static void modify(Node node) {
    if(node == null) return;
    modify(node.left);
    if(prev != null) {
      prev.right = node;
    }
    else {
      head = node;
    }
    node.left = prev;
    prev = node;
    modify(node.right);
  }

  private static void traverse(Node node) {
    while(node != null) {
      System.out.print(node.data + " ");
      node = node.right;
    }
  }

  public static void main(String[] args) {
    Node node = BinaryTree.getTree();
    BinaryTree.display(node);
    modify(node);
    traverse(head);
  }

}
