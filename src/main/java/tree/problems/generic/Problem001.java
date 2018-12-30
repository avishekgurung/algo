package tree.problems.generic;

import tree.util.generic.GenericTree;
import tree.util.generic.Node;

public class Problem001 {

  public static int getSum(Node node) {
    if(node == null) return 0;
    return getSum(node.firstChild) + node.data + getSum(node.nextSiblings);
  }

  public static void main(String[] args) {
    Node root = GenericTree.getTree();
    System.out.println(getSum(root));
  }
  /**
   * Verify result as n*(n+1)/2 where n is 15.
   */

}
