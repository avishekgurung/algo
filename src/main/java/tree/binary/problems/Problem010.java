package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem010 {

  /**
   * We find the deepest node (which is usually a leaf)
   * We find a node to delete.
   * We swap the content of deepest node and node to delete.
   * We then delete the deepest node which is just a leaf deletion.
   */
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


  /**
   * Another little cumbersome way to delete the node.
   * This method can be helpful if we are not give a constraint to not swap the contents (which might need some bit
   * of a modification)
   */

  private static void deleteTree(Node node, int element) {
    if( node == null ) return;
    Node nodeToDelete;
    if(node.left != null && node.left.data == element) {
      nodeToDelete = node.left;
      if(nodeToDelete.left == null && nodeToDelete.right == null) {
        node.left = null;
      }
      else if(nodeToDelete.left == null || node.right == null) {
        if(nodeToDelete.left == null) {
          node.left = nodeToDelete.right;
        }
        else {
          node.left = nodeToDelete.left;
        }
      }
      else {
        int temp = nodeToDelete.data;
        nodeToDelete.data = nodeToDelete.left.data;
        nodeToDelete.left.data = temp;
      }
    }

    if(node.right != null && node.right.data == element) {
      nodeToDelete = node.right;
      if(nodeToDelete.left == null && nodeToDelete.right == null) {
        node.right = null;
      }
      else if(nodeToDelete.left == null || nodeToDelete.right == null) {
        if(nodeToDelete.left == null) {
          node.right = nodeToDelete.right;
        }
        else {
          node.right = nodeToDelete.left;
        }
      }
      else {
        int temp = nodeToDelete.data;
        nodeToDelete.data = nodeToDelete.left.data;
        nodeToDelete.left.data = temp;
      }
    }
    deleteTree(node.left, element);
    deleteTree(node.right, element);
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

