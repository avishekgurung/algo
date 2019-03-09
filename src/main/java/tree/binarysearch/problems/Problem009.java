package tree.binarysearch.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem009 {

  private static Node prev = null;

  /**
   * The BT can now be used as a DLL as where left pointer is same prev and right
   * pointer is same as next in DLL.
   * @param root
   */
  public static void convertBstToDll(Node root) {
    if(root == null) return;
    convertBstToDll(root.left);
    if(prev != null) {
      prev.right = root;
      root.left = prev;
    }
    prev = root;
    convertBstToDll(root.right);
  }

  private static void displayDll(Node head) {
    while(head != null) {
      System.out.print(head.data + " --> ");
      head = head.right;
    }
    System.out.println();
  }

  private static Node getLeftMostNode(Node root) {
    while(root.left != null) root = root.left;
    return root;
  }

  public static void main(String[] args) {
    Node root = BinarySearchTree.getTree();
    Node head = getLeftMostNode(root);
    BinarySearchTree.display(root);
    convertBstToDll(root);
    displayDll(head);
  }
}
