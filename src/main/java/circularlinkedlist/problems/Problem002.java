package circularlinkedlist.problems;

import circularlinkedlist.CircularLinkedList;
import circularlinkedlist.Node;

public class Problem002 {


  public static Node josephusCircle(Node head, int k) {

    if(head == null || head.next == null) return head;

    Node pointer = head;

    int count = 1;
    while(pointer.next != pointer) {
      if(count+1 == k) {
        count = 0;
        pointer.next = pointer.next.next;
        CircularLinkedList.display(pointer);
      }
      pointer = pointer.next;
      count++;
    }
    return pointer;
  }

  public static void main(String[] args) {

    Node head = CircularLinkedList.customBulkInsert(new int[]{1,2,3,4,5,6,7,8,9,10,11,12});
    //Node head = CircularLinkedList.customBulkInsert(new int[]{1,2,3,4});
    System.out.println("Members");
    CircularLinkedList.display(head);
    int k = 53;
    System.out.println("Elimination number " + k);
    System.out.println();
    Node leader = josephusCircle(head, k);
    System.out.println("Leader: " + leader.data);

  }

}
