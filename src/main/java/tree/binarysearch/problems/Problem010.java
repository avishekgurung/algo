package tree.binarysearch.problems;

import java.util.LinkedList;
import java.util.Queue;

import dll.util.DoublyLinkedList;
import dll.util.Node;

public class Problem010 {

/*  public static Node convertDllToTree(Node node) {
    Node left = node;
    Node right = node;
    while(right.next != null) right =  right.next;
    Node root = convert(left, right);
    return root;
  }*/

  public static Node convert(Node node) {
    if(node == null) return null;
    Node mid = getMid(node);
    if(mid.prev == null && mid.next == null) return mid;
    Node next = mid.next;
    Node prev = mid.prev;
    prev.next = null;
    mid.prev = null;

    mid.next = null;
    if(next != null) next.prev = null;

    mid.prev = convert(node);
    mid.next = convert(next);
    return mid;
  }

  public static Node getMid(Node node) {
    Node mid = node;
    while(node != null) {
      node = node.next;
      if(node == null) break;
      node = node.next;
      mid = mid.next;
    }
    return mid;
  }

  public static void display(Node node) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(node);
    queue.add(null);

    while(!queue.isEmpty()) {
      node = queue.remove();
      if(node == null) {
        System.out.println();
        if(queue.isEmpty()) break;
        queue.add(null);
      }
      else {
        System.out.print(node.data + "\t");
        if(node.prev != null) {
          queue.add(node.prev);
        }
        if(node.next != null) {
          queue.add(node.next);
        }
      }
    }
  }

  public static void main(String[] args) {

    Node node = DoublyLinkedList.getTree();
    DoublyLinkedList.display(node);
    Node root = convert(node);
    display(root);
  }

  /**
   * The first simple solution would be to simply create left skew tree or right skew tree as follows:
   *
   *                    1
   *                        2
   *                            3
   *                                4
   *                                    5
   *                                        6
   *                                            7
   *  Or we can also create, left skew tree as:
   *                      7
   *                     6
   *                    5
   *                   4
   *                  3
   *                 2
   *                1
   *  We can ask for this approach and then we can proceed with real example.
   *
   *  The above solution takes nLogn solution. Because finding the mid element takes n.
   *  So if we are asked to reduce the cost, then we use an array, add all the data in the array
   *  and reduce the complexity to logn.
   *
   *
   *
   */

}
