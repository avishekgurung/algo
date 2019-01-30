package tree.binary.problems;


import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

/**
 * This problem can be easily fixed by using level order traversal. For each level
 * we can increment the height and count the nodes.
 *
 * The following example is using recursion where the space complexity will be O(1).
 */
public class Problem039 {

  private static int nodeCount = 0;

  public static float getDensity(Node node) {
    int height = height(node);
    return (float) nodeCount/height;
  }

  private static int height(Node node) {
    if(node == null) return 0;
    nodeCount++;
    return Math.max(height(node.left), height(node.right)) + 1;
  }

  public static void main(String[] args) {
    Node node = BinaryTree.getTree();
    BinaryTree.display(node);
    System.out.println("\nDensity: " + getDensity(node));
  }

}
