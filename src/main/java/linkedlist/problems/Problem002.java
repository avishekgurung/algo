package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem002 {

  public static int getLengthRecursion(Node node) {
    if(node == null) return 0;
    int length = getLengthRecursion(node.next);
    return length + 1;
  }

  public static void main(String[] args) {

    Node head = LinkedListUtil.customBulkInsert(new int[]{1,2,3,4,5});
    System.out.println(getLengthRecursion(head));

    head = LinkedListUtil.customBulkInsert(new int[]{1,2});
    System.out.println(getLengthRecursion(head));

    System.out.println(getLengthRecursion(null));

  }

}
