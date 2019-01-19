package tree.binarysearch.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem006 {

  private static Node getLowestCommonAncestor(Node root, Node x, Node y) {
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

  public static int getShortestPath(Node root, Node x, Node y) {
    Node lca = getLowestCommonAncestor(root, x, y);

    int leftPath = 0;
    Node pointer = lca;
    while(pointer != x) {
      leftPath++;
      if(pointer.data < x.data) pointer = pointer.right;
      else if(pointer.data > x.data) pointer = pointer.left;
      else break;
    }

    int rightPath = 0;
    pointer = lca;
    while(pointer != y) {
      rightPath++;
      if(pointer.data < y.data) pointer = pointer.right;
      else if(pointer.data > y.data) pointer = pointer.left;
      else break;
    }
    return leftPath + rightPath;
  }

  public static void main(String[] args) {
    Node treeNode = BinarySearchTree.getTree();
    BinarySearchTree.display(treeNode);

    Node root = treeNode;
    Node x = root.left.right;
    Node y = root.right.right;
    System.out.println("Shortest path between " + x.data + " and " + y.data + " is " +
        getShortestPath(root,x,y));

    root = treeNode;
    x = root.right.left;
    y = root.right.right;
    System.out.println("Shortest path between " + x.data + " and " + y.data + " is " +
        getShortestPath(root,x,y));


    root = treeNode;
    x = root;
    y = root.right.right;
    System.out.println("Shortest path between " + x.data + " and " + y.data + " is " +
        getShortestPath(root,x,y));
  }

}
