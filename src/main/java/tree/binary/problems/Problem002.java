package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem002 {

  public static void breadthFirstTraversal(Node root) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    queue.add(null);

    while(!queue.isEmpty()) {
      root = queue.remove();
      if(root == null) {
        System.out.println();
        if(queue.isEmpty()) break;
        queue.add(null);
      }
      else {
        System.out.print(root.data + " ");
        if(root.left != null) queue.add(root.left);
        if(root.right != null) queue.add(root.right);
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);

    System.out.println();
    breadthFirstTraversal(root);
  }

}
