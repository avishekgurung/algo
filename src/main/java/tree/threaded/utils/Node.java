package tree.threaded.utils;

public class Node {

  public int data;
  public Node left;
  public Node right;
  public int leftTag;
  public int rightTag;

  Node(Node left, int data, Node right) {
    this.left = left;
    this.data =  data;
    this.right = right;
    this.leftTag = 1;
    this.rightTag = 1;
  }
}
