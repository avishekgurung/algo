package tree.generic.problems;

import tree.generic.utils.GenericTree;
import tree.generic.utils.Node;

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
