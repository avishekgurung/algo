package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem015 {

  /**
   * This complex logic is not required. We can take a list from 0 and 1, merge it and keep it
   * in 0. Then merge 0 and 2 keep it in 0 and continue. The complexity will be the same.
   * @param arr
   * @return
   */
  public static Node util(Node[] arr) {
    int last = arr.length - 1;
    while(last != 0) {
      int i=0, j=last;
      while(i < j) {
        arr[i] = sortMerge(arr[i], arr[j]);
        i++;
        j--;
        if (i >= j) {
          last = j;
        }
      }
    }
    return arr[0];
  }

  private static Node sortMerge(Node x, Node y) {
    if(x == null) return y;
    if(y == null) return x;

    Node result = null;
    if(x.data < y.data) {
      result = x;
      result.next = sortMerge(x.next, y);
    }
    else {
      result = y;
      result.next = sortMerge(x, y.next);
    }
    return result;
  }

  public static void main(String[] args) {
    Node head1 = LinkedListUtil.customBulkInsert(new int[]{3,5,8,9});
    Node head2 = LinkedListUtil.customBulkInsert(new int[]{3,8,9,12});
    Node head3 = LinkedListUtil.customBulkInsert(new int[]{1,4,6,7});
    Node head4 = LinkedListUtil.customBulkInsert(new int[]{0,11,13,15});
    Node head5 = LinkedListUtil.customBulkInsert(new int[]{2,10,14,16});

    Node arr[] = new Node[]{head1, head2, head3, head4, head5};
    Node head = util(arr);
    LinkedListUtil.display(head);
  }
}
/**
 * NOTES:
 *
 * Complexity:
 * The inner while loops divides the array into half every time. Its like
 * for(int i=k;i>=0;i=i/2){} So its complexity is logk (base 2).
 *
 * The sortMerge step takes n+n=2n ~ n
 * We now have complexity as nlogk
 *
 * The topmost can run for k. So the time complexity is O(nklogk)
 *
 * The util method is pretty important and can have its use across other problems
 * too. Please note it.
 *
 */
