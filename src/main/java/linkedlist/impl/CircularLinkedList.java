package linkedlist.impl;

public class CircularLinkedList {

  class Node {
    int data;
    Node next;

    Node(int data, Node next) {
      this.data =  data;
      this.next = next;
    }
  }

  Node head;

  public void insert(int data) {
    if(head == null) {
      head = new Node(data, head);
      head.next = head;
    }
    else {
      Node pointer = head;
      do {
        pointer = pointer.next;
      }
      while(pointer.next != head);
      pointer.next = new Node(data, pointer.next);
    }
  }

  //inserting at mid is same as that of linkedList
  public void insertAtBeginning(int data) {
    if(head == null) {
      head = new Node(data, head);
      head.next = head;
    }
    else {
      Node pointer = head;
      while(pointer.next != head) {
        pointer = pointer.next;
      }
      Node temp = new Node(data, head);
      pointer.next = temp;
      head = temp;
    }
  }

  public Node deleteFirstNode(Node head) {
    if(head == null) return null;
    if(head.next == head) {//only one element
      head = null;
    }
    else {
      Node pointer = head;
      Node second = head.next;
      while (pointer.next != head) {
        pointer = pointer.next;
      }
      pointer.next = second;
      head =  second;
    }
    return head;
  }

  public Node deleteLastNode(Node head) {
    if(head.next == head) {
      head = null;
    }
    else {
      Node pointer = head;
      Node prev = null;

      while(pointer.next != head) {
        prev = pointer;
        pointer = pointer.next;
      }
      prev.next = head;
    }
    return head;
  }

  public void display(Node head) {
    if(head == null) return;
    Node pointer = head;
    do {
      System.out.print(pointer.data + " --> ");
      pointer = pointer.next;
    }
    while(pointer != head);
    System.out.println();
  }


  public static void main(String[] args) {
    CircularLinkedList list = new CircularLinkedList();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.display(list.head);

    /*list.insertAtBeginning(1);
    list.insertAtBeginning(2);
    list.insertAtBeginning(3);
    list.display(list.head);*/

    /*Node head = list.deleteFirstNode(list.head);
    list.display(head);*/

    Node head = list.deleteLastNode(list.head);
    list.display(head);
  }

}
