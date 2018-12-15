package circularlinkedlist.problems;

import circularlinkedlist.CircularLinkedList;
import circularlinkedlist.Node;

public class Problem001 {

  public static Node deleteEven(Node head) {
    if(head == null || head.next == null) return head;
    Node pointer = head;
    Node prev = head;
    do {
      pointer = pointer.next;
      if(pointer == head) break;
      pointer = pointer.next;
      prev.next = pointer;
      prev = pointer;
    }
    while (pointer != head);
    return head;
  }

  /**
   * Like a swag!
   * @param head
   * @return
   */
  public static Node deleteOdd(Node head) {
    Node pseudoHead = head.next;
    pseudoHead = deleteEven(pseudoHead);
    return pseudoHead;
  }


  public static void main(String[] args) {

    Node head = CircularLinkedList.getPredefinedList();
    CircularLinkedList.display(head);

    head = deleteEven(head);
    CircularLinkedList.display(head);

    head = CircularLinkedList.getPredefinedList();
    head = deleteOdd(head);
    CircularLinkedList.display(head);
  }

}
