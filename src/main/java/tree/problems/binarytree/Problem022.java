package tree.problems.binarytree;

import tree.util.binarytree.BinaryTree;
import tree.util.binarytree.Node;

public class Problem022 {

  /**
   * This will not work for scenarios where x is present in the tree but y is not present.
   * @param root
   * @param x
   * @param y
   * @return
   */
  public static Node getLowestCommonAncestor(Node root, int x, int y) {
    if(root == null) return null;
    if(x == root.data) return root;
    if(y == root.data) return root;
    Node left = getLowestCommonAncestor(root.left, x, y);
    Node right = getLowestCommonAncestor(root.right, x, y);
    if(left != null && right != null) return root;
    return left != null ? left : right;
  }

  public static void main(String[] args) {

    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    System.out.println();

    int x = 4;
    int y = 7;
    Node lca = getLowestCommonAncestor(root, x, y);
    System.out.println("LCA of "+ x +" and " +y+ ": " +  (lca != null ? lca.data : "NA"));


    x = 6;
    y = 7;
    lca = getLowestCommonAncestor(root, x, y);
    System.out.println("LCA of "+ x +" and " +y+ ": " +  (lca != null ? lca.data : "NA"));

    x = 6;
    y = 5;
    lca = getLowestCommonAncestor(root, x, y);
    System.out.println("LCA of "+ x +" and " +y+ ": " +  (lca != null ? lca.data : "NA"));

    x = 4;
    y = 3;
    lca = getLowestCommonAncestor(root, x, y);
    System.out.println("LCA of "+ x +" and " +y+ ": " +  (lca != null ? lca.data : "NA"));

    x = 6;
    y = 8;
    lca = getLowestCommonAncestor(root, x, y);
    System.out.println("LCA of "+ x +" and " +y+ ": " +  (lca != null ? lca.data : "NA"));

  }

}
