package tree.problems.binarytree;

import tree.util.binarytree.BinaryTree;
import tree.util.binarytree.Node;

public class Problem012 {

  public static boolean isIdentical(Node root1, Node root2) {
    if(root1 == null && root2 == null) return true;
    if(root1 == null || root2 == null) return false; //trees of un-equal sizes
    if(root1.data != root2.data) return false;
    boolean left = isIdentical(root1.left, root2.left);
    boolean right = isIdentical(root1.right, root2.right);
    return left || right;
  }

  public static boolean isMirror(Node root1, Node root2) {
    if(root1 == null && root2 == null) return true;
    if(root1 == null || root2 == null) return false;
    if(root1.data != root2.data) return false;
    boolean left = isMirror(root1.left, root2.right);
    boolean right = isMirror(root1.right, root2.left);
    return left || right;
  }

  /**
   * Do verify them once.
   * @param x
   * @param y
   * @return
   */
  public static boolean isIsomorphic(Node x, Node y) {
    if(x == null && y == null) return true;
    if(x == null || y == null) return false;
    boolean left = isIsomorphic(x.left, y.left);
    boolean right = isIsomorphic(x.right, y.right);
    return left && right;
  }

  /**
   * Do verify them once.
   * @param x
   * @param y
   * @return
   */
  public static boolean isQuasiIsomorphic(Node x, Node y) {
    if(x == null && y == null) return true;
    if(x == null || y == null) return false;
    boolean left = isQuasiIsomorphic(x.left, y.right);
    boolean right = isQuasiIsomorphic(x.right, y.left);
    return left && right;
  }

  public static void main(String[] args) {
    Node root1 = BinaryTree.getTree();
    BinaryTree.display(root1);
    System.out.println();
    Node root2 = BinaryTree.getTree();
    BinaryTree.display(root2);
    System.out.println();
    System.out.println("Is Identical: " + isIdentical(root1, root2));
    System.out.println("Is Mirror: " + isMirror(root1, root2));

    System.out.println("------------------------------------");
    root1 = BinaryTree.getTree();
    BinaryTree.display(root1);
    System.out.println();
    root2 = BinaryTree.createTree(new int[]{1,3,2,7,6,5,4});
    BinaryTree.display(root2);
    System.out.println();
    System.out.println("Is Identical: " + isIdentical(root1, root2));
    System.out.println("Is Mirror: " + isMirror(root1, root2));
  }
}
