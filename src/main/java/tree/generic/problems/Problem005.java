package tree.generic.problems;

import tree.generic.utils.GenericTree;
import tree.generic.utils.Node;

public class Problem005 {

  public static void getSiblings(Node node) {
    node = node.nextSiblings;
    while(node != null) {
      System.out.print(node.data + " ");
      node = node.nextSiblings;
    }
    System.out.println();
  }

  public static void getChildren(Node node) {
    node = node.firstChild;
    while(node != null) {
      System.out.print(node.data + " ");
      node = node.nextSiblings;
    }
    System.out.println();
  }

  public static void main(String[] args) {

    Node node = GenericTree.getTree();
    getSiblings(node.firstChild);
    getChildren(node);

  }
}
