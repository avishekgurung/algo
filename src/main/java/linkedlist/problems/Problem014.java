package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem014 {

  public static int multiple(Node x, Node y) {
    int n1 = 0, n2 = 0;
    while(x != null) {
      n1 = n1 * 10 + x.data;
      x = x.next;
    }

    while(y != null) {
      n2 = n2 * 10 + y.data;
      y = y.next;
    }
    return (n1 * n2);
  }

  public static int multipleAlt(Node x, Node y) {
    String n1 = "", n2 = "";
    while(x != null) {
      n1 = n1 + x.data;
      x = x.next;
    }
    while(y != null) {
      n2 = n2 + y.data;
      y = y.next;
    }
    return Integer.parseInt(n1) * Integer.parseInt(n2);
  }

  public static void main(String[] args) {
    Node x = LinkedListUtil.customBulkInsert(new int[]{9,4,6});
    Node y = LinkedListUtil.customBulkInsert(new int[]{8,4});
    System.out.println(multiple(x, y));
    System.out.println(multipleAlt(x, y));
  }

}
