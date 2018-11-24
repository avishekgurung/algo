package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem021 {

  private static int longestPalindrome(Node head) {

    Node prev = null; int max = 0;
    while(head != null) {
      Node next = head.next;
      head.next = prev;
      if(next == null) break;
      int oddPalindromeCount = 2 * compare(head, next.next) + 1;
      int evenPalindromeCount = 2 * compare(head, next);
      int maxTemp = Math.max(oddPalindromeCount, evenPalindromeCount);
      if(max < maxTemp) max = maxTemp;
      prev = head;
      head = next;
    }
    return max;
  }


  private static int compare(Node x, Node y) {
    int count = 0;
    while(x != null && y != null) {
      if(x.data == y.data) {
        count++;
        x = x.next;
        y = y.next;
      }
      else break;
    }
    return count;
  }

  public static void main(String[] args) {

    Node head = LinkedListUtil.customBulkInsert(new int[]{2,3,7,3,2,12,24});
    System.out.println(longestPalindrome(head));
    head = LinkedListUtil.customBulkInsert(new int[]{12,4,4,3,14});
    System.out.println(longestPalindrome(head));
    head = LinkedListUtil.customBulkInsert(new int[]{1,2,3,4,5,6});
    System.out.println(longestPalindrome(head));
    head = LinkedListUtil.customBulkInsert(new int[]{2,1,2,3,2,1,2,3,2,1,8});
    System.out.println(longestPalindrome(head));
  }
}

/**
 * The first thing that might come in our mind to solve this problem is to
 * create an array and take a subarray with highest palindrome. But since
 * we need to solve this in O(1) space.
 *
 * So we will follow the logic of reversing a linked list. But in each step
 * of reversal, we will move in both the directions to check for palindrome.
 * Eg, 1 -> 2 -> 1, when our pointer is at 2, then the elements prev to it
 * has been reversed and elements next to 2 has not been reversed. So from 2
 * we will travel backward and forward, comparing the elements.
 *
 * Since for every element, we propagate and do a comparision so the complexity
 * is O(n2).
 */
