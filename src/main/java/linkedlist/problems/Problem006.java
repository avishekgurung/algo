package linkedlist.problems;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Problem006 {

  private static class Node {

    int data;
    Node next;
    Node rand;

    Node(int data, Node next, Node rand) {
      this.data = data;
      this.next = next;
      this.rand = rand;
    }
  }

  public static void display(Node head) {
    while(head != null) {
      System.out.print(head.data + " ("+head.rand.data+") --> ");
      head = head.next;
    }
    System.out.println();
  }

  public static Node create() {
    Node one = new Node(1, null, null);
    Node two = new Node(2, null, null);
    Node three = new Node(3, null, null);
    Node four = new Node(4, null, null);

    one.next = two;
    two.next = three;
    three.next = four;
    four.next = null;

    one.rand = four;
    two.rand = one;
    three.rand = two;
    four.rand = three;
    return one;
  }

  //clone by extra space
  public static Node cloneByExtraSpace(Node head) {
    Node pointer = head;
    Map<Node, Node> map = new HashMap<Node, Node>();
    while(pointer != null) {
      map.put(pointer, new Node(pointer.data, null, null));
      pointer = pointer.next;
    }

    pointer = head;
    Node cloneHead = null;
    while (pointer != null) {
      Node node = map.get(pointer.data);
      node.next = pointer.next == null ? null : map.get(pointer.next);
      node.rand = pointer.rand == null ? null : map.get(pointer.rand);
      if(cloneHead == null) cloneHead = node;
      pointer = pointer.next;
    }
    return cloneHead;
  }

  /**
   * Wi
   * @param head
   * @return
   */
  public static Node cloneWithoutExtraSpace(Node head) {
    Node pointer = head;
    while(pointer != null) {
      Node temp = new Node(pointer.data, pointer.next, null);
      pointer.next = temp;
      pointer = temp.next;
    }

    pointer = head;
    Node tempPointer = head.next;
    while(pointer != null) {
      tempPointer.rand = pointer.rand.next;
      pointer = tempPointer.next;
      if(pointer != null) tempPointer = pointer.next;
    }

    pointer = head;
    tempPointer = head.next;
    Node cloneHead = tempPointer;

    //Logic to separate a linked list
    while(pointer != null) {
      pointer.next = tempPointer.next;
      pointer = tempPointer.next;
      if(pointer != null) {
        tempPointer.next = pointer.next;
        tempPointer = pointer.next;
      }
    }
    return cloneHead;
  }

  public static void main(String[] args) {

    Node head = create();
    display(head);
    Node cloneHead = cloneByExtraSpace(head);
    display(cloneHead);
    System.out.println("--------------");
    head.next.next = null;
    display(head);
    display(cloneHead);

    System.out.println("-------------------");
    head = create();
    display(head);
    cloneHead = cloneWithoutExtraSpace(head);
    display(cloneHead);
    System.out.println("--------------");
    head.next.next = null;
    display(head);
    display(cloneHead);
  }
}
