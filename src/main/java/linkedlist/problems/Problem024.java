package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem024 {

  private static Node absoluteSort(Node head) {
    Node prev = head;
    Node pointer = head.next;
    if(pointer == null) return head;
    while(pointer != null) {
      if(pointer.data < 0) {
        Node next = pointer.next;
        prev.next = next;
        pointer.next = head;
        head = pointer;
        pointer = next;
      }
      else {
        prev = pointer;
        pointer = pointer.next;
      }
    }
    return head;
  }

  public static void main(String[] args) {
    Node head = LinkedListUtil.customBulkInsert(new int[]{1,-2,-3,4,-5});
    LinkedListUtil.display(head);
    head = absoluteSort(head);
    LinkedListUtil.display(head);

    System.out.println();
    head = LinkedListUtil.customBulkInsert(new int[]{1,2,3});
    LinkedListUtil.display(head);
    head = absoluteSort(head);
    LinkedListUtil.display(head);

    System.out.println();
    head = LinkedListUtil.customBulkInsert(new int[]{-1,-2,-3,-4,-5});
    LinkedListUtil.display(head);
    head = absoluteSort(head);
    LinkedListUtil.display(head);
  }
}

/**
 * We traverse the LL and whenever we find any negative number then we move it to the beginning
 * of the LL.
 *
 * ~ Asked in Amazon.
 */
