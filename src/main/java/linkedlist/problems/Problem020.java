package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem020 {

  public static void triplets(Node x, Node y, Node z, int k) {
    y = mergeSort(y);
    z = mergeSort(z); //we can perform merge sort in descending order to avoid reverse.
    z = reverse(null ,z);
    Node yHead = y;
    Node zHead = z;

    while(x != null) {
      y = yHead;
      z = zHead;
      while(y!= null && z != null) {
        int sum = x.data + y.data + z.data;
        if(sum == k) {
          System.out.println(x.data+","+y.data+","+z.data);
          y = y.next;
        }
        else if(sum < k) {
          y = y.next;
        }
        else {
          z = z.next;
        }
      }
      x = x.next;
    }
  }

  private static Node reverse(Node prev, Node node) {
    if(node == null) return prev;
    Node result = reverse(node, node.next);
    node.next = prev;
    return result;
  }

  private static Node mergeSort(Node node) {
    if(node == null || node.next == null) return node;
    Node mid = getMid(node);
    Node midNext = mid.next;
    mid.next = null;
    Node left = mergeSort(node);
    Node right = mergeSort(midNext);
    Node result = merge(left, right);
    return result;
  }

  private static Node merge(Node x, Node y) {
    if(x == null) return y;
    if(y == null) return x;
    Node result = null;
    if(x.data < y.data) {
      result = x;
      result.next = merge(x.next, y);
    }
    else {
      result = y;
      result.next = merge(x, y.next);
    }
    return result;
  }

  private static Node getMid(Node node) {
    Node slow = node;
    Node fast = node.next;
    while(fast != null) {
      fast = fast.next;
      if(fast == null) break;
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    Node x = LinkedListUtil.customBulkInsert(new int[]{5,2,9,7,2});
    Node y = LinkedListUtil.customBulkInsert(new int[]{6,2,3,7,1,8});
    Node z = LinkedListUtil.customBulkInsert(new int[]{10,4,2,6,4,2});

    LinkedListUtil.display(x);
    LinkedListUtil.display(y);
    LinkedListUtil.display(z);

    triplets(x,y,z,16);

  }

}
