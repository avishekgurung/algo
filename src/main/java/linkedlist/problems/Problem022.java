package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem022 {

  private int getSize(Node node) {
    if(node == null) return 0;
    return getSize(node.next) + 1;
  }

  private Node addExtraNode(Node node, int extra) {
    if(extra == 0) return node;
    Node head = new Node(0, null);
    Node body = head;
    while(extra > 1) {
      Node aux = new Node(0, null);
      body.next = aux;
      body = body.next;
      extra--;
    }
    body.next = node;
    return head;
  }


  private boolean borrow = false;
  private void subUtil(Node node1, Node node2) {
    int s1 = getSize(node1);
    int s2 = getSize(node2);

    if(s1 < s2) {
      Node temp = node1;
      node1 = node2;
      node2 = temp;
    }

    int diff = Math.abs(s1 - s2);
    node2 = addExtraNode(node2, diff);
    Node result = subtract(node1, node2);
    LinkedListUtil.display(node1);
    LinkedListUtil.display(node2);
    System.out.println("------------------------");
    LinkedListUtil.display(result);
    System.out.println("\n");
  }

  private Node subtract(Node node1, Node node2) {
    if(node1 == null) return null;
    Node result = subtract(node1.next, node2.next);
    int data1 = node1.data;
    int data2 = node2.data;

    if(borrow) data1--;
    if(data1 < data2) {
      data1 = data1 + 10;
      borrow = true;
    }
    int diff = data1 - data2;
    Node node = new Node(diff, result);
    return node;
  }

  public static void main(String[] args) {
    Node x = LinkedListUtil.customBulkInsert(new int []{4,3});
    Node y = LinkedListUtil.customBulkInsert(new int []{1,2});
    new Problem022().subUtil(x, y);

    x = LinkedListUtil.customBulkInsert(new int []{1,0,0,0});
    y = LinkedListUtil.customBulkInsert(new int []{1,2});
    new Problem022().subUtil(x, y);

    x = LinkedListUtil.customBulkInsert(new int []{1,2});
    y = LinkedListUtil.customBulkInsert(new int []{1,2});
    new Problem022().subUtil(x, y);
  }

}
