package linkedlist.impl;

public class DoublyLinkedList {

  class Node {
    int data;
    Node prev;
    Node next;

    Node(Node prev, int data, Node next) {
      this.prev = prev;
      this.data = data;
      this.next = next;
    }
  }

  Node head;

  public void insert(int data) {
    if(head == null) {
      head = new Node(null, data, null);
      return;
    }
    Node pointer = head;
    while(pointer.next != null) {
      pointer = pointer.next;
    }
    pointer.next = new Node(pointer, data, null);
  }

  public Node insertAtAny(int data, Node head, int pos) {
    if(head == null) {
      head = new Node(null, data, null);
      return head;
    }
    if(pos == 0) {
      Node aux = new Node(null, data, head);
      head.prev = aux;
      head = aux;
      return head;
    }
    Node pointer = head;
    for(int i=0; i<pos && pointer.next != null; i++) {
      pointer = pointer.next;
    }
    pointer.next = new Node(pointer, data, pointer.next);
    return head;
  }

  public Node deleteAtAny(Node head, int pos) {
    if(pos == 0) { //deleting the first element
      Node next = head.next;
      if(next == null) { //only one element present, delete that
        head = null;
      }
      else {
        next.prev = null;
        head.next = null;
        head = next;
      }
      return head;
    }

    Node pointer = head;
    for(int i=1; i <= pos; i++) {
      pointer = pointer.next;
      if(pointer == null) {
        System.out.println("Invalid position");
        return head;
      }
    }

    Node prev = pointer.prev;
    Node next = pointer.next;

    if(next == null) {//deleting the last element
      prev.next = null;
      pointer.prev = null;
    }
    else {
      pointer.prev = null;
      pointer.next = null;
      prev.next = next;
      next.prev = prev;
    }

    return head;

  }


  public void display(Node head) {
    Node tail = null;
    while(head != null) {
      System.out.print(head.data + " --> ");
      if(head.next == null) {
        tail = head;
      }
      head = head.next;
    }
    System.out.println();
    while(tail != null) {
      System.out.print(tail.data + " --> ");
      tail = tail.prev;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();
    /*list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);
    list.display(list.head);*/

    Node head = list.insertAtAny(3, null, 0);
    head = list.insertAtAny(2, head, 0);
    head = list.insertAtAny(1, head, 0);
    head = list.insertAtAny(4, head, 9);
    list.display(head);

    System.out.println("");

    head = list.deleteAtAny(head, 2);
    list.display(head);

  }
}
