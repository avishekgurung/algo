package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem023 {

  public static void zigzagTraversal(Node root) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    queue.add(null);
    Stack<Node> stack = new Stack<Node>();
    boolean flag = true;

    while(!queue.isEmpty()) {
      root = queue.remove();

      if(root == null) {
        if(!flag) {
          while(!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
          }
        }
        System.out.println();
        flag = !flag;
        if(queue.isEmpty()) break;
        queue.add(null);
      }
      else {
        if(flag) {
          System.out.print(root.data + " ");
        }
        else {
          stack.push(root);
        }
        if(root.left != null) queue.add(root.left);
        if(root.right != null) queue.add(root.right);
      }
    }
  }

  public static void main(String[] args) {
    Node root = BinaryTree.createTree(new int[] {1,2,3,4,5,6,7,8,9});
    BinaryTree.display(root);
    System.out.println();
    zigzagTraversal(root);
  }

  /**
   * To solve this problem without using extra space, we can perform the level order traversal logic without extra
   * space. We can find the height of a tree. We can iterate from 1 to height and for each iteration we perform
   * recursion but with different traversal order.
   *
   * Eg for 1, we will perform normal traversal.
   * For 2, we will perform just reverse traversal, eg we will traverse right and then left subtrees.
   */

}
