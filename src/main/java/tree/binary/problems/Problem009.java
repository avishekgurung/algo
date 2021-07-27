package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;

import practice.LabTest;
import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

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


  private static int maxDistance = 0;
  private static Node deepest = null;
  public static void getDeepestByRecursion(Node node, int distance) {
    if(node == null) return;
    if(distance > maxDistance) {
      maxDistance = distance;
      deepest = node;
    }
    distance++;
    getDeepestByRecursion(node.left, distance);
    getDeepestByRecursion(node.right, distance);
  }


  /**
   * Deepest Node without using any global variable
   */

  private static class DeepNodeInfo {
    Node node;
    int depth;

    public DeepNodeInfo(Node node, int depth) {
      this.node = node;
      this.depth = depth;
    }
  }

  private static DeepNodeInfo deepestNode(Node node, int level) {
    if(node == null) return null;
    level++;
    DeepNodeInfo left = deepestNode(node.left, level);
    DeepNodeInfo right = deepestNode(node.right, level);
    if(left == null && right == null) {
      return new DeepNodeInfo(node, level);
    }
    if(left == null) return right;
    if(right == null) return left;
    if(left.depth > right.depth) {
      return left;
    }
    else {
      return right;
    }
  }

  // Till here!

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    System.out.println("Deepest Node: " + getDeepestNode(root));
    maxDistance = 0;
    deepest = null;
    getDeepestByRecursion(root, 0);
    System.out.println("Deepest Node: " + deepest.data);

    System.out.println();
    root = BinaryTree.createTree(new int[]{1,2,3,4});
    BinaryTree.display(root);
    System.out.println("Deepest Node: " + getDeepestNode(root));
    maxDistance = 0;
    deepest = null;
    getDeepestByRecursion(root, 0);
    System.out.println("Deepest Node: " + deepest.data);

    System.out.println();
    root = BinaryTree.createTree(new int[]{1});
    BinaryTree.display(root);
    System.out.println("Deepest Node: " + getDeepestNode(root));
    maxDistance = -1;
    deepest = null;
    getDeepestByRecursion(root, 0);
    System.out.println("Deepest Node: " + deepest.data);
  }

}
