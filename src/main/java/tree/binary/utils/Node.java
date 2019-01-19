package tree.binary.utils;

public class Node {
  public int data;
  public Node left;
  public Node right;

  public Node(Node left, int data, Node right) {
    this.left = left;
    this.data = data;
    this.right = right;
  }
}
