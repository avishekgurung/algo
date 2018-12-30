package tree.problems.binarytree;


import java.util.LinkedList;
import java.util.Queue;

public class Problem027 {

  private class Node {
    int data;
    Node left;
    Node right;
    Node nextSibling;
  }

  public void arrangeNextSiblint(Node node) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(node);
    queue.add(null);

    while(!queue.isEmpty()) {
      node = queue.remove();
      if(node == null) {
        if(!queue.isEmpty()) queue.add(null);
      }
      else {
        node.nextSibling = queue.peek();
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);
      }
    }
  }
}
