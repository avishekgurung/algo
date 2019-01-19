package tree.binarysearch.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem014 {

  public static void floorAndCeil(Node node) {
    int floor = getRightMostNode(node.left).data;
    int ceil = getLeftMostNode(node.right).data;
    System.out.println("Element " + node.data + ", Floor " + floor + ", Ceil " + ceil);
  }

  public static Node getRightMostNode(Node node) {
    if(node.right == null) return node;
    return getRightMostNode(node.right);
  }

  public static Node getLeftMostNode(Node node) {
    if(node.left == null) return node;
    return getLeftMostNode(node.left);
  }

  public static void main(String[] args) {
    Node root = BinarySearchTree.getTree();
    BinarySearchTree.display(root);
    System.out.println();
    floorAndCeil(root);
    floorAndCeil(root.left);
    //floorAndCeil(root.left.left);
  }

}
