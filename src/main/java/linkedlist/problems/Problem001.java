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
      head = head.next;
    }
    return head;
  }

  public static void main(String[] args) {

    Node head = LinkedListUtil.customBulkInsert(new int[] {2,3,5,1,3});
    LinkedListUtil.display(head);
    head = deleteLastOccurrenceOfItem(head, 2);
    LinkedListUtil.display(head);

  }

}

/**
 * Approaches:
 *  1. The naive approach is also to find the position of the element by counting/indexing and
 *  then in the next iteration, go to the element before the index and remove the next element.
 *
 *  2. We can reverse the LL and delete the first occurrence of an element.
 *
 *  Both approaches will have constant space and O(n) time complexity, however the latter is simple to implement and
 *  can be done in single iteration.
 *
 */
