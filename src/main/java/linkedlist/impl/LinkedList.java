package linkedlist.impl;

public class LinkedList {

  class Node {
    String data;
    Node next;

    Node(String data, Node next) {
      this.data =  data;
      this.next = next;
    }
  }

  Node head;

  public void insert(String data) {
    if(head == null) {
      head = new Node(data, null);
      return;
    }
    Node pointer = head;
    while(pointer.next != null) {
      pointer = pointer.next;
    }
    pointer.next = new Node(data, null);
  }

  public void display(Node pointer) {
    while(pointer != null) {
      System.out.print(pointer.data + " --> ");
      pointer = pointer.next;
    }
    System.out.println();
  }


  public Node insertAtBeginning(String data, Node head) {
    if(head == null) {
      head = new Node(data, null);
      return head;
    }
    Node node = new Node(data, head);
    head = node;
    return head;
  }

  /**
   * inserts the node at any position. If the position is higher than the size of a linked list
   * then it inserts the element at the end.
   * @param data
   * @param head
   * @param pos
   * @return
   */
  public Node insertAtAny(String data, Node head, int pos) {
    if(head == null || pos == 0) {
      head = new Node(data, head);
      return head;
    }
    Node pointer = head;
    for(int i=1; i < pos && pointer.next != null; i++) {
      pointer = pointer.next;
    }
    pointer.next = new Node(data, pointer.next);
    return head;
  }

  /**
   * Deletes any node at any give pos. This can be a reference to delete node at the beginning and
   * at the end.
   * @param head
   * @param pos
   * @return
   */
  public Node deleteAnyNode(Node head, int pos) {
    if(head == null || head.next == null) {
      head = null;
      return head;
    }
    if(pos == 0) {
      head = head.next;
      return head;
    }
    Node pointer = head;
    Node prev = null;

    for(int i=1; i <=pos && pointer.next != null; i++) {
      prev = pointer;
      pointer = pointer.next;
    }

    prev.next = pointer.next;
    return head;
  }

  public void deleteLinkedList(Node head) {
    while(head != null) {
      Node next = head.next;
      head.next = null;
      head = next;
    }
  }

  public void deleteLinkedListRecursion(Node head) {
    if(head == null) return;
    Node next = head.next;
    deleteLinkedListRecursion(next);
    head.next = null;
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.insert("1");
    list.insert("2");
    list.insert("3");
    list.insert("4");
    list.display(list.head);

    /*Node head = list.insertAtBeginning("0", list.head);
    list.display(head);

    head = list.insertAtAny("A", head, 0);
    list.display(head);

    head = list.insertAtAny("B", head, 1);
    list.display(head);

    head = list.insertAtAny("C", head, 2);
    list.display(head);

    head = list.insertAtAny("D", head, 8);
    list.display(head);

    head = list.insertAtAny("E", head, 1000);
    list.display(head);*/

    /*Node head = list.deleteAnyNode(list.head, 0);
    list.display(head);*/

    /*Node head = list.deleteAnyNode(list.head, 1000);
    list.display(head);*/

    /*Node head = list.deleteAnyNode(list.head, 2);
    list.display(head);*/

    /*Node head = list.deleteAnyNode(list.head, 0);
    list.display(head);*/

    list.deleteLinkedListRecursion(list.head);

    //This line will be required to delete the head too.
    //list.head = null;
    list.display(list.head);


  }

}
