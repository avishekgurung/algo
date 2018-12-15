package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem005 {

  public static Node sort012(Node head) {

    if(head == null || head.next == null) return head;

    Node tail = head;
    Node pointer = head.next;
    Node prev = head;

    Node twoAtHead = head.data == 2 ? head : null;

    while(tail.next != null) {
      tail = tail.next;
    }
    Node end = tail;

    while(pointer != end) {
      if(pointer.data == 0) {
        Node temp = pointer;
        prev.next = pointer.next;
        pointer = pointer.next;
        temp.next = head;
        head = temp;
      }
      else if(pointer.data == 2) {
        Node temp = pointer;
        prev.next = pointer.next;
        pointer = pointer.next;
        tail.next = temp;
        tail = temp;
        tail.next = null;
      }
      else {
        prev = pointer;
        pointer = pointer.next;
      }
    }

    //Handling a case if 0 is at the 'end'
    if(pointer.data == 0) {
      Node temp = pointer;
      prev.next = pointer.next;
      temp.next = head;
      head = temp;
    }

    //Handling the case if 2 is at the beginning of LL.
    /**
     * The condition twoAtHead != head is a special for a case when all the elements are 2
     */
    if(twoAtHead != null && twoAtHead != head) {
      pointer = head;
      while(pointer.next != twoAtHead) {
        pointer = pointer.next;
      }
      pointer.next = pointer.next.next;
      tail.next = twoAtHead;
      twoAtHead.next = null;
    }

    return head;

  }

  /**
   * 1) Traverse the list and count the number of 0s, 1s and 2s.
   * Let the counts be n1, n2 and n3 respectively.
   2) Traverse the list again, fill the first n1 nodes with 0,
   then n2 nodes with 1 and finally n3 nodes with 2
   * @param head
   * @return
   */
  public static Node sort234Smart(Node head) {
    int zeroes = 0;
    int ones = 0;
    int twos = 0;

    Node pointer = head;
    while(pointer != null) {
      switch (pointer.data) {
        case 0: zeroes++; break;
        case 1: ones++; break;
        default: twos++; break;
      }

      pointer = head;
      for(int i=0; i <= zeroes; i++) {
        if(i < zeroes) pointer.data = 0;
        else if(i < ones + zeroes) pointer.data = 1;
        else if(i < ones + zeroes + twos)pointer.data = 0;
        pointer = pointer.next;
      }
    }
    return head;
  }

  public static void main(String[] args) {

    Node head = LinkedListUtil.customBulkInsert(new int[]{1,2,0,2,1,2,0});
    head = sort012(head);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[]{2,0,2,1,2,0});
    head = sort012(head);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[]{2,0,2,1,2,2});
    head = sort012(head);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[]{0,0,0,0,0,0,0});
    head = sort012(head);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[]{1,1,1,1,1,1});
    head = sort012(head);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[]{2,2,2,2,2,2});
    head = sort012(head);
    LinkedListUtil.display(head);
  }

}
