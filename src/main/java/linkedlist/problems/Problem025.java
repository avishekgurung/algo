package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem025 {

  public static int getNoOfRotations(Node head) {
    int rotationCount = 0;
    while(head.next != null) {
      if(head.data > head.next.data) {
        return ++rotationCount;
      }
      rotationCount++;
      head = head.next;
    }
    return 0;
  }

  public static void main(String[] args) {
    Node head = LinkedListUtil.customBulkInsert(new int[]{12,15,18,5,8,11});
    LinkedListUtil.display(head);
    System.out.println("Rotation count: " + getNoOfRotations(head));
    System.out.println();

    head = LinkedListUtil.customBulkInsert(new int[]{15,18,5,8,11,12});
    LinkedListUtil.display(head);
    System.out.println("Rotation count: " + getNoOfRotations(head));
    System.out.println();

    head = LinkedListUtil.customBulkInsert(new int[]{18,5,8,11,12,15});
    LinkedListUtil.display(head);
    System.out.println("Rotation count: " + getNoOfRotations(head));
    System.out.println();

    head = LinkedListUtil.customBulkInsert(new int[]{5,8,11,12,15,18});
    LinkedListUtil.display(head);
    System.out.println("Rotation count: " + getNoOfRotations(head));
    System.out.println();
  }

  /**
   * The above logic will fail if the linked list is sorted and never rotated. If the linked list is never rotated
   * then we need to return 0. So we need to slightly tweak the logic.
   *
   * If head.data > head.next.data, then stop incrementing the rotationCount value.
   *
   * if this value equals the length of the LL then the list was not rotated or rotated to its length.
   */

}
