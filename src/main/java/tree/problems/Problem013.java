package tree.problems;

import tree.util.BinaryTree;
import tree.util.Node;

public class Problem013 {

  private static int diameter = 0;

  /** Few things to note here.
   * Diameter is basically considered a longest path between two nodes.
   * For this tree
   *
   *       1
   *  2         3
   *                4
   * The diameter is 3, but if they say that its 4 because four nodes are involved then in the below
   * program, diamter = left + right + 1
   *
   * We store diameter as static variable
   *
   * @param root
   * @return
   */
  public static int getDiameter(Node root) {
    if(root == null) return 0;
    int left = getDiameter(root.left);
    int right = getDiameter(root.right);
    if((left + right) > diameter) diameter = left + right;
    return Math.max(left, right) + 1;
  }

  /**
   * What is they do not allow static variable then create an object that has just one variable
   * @param args
   */

  private  static class Diameter {
    int diameter;
  }
  public static int getDiameterWithoutStatic(Node root, Diameter object) {
    if(root == null) return 0;
    int left = getDiameterWithoutStatic(root.left, object);
    int right = getDiameterWithoutStatic(root.right, object);
    if((left + right) > object.diameter) {
      object.diameter = left + right;
    }
    return Math.max(left, right) + 1;
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    getDiameter(root);
    System.out.println("Diameter: "  + diameter) ;

    Diameter diameter = new Diameter();
    getDiameterWithoutStatic(root, diameter);
    System.out.println("Diameter: " + diameter.diameter);

  }

}
