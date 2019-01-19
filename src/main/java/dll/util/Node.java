package dll.util;

public class Node {
  public Node prev;
  public int data;
  public Node next;

  public Node(Node prev, int data, Node next) {
    this.prev = prev;
    this.data = data;
    this.next = next;
  }
}
