package linkedlist.problems;

public class Problem010 {

  private class Node {
    int data;
    Node next;
    Node rand;

    Node(int data, Node next, Node rand) {
      this.data = data;
      this.next = next;
      this.rand = rand;
    }
  }

  private Node getLinkedList() {
    Node two = new Node(2,null, null);
    Node ten = new Node(10,null, null);
    Node five = new Node(5,null, null);
    Node three = new Node(3,null, null);

    five.next = ten;
    ten.next = two;
    two.next = three;
    return five;
  }

  private void display(Node node) {
    while(node != null) {
      System.out.print(node.data);
      if(node.next != null) System.out.print(" -> " + node.next.data);
      else System.out.print(" : N");
      if(node.rand != null) System.out.print(" : " + node.rand.data);
      else System.out.print(" : N");
      System.out.println();
      node = node.next;
    }
  }

  private Node arrange(Node head) {
    head = reverse(head);
    Node max = head;
    Node pointer = head.next;
    while(pointer != null) {
      pointer.rand = max;
      if(pointer.data > max.data) max = pointer;
      pointer = pointer.next;
    }
    head = reverse(head);
    return head;
  }

  private Node reverse(Node node) {
    Node prev = null;
    while(node != null) {
      Node next = node.next;
      node.next = prev;
      prev = node;
      node = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    Problem010 obj = new Problem010();
    Node head = obj.getLinkedList();
    obj.display(head);
    System.out.println("---------------");
    head = obj.arrange(head);
    obj.display(head);

  }



}
