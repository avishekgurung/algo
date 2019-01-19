package tree.binarysearch.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem007 {

  public static Node getLowestCommonAncestor(Node root, Node x, Node y) {
    if(x.data <= root.data && root.data <= y.data) {
      return root;
    }
    if(x.data < root.data) {
      return getLowestCommonAncestor(root.left, x, y);
    }
    else {
      return getLowestCommonAncestor(root.right, x, y);
    }
  }

  public static void main(String[] args) {
    Node treeNode = BinarySearchTree.getTree();
    BinarySearchTree.display(treeNode);

    Node root = treeNode;
    Node x = root.left.right;
    Node y = root.right.right;
    System.out.println("Common Ancestor between " + x.data + " and " + y.data + " is " +
        getLowestCommonAncestor(root,x,y).data);

    root = treeNode;
    x = root.right.left;
    y = root.right.right;
    System.out.println("Common Ancestor between " + x.data + " and " + y.data + " is " +
        getLowestCommonAncestor(root,x,y).data);


    root = treeNode;
    x = root;
    y = root.right.right;
    System.out.println("Common Ancestor between " + x.data + " and " + y.data + " is " +
        getLowestCommonAncestor(root,x,y).data);
  }

}
