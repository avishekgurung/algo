package tree.util.generic;

public class Node {
  public int data;
  public Node firstChild;
  public Node nextSiblings;

  Node(Node firstChild, int data, Node nextSiblings) {
    this.firstChild = firstChild;
    this.data = data;
    this.nextSiblings = nextSiblings;
  }
}
