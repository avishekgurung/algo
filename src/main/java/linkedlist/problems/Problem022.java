package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem022 {

  private static Node[] appendZeroes(Node x, Node y) {
    int l1 = length(x);
    int l2 = length(y);
    int diff = Math.abs(l1 - l2);
    if(diff == 0) return new Node[]{x,y};
    Node temp = new Node(0, null);
    diff--;
    Node head = temp;
    while(diff != 0) {
      Node temp1 = new Node(0,null);
      temp.next = temp1;
      temp = temp1;
      diff--;
    }
    if(l1 > l2) {
      temp.next = y;
      y = head;
    }
    else {
      temp.next = x;
      x = head;
    }
    return new Node[]{x,y};
  }

  private static Node[] compare(Node x, Node y) {
    Node head1 = x;
    Node head2 = y;
    while(x.data == y.data) {
      x = x.next;
      y = y.next;
      if(x == null || y == null) return new Node[]{head1, head2};
    }
    Node[] result;
    if(x.data > y.data) result = new Node[]{head1, head2};
    else result = new Node[]{head2, head1};
    return result;
  }

  private static boolean borrow = false;
  public static Node subtract(Node node1, Node node2) {
    Node result[] = appendZeroes(node1, node2);
    result = compare(result[0], result[1]);
    Node large = result[0];
    Node small = result[1];
    Node head = helper(large, small);
    return head;
  }

  private static Node helper(Node x, Node y) {
    if(x == null || y == null) return null;
    Node result = helper(x.next, y.next);
    int val1 = x.data;
    int val2 = y.data;

    if(borrow) {
      val1 = val1 - 1;
      borrow = false;
    }

    if(val1 < val2) {
      val1 = val1 + 10;
      borrow = true;
    }

    int val = val1 - val2;
    Node temp = new Node(val, null);
    temp.next = result;
    result = temp;
    return result;
  }

  private static int length(Node node) {
    int len = 0;
    while (node != null) {
      len++;
      node = node.next;
    }
    return len;
  }

  public static void main(String[] args) {
    Node x = LinkedListUtil.customBulkInsert(new int []{4,3});
    Node y = LinkedListUtil.customBulkInsert(new int []{1,2});
    LinkedListUtil.display(x);
    LinkedListUtil.display(y);
    Node result = subtract(x,y);
    System.out.println("-------------");
    LinkedListUtil.display(result);
    System.out.println("***********************\n");

    x = LinkedListUtil.customBulkInsert(new int []{1,0,0,0});
    y = LinkedListUtil.customBulkInsert(new int []{1,2});
    LinkedListUtil.display(x);
    LinkedListUtil.display(y);
    result = subtract(x,y);
    System.out.println("-------------");
    LinkedListUtil.display(result);
    System.out.println("***********************\n");

    x = LinkedListUtil.customBulkInsert(new int []{1,2});
    y = LinkedListUtil.customBulkInsert(new int []{1,2});
    LinkedListUtil.display(x);
    LinkedListUtil.display(y);
    result = subtract(x,y);
    System.out.println("-------------");
    LinkedListUtil.display(result);
    System.out.println("***********************\n");

  }

}
