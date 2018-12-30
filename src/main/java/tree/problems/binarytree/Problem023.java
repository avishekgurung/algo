package tree.problems.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.util.binarytree.BinaryTree;
import tree.util.binarytree.Node;

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

}
