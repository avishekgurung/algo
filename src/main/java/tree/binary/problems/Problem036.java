package tree.binary.problems;

import java.util.Stack;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem036 {

  public static void postOrder(Node node) {
    Stack<Node> stack = new Stack<Node>();

    while(true) {
      while(node != null) {
        stack.push(node);
        stack.push(node);
        node = node.left;
      }
      if(stack.isEmpty()) break;
      node = stack.pop();
      if(!stack.isEmpty() && node == stack.peek()) {
        node = node.right;
      }
      else {
        System.out.print(node.data + " ");
        node = null;
      }
    }
  }

  public static void main(String[] args) {
    Node node = BinaryTree.getTree();
    BinaryTree.display(node);
    System.out.println();
    postOrder(node);
  }

}
