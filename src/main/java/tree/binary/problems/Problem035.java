package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem035 {

  private static Node reverseAlt(Node node) {
    Queue<Node> queue = new LinkedList<Node>();
    Queue<Node> aux = new LinkedList<Node>();
    queue.add(node);
    queue.add(null);
    boolean even = false;
    Stack<Node> stack = new Stack<Node>();

    while(!queue.isEmpty()) {
      node = queue.remove();
      if(node == null) {
       if(queue.isEmpty()) break;
       queue.add(null);
       if(even) {
         while(!stack.isEmpty()) {
           aux.add(stack.pop());
         }
       }
       even = !even;
      }
      else {
        if(even) {
          stack.push(node);
        }
        else {
          aux.add(node);
        }
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);
      }
    }

    queue = new LinkedList<Node>(aux);
    Node head = aux.remove();

    while(!aux.isEmpty()) {
      node = queue.remove();
      node.left = aux.remove();
      node.right = aux.remove();
    }
    return head;
  }

  public static void main(String[] args) {
    Node node = BinaryTree.createTree(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
    BinaryTree.display(node);
    System.out.println();
    node = reverseAlt(node);
    BinaryTree.display(node);
  }

}

/**
 * Another simple approach can be. Maintain two queues q1 and q2. Perform a level order
 * traversal and store the nodes in both the queue. (q2 should not contain root).
 *
 * flag = true
 * while q2 is not empty
 *  pop x from q2 and y from q2.
 *  pop n from q1
 *  if flag is true
 *    n.left = x
 *    n.right = y
 *  else
 *    n.left = y
 *    n.right = x
 *  flag = !flag
 */
