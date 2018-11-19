package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class ReverseEveryK {

  public static Node reverse(Node head) {
    Node prev = null;
    while(head != null) {
      Node next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public static Node reverseEveryK(Node head, int k) {
    Node pointer = head;
    int i = 1;
    Node start = head;
    Node end = null;
    Node offset = null;
    Node newHead = null;

    while(pointer != null) {
      if(i == k) {
        end = pointer;
        Node next = end.next;
        end.next = null;
        end = reverse(start);
        start.next = next;
        if(offset == null) {
          offset = start;
        }
        else {
          offset.next = end;
          offset = start;
        }
        i = 1;
        pointer = next;
        if(newHead == null) {
          newHead = end;
        }
      }
      else {
        if(i == 1) {
          start = pointer;
        }
        i++;
        pointer = pointer.next;
      }
    }
    return newHead;
  }

  public static void main(String[] args) {
    Node head = LinkedListUtil.customBulkInsert(new int[] {1,2,3});
    head = reverseEveryK(head, 2);
    LinkedListUtil.display(head);
  }


}
