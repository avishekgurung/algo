package linkedlist.problems;

public class Problem019 {

  private static class Node {
    int data;
    Node next;
    Node down;
    Node(int data, Node next, Node down) {
      this.data = data;
      this.next = next;
      this.down = down;
    }
  }

  private static Node merge(Node x, Node y) {
    if(x == null) return y;
    if(y == null) return x;
    Node result = null;
    if(x.data < y.data) {
      result = x;
      result.down = merge(x.down, y);
    }
    else {
      result = y;
      result.down = merge(x, y.down);
    }
    return result;
  }

  public static Node flatten(Node head) {
    if(head == null || head.next == null) return head;
    Node result = flatten(head.next);
    return merge(head, result);
  }

  public static Node flattenIterative(Node head) {
    Node prev = head;
    Node pointer = head.next;
    while (pointer != null) {
      Node result = merge(prev, pointer);
      pointer = pointer.next;
      prev = result;
    }
    return head;
  }

  public static Node flattenByArray(Node head) {
    int size = 0;
    Node pointer = head;
    while (pointer != null) {
      size++;
      pointer = pointer.next;
    }
    Node arr[] = new Node[size];
    pointer = head;
    for(int i=0;i<arr.length;i++){
      arr[i] = pointer;
      pointer = pointer.next;
    }

    int left = arr.length-1;
    while(left != 0) {
      int i=0; int j=left;
      while(i < j) {
        arr[i] = merge(arr[i], arr[j]);
        i++;
        j--;
        if(i >= j) left = j;
      }
    }
    return arr[0];
  }

  public static void display(Node node) {
    while(node != null) {
      System.out.print(node.data + " ");
      node = node.down;
    }
    System.out.println();
  }

  private static Node createLinkedList() {
    Node five = new Node(5, null, new Node(7, null, new Node(8, null, new Node(30,null,null))));
    Node ten = new Node(10, null, new Node(20, null,null));
    Node nineteen = new Node(19, null, new Node(22, null, new Node(50, null, null)));
    Node twentyEight = new Node(28, null, new Node(35, null, new Node(40,null,new Node(45,null,null))));
    five.next = ten;
    ten.next = nineteen;
    nineteen.next = twentyEight;
    return five;
  }

  public static void main(String[] args) {
    Node head = createLinkedList();
    head = flatten(head);
    display(head);
    System.out.println("------------------");

    head = createLinkedList();
    head = flattenIterative(head);
    display(head);

    System.out.println("------------------");
    head = createLinkedList();
    head = flattenByArray(head);
    display(head);
  }

}

/**
 * Assuming that the size of linked list is n horizontally and vertically.
 * Merge takes O(n + n = 2n = n)
 * And the pointer iterates for n. Hence O(n2).
 *
 * How to improve the time complexity:
 *
 * 1. Pull all the head in an array and merge them like Prob 015.
 *  Time  = (nlogn) and Space = O(n)
 *
 *
 */
