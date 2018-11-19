package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem003 {

  public static boolean searchRecursion(Node node, int element) {
    if(node == null) return false;
    if(node.data == element) return true;
    boolean result = searchRecursion(node.next, element);
    return result;
  }

  public static void main(String[] args) {
    Node head = LinkedListUtil.customBulkInsert(new int[] {1,2,3,4,5,6});
    System.out.println(searchRecursion(head, 1));
    System.out.println(searchRecursion(head, 3));
    System.out.println(searchRecursion(head, 6));
    System.out.println(searchRecursion(head, 7));
    System.out.println(searchRecursion(null, 1));
  }

}
