package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem034 {

  public static void printBottomUp(Node node) {
    Queue<Node> queue = new LinkedList<Node>();
    Stack<Queue<Node>> stack = new Stack<Queue<Node>>();
    Queue<Node> aux = new LinkedList<Node>();
    aux.add(node.left);
    aux.add(node.right);
    aux.add(node);
    stack.push(aux);

    aux = new LinkedList<Node>();
    queue.add(node.left);
    queue.add(node.right);

    queue.add(null);

    while (!queue.isEmpty()) {

      Node x = queue.remove();

      if (x == null) {
        stack.push(aux);
        aux = new LinkedList<Node>();
        if (queue.isEmpty())
          break;
        queue.add(null);
      } else {
        Node y = queue.remove(); //We remove y only when x is not null.
        if (x.left != null) {
          queue.add(x.left);
          aux.add(x.left);
        }

        if (y.right != null) {
          queue.add(y.right);
          aux.add(y.right);
        }

        if (x.right != null) {
          queue.add(x.right);
          aux.add(x.right);
        }

        if (y.left != null) {
          queue.add(y.left);
          aux.add(y.left);
        }
      }
    }

    while(!stack.isEmpty()) {
      aux = stack.pop();
      while(!aux.isEmpty()) {
        System.out.print(aux.remove().data + " ");
      }
    }
  }

  public static void main(String[] args) {
    Node node =
        BinaryTree.createTree(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
    //Node node = BinaryTree.createTree(new int[]{1,2,3,4,5,6,7});
    BinaryTree.display(node);
    System.out.println();
    printBottomUp(node);
  }
}

/**
 * Have to think and use brains. :P
 */
