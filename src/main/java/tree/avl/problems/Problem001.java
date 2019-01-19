package tree.avl.problems;

import tree.avl.utils.AVLTree;
import tree.avl.utils.Node;

/**
 * Hb(0) basically means created a Balanced BST with balance factor as 0. This means the height
 * of left subtree and height of right subtree should differ by 0, hence they should be of same
 * height. So this eventually means creating a Full Binary Tree.
 *
 * So we will write two solutions, one is for generating a Full Tree for a given height. The other
 * is for creating a Full Tree which is BST.
 *
 */
public class Problem001 {

  private static int count = 1;
  public static Node createBST(int h) {
    if(h == -1) return null;
    Node node = new Node(null, 0, null);
    node.left = createBST(h-1);
    node.data = count++;
    node.right = createBST(h-1);
    return node;
  }


  public static void main(String[] args) {
    int height = 1;
    Node node = createBST(height);
    AVLTree.display(node);
  }
}
