package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem012 {

  public static boolean isIdentical(Node root1, Node root2) {
    if(root1 == null && root2 == null) return true;
    if(root1 == null || root2 == null) return false; //trees of un-equal sizes
    if(root1.data != root2.data) return false;
    boolean left = isIdentical(root1.left, root2.left);
    boolean right = isIdentical(root1.right, root2.right);
    return left && right;
  }

  public static boolean isMirror(Node root1, Node root2) {
    if(root1 == null && root2 == null) return true;
    if(root1 == null || root2 == null) return false;
    if(root1.data != root2.data) return false;
    boolean left = isMirror(root1.left, root2.right);
    boolean right = isMirror(root1.right, root2.left);
    return left && right;
  }

  /**
   * Isomorphic trees are those trees where one tree can be obtained from another tree by flipping any of the nodes.
   *  i.e. by swapping left and right children of a number of nodes. Any number of nodes at any level can have their
   *  children swapped. Two empty trees are isomorphic.
   *
   *  So this means that for any node, its children can be identical or mirror of the node of another tree. Hence, we
   *  need to check mirror as well as identical properties of two trees.
   */
  public static boolean isIsomorphic(Node n,  Node m) {
    if(n == null && m ==null) return true;
    if(n == null || m ==null) return false;
    if(n.data != m.data) return false;

    return (isIsomorphic(n.left, m.left) && isIsomorphic(n.right, m.right)) ||
            (isIsomorphic(n.left, m.right) && isIsomorphic(n.right, m.left));
  }

  /**
   * Quasi Isomorphic trees are same as Isomorphic trees just that the value of the node is not taken into account.
   *
   */
  public static boolean isQuasiIsomorphic(Node n, Node m) {
    if(n == null && m == null) return true;
    if(n == null || m == null) return false;
    return (isQuasiIsomorphic(n.left, m.left) && isQuasiIsomorphic(n.right, m.right)) ||
            (isQuasiIsomorphic(n.left, m.right) || isQuasiIsomorphic(n.right, m.left));
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
