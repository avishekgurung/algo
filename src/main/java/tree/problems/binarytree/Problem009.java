package tree.problems.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.util.binarytree.BinaryTree;
import tree.util.binarytree.Node;

public class Problem009 {

  public static int getDeepestNode(Node root) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    Node deepestNode = null;
    while(!queue.isEmpty()) {
      deepestNode = queue.remove();
      if(deepestNode.left != null) queue.add(deepestNode.left);
      if(deepestNode.right != null) queue.add(deepestNode.right);
    }
    return deepestNode.data;
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    System.out.println("Deepest Node: " + getDeepestNode(root));

    System.out.println();
    root = BinaryTree.createTree(new int[]{1,2,3,4});
    BinaryTree.display(root);
    System.out.println("Deepest Node: " + getDeepestNode(root));

    System.out.println();
    root = BinaryTree.createTree(new int[]{1});
    BinaryTree.display(root);
    System.out.println("Deepest Node: " + getDeepestNode(root));
  }

}
