package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem042 {

  public static Node createTree(int arr[]) {
    Node head = new Node(null, arr[0], null);
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(head);

    int i=1;
    while(i < arr.length) {
      Node node = queue.remove();
      node.left = new Node(null, arr[i], null);
      queue.add(node.left);
      i++;
      if(i >= arr.length) break;
      node.right = new Node(null, arr[i], null);
      queue.add(node.right);
      i++;
    }
    return head;
  }

  /**
   * Simpler way
   * Store all the elements of an array in a node array
   * Then a[0].left = a[1], a[0].right = a[2] and so on.
   */

  public static void main(String[] args) {
    int arr[] = new int[]{1,2,3,4,5,6,7};
    Node root = createTree(arr);
    BinaryTree.display(root);
  }
}

/**
 * Another simple solution would be create two queues x and y and add all the nodes in them.
 * Continue till y is empty:
 *  pop element from x;
 *  x.left = y.pop()
 *  x.right = y.pop();
 */
