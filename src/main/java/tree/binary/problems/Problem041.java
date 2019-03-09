package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem041 {

  private static Node prev = null;

  public static Node modify(Node node) {
    if(node == null) return null;
    if(prev != null) prev.right = node;
    prev = node;
    Node temp = node.right;
    //node.right = null;
    modify(node.left);
    modify(temp);
    return node;
  }

  private static void display(Node node) {
    while(node != null) {
      System.out.print(node.data + "\t");
      node = node.right;
    }
  }

  public static void main(String[] args) {
    Node node = BinaryTree.getTree();
    BinaryTree.display(node);
    node = modify(node);
    display(node);
  }
}
