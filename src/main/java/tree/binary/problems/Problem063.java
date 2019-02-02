package tree.binary.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem063 {

  private static int diameter = 0;
  private static Node commonAncestor = null;

  private static int getCommonAncestor(Node node) {
    if(node == null) return 0;
    int left = getCommonAncestor(node.left);
    int right = getCommonAncestor(node.right);
    if(left + right > diameter) {
      diameter = left + right;
      commonAncestor = node;
    }
    return Math.max(left, right) + 1;
  }

  private static int maxIndex = 0;
  private static Node deepestNode = null;
  private static void deepestNode(Node node, int index) {
    if(node == null) return;
    if(index > maxIndex) {
      maxIndex = index;
      deepestNode = node;
    }
    index++;
    deepestNode(node.left, index);
    deepestNode(node.right, index);
  }

  public static Node printRootToLeafNode(Node root, Node leaf) {
    if(root == null) return null;
    if(root.data == leaf.data) {
      System.out.print(root.data + " ");
      return leaf;
    }

    Node left = printRootToLeafNode(root.left, leaf);
    Node right = printRootToLeafNode(root.right, leaf);

    if(left != null || right != null) {
      System.out.print(root.data + " ");
    }
    if(left != null) return left;
    return right;
  }


  public static void printLongestLeafToLeaf1(Node node) {
    System.out.println();
    getCommonAncestor(node);
    Node ca = commonAncestor;
    deepestNode(ca.left, 0);
    Node leftDeepestNode = deepestNode;
    deepestNode = null;
    maxIndex = 0;
    deepestNode(ca.right, 0);
    Node rightDeepestNode = deepestNode;
    printRootToLeafNode(ca.left, leftDeepestNode);
    System.out.print(ca.data + " ");
    printRootToLeafNode(ca.right, rightDeepestNode);

  }

  public static void main(String[] args) {
    Node node = BinarySearchTree.createTree(new int[]{
        30,15,8,7,6,18,19,20,9,10,11,40
    });
    BinarySearchTree.display(node);
    printLongestLeafToLeaf1(node);
  }

  /**
   * Here we follow a very straight forward approach and has several steps.
   *
   * 1. Fetch the common ancestor of the two farthest leaves.
   * We know how to find the diameter. Diameter is also the distance between the longest leaves.
   * So we calculate diameter and the node where the diameter is the highest is the
   * common ancestor.
   *
   * 2. Find the left deepest and right deepest node.
   * Now that we know the common ancestor. We will find the left deepest node and the right
   * deepest node. These are the farthest leaves.
   *
   * 3. Print the path
   * Now we print the path from common ancestor to left deepest node and right deepest node.
   *
   */
}
