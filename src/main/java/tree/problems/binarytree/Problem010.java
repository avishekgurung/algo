package tree.problems.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.util.binarytree.BinaryTree;
import tree.util.binarytree.Node;

public class Problem010 {

  public static void deleteElement(Node root, int element) {
    Node deepestNode = getDeepestNode(root);
    Node nodeToBeDeleted = getNodeToBeDeleted(root, element);
    nodeToBeDeleted.data = deepestNode.data;
    deleteDeepestNode(root, deepestNode);
  }

  public static Node getNodeToBeDeleted(Node root, int element) {
    if(root == null) return null;
    if(root.data == element) return root;
    Node left = getNodeToBeDeleted(root.left, element);
    Node right = getNodeToBeDeleted(root.right, element);
    return left != null ? left : right;
  }

  private static void deleteDeepestNode(Node root, Node deepestNode) {
    if(root == null) return;
    if(root.left == deepestNode) {
      root.left = null;
      return;
    }

    if(root.right == deepestNode) {
      root.right = null;
      return;
    }
    deleteDeepestNode(root.left, deepestNode);
    deleteDeepestNode(root.right, deepestNode);
  }

  private static Node getDeepestNode(Node root) {
    Node deepestNode = null;
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while(!queue.isEmpty()) {
      deepestNode = queue.remove();
      if(deepestNode.left != null) queue.add(deepestNode.left);
      if(deepestNode.right != null) queue.add(deepestNode.right);
    }
    return deepestNode;
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    System.out.println();
    deleteElement(root, 3);
    BinaryTree.display(root);

    root = BinaryTree.getTree();
    System.out.println();
    deleteElement(root, 7);
    BinaryTree.display(root);

    root = BinaryTree.getTree();
    System.out.println();
    deleteElement(root, 2);
    BinaryTree.display(root);

    root = BinaryTree.getTree();
    System.out.println();
    deleteElement(root, 1);
    BinaryTree.display(root);
  }
}


/**
 *Solution:
 *  Find the element to be deleted.
 *  Find the deepest node
 *  Replace the data of deepest node with the data of the node to be deleted
 *  Delete the deepest node.
 */

