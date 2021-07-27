package tree.binary.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem038 {

  public static void boundaryTraversal(Node node) {
    Queue<Node> queue = new LinkedList<Node>();
    Stack<Node> stack = new Stack<Node>();
    Set<Node> lookUp = new HashSet<Node>();
    queue.add(node);
    queue.add(null);
    lookUp.add(node);
    System.out.print(node.data + " ");

    while(!queue.isEmpty()) {
      node = queue.remove();
      if(node == null) {
        if(queue.isEmpty()) break;
        lookUp.add(queue.peek());
        System.out.print(queue.peek().data + " ");
        queue.add(null);
      }
      else {
        if(queue.peek() == null && !lookUp.contains(node)) {
          stack.push(node);
          lookUp.add(node);
        }
        if(node.left == null && node.right == null && !lookUp.contains(node))
          System.out.print(node.data + " ");
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);
      }
    }
    while(!stack.isEmpty()) {
      System.out.print(stack.pop().data + " ");
    }
  }

  public static void main(String[] args) {
    Node root = BinarySearchTree.createTree(new int[]{20,8,22,4,12,25,10,14});
    BinarySearchTree.display(root);
    System.out.println();
    boundaryTraversal(root);

    System.out.println("\n\n");
    root = BinarySearchTree.getTree();
    BinarySearchTree.display(root);
    System.out.println();
    boundaryTraversal(root);

  }
}

/**
 *
 * This problem can be solved easily dividing into three parts. Printing the left
 * view, leaves and then printing the right view but in reverse order.
 *
 * We can store the left view in a queue, leaves in a queue and right view in a stack.
 * But that ends up using lot of space. So optimize it better, we use a stack to
 * store a right view and just a lookup set to check if the node has already been
 * processed or not.
 *
 * Now if we fetch any node and the next node in a queue is null then that node
 * will add up to to the right view. We don't consider the root node here, thats
 * why we print the root node at the beginning.
 *
 * If the node fetched from queue is Null then the next top element of a queue
 * is a left view and print it immediately.
 *
 * If we encounter a node which is a leaf then we print it immediately. But the
 * right view check has to be before this leaf check else the printing order will
 * not be correct.
 *
 *
 * Another approach without lookup (set).
 *  1.print root node.
 *  2.Make a level order traversal and make a previous node.
 *  3. If a prev node is null then print the element(left view)
 *  4. if queue.peek == null add element in the stack.
 *  5. If leaf, print the element.
 *
 *  The above solution would have a fault where we have tree like this
 *
 *                1
 *           2           3
 *       4       5    6      7
 *             8  9
 *
 *      Here node 5 has two children, 8 and 9. So the leaves should be printed in the order 4,8,9,6,7
 *
 */
