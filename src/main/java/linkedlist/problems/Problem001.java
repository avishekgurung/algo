package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem001 {

  public static Node deleteLastOccurrenceOfItem(Node head, int element) {
    Node prev = null;
    Node pointer = head;

    while(pointer.next != null) {
      if(pointer.next.data == element) {
        prev = pointer;
      }
      pointer = pointer.next;
    }
    if(prev != null) {
      prev.next = prev.next.next;
    }
    if(head.data == element && prev == null) {
      Node temp = head.next;
      head.next = null;
      head = temp;
    }
    return head;
  }

  public static void main(String[] args) {

    Node head = LinkedListUtil.customBulkInsert(new int[] {2,3,5,1,3});
    LinkedListUtil.display(head);
    head = deleteLastOccurrenceOfItem(head, 10);
    LinkedListUtil.display(head);

  }

}
