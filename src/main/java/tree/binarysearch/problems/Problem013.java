package tree.binarysearch.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem013 {

  public static int getKthSmallestElement(Node node, int k) {
    int left = getSize(node.left) + 1;
    if(left == k) return node.data;
    if(left > k) return getKthSmallestElement(node.left, k);
    else return getKthSmallestElement(node.right, k - left);
  }

  private static int getSize(Node node) {
    if(node == null) return 0;
    return getSize(node.left) + 1 + getSize(node.right);
  }

  public static void main(String[] args) {
    Node root = BinarySearchTree.getTree();
    BinarySearchTree.display(root);

    System.out.println();

    int k = 1;
    System.out.println(k + " smallest element: " + getKthSmallestElement(root, k));
    k = 7;
    System.out.println(k + " smallest element: " + getKthSmallestElement(root, k));
    k = 4;
    System.out.println(k + " smallest element: " + getKthSmallestElement(root, k));
    k = 5;
    System.out.println(k + " smallest element: " + getKthSmallestElement(root, k));
    k = 3;
    System.out.println(k + " smallest element: " + getKthSmallestElement(root, k));

  }
}
