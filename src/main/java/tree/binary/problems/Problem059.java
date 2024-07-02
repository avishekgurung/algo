package tree.binary.problems;

import java.util.HashSet;
import java.util.Set;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem059 {

  private static boolean result = false;

  /**
   * This approach will not work for the case
   *
   *
   *              1
   *        2             2
   *     4     5        4
   *                  5
   * It does not contain subtrees but it will still give positive result.
   *
   */
  public static String checkDuplicateSubTree(Node node, Set<String> set) {
    if(node == null) return "";
    String left = checkDuplicateSubTree(node.left, set);
    String right = checkDuplicateSubTree(node.right, set);
    String subtree = left + right + node.data;
    if(subtree.length() > 2) {
      if(set.contains(subtree)) result = true;
      set.add(subtree);
    }
    return subtree;
  }

  public static void main(String[] args) {

    /*Node node = BinaryTree.getTree();
    BinaryTree.display(node);
    result = false;
    Set<String> set = new HashSet<String>();
    checkDuplicateSubTree(node, set);
    System.out.println("Contains duplicate subtree: " + result);
    System.out.println(set);
    System.out.println();

    node = BinaryTree.createTree(new int[]{1,2,2,3,4,3,4});
    BinaryTree.display(node);
    result = false;
    checkDuplicateSubTree(node, new HashSet<String>());
    System.out.println("Contains duplicate subtree: " + result);

    System.out.println();
    node = BinaryTree.createTree(new int[]{1,2,3,3,5,6,7,6,7});
    BinaryTree.display(node);
    result = false;
    checkDuplicateSubTree(node, new HashSet<String>());
    System.out.println("Contains duplicate subtree: " + result);

    System.out.println();
    node = BinaryTree.createTree(new int[]{1,2,3,3,5,6,7,6,8});
    BinaryTree.display(node);
    result = false;
    checkDuplicateSubTree(node, new HashSet<String>());
    System.out.println("Contains duplicate subtree: " + result);*/

    new Problem059().driver();

  }

  /**
   * Another similar approach can be to perform a post order traversal and store the result as string.
   * Then perform post order traversal and for each subtree, check if its a substring of the above string. If
   * space is a constraint. This solution cannot work because there can be two different subtrees but have same post
   * order traversal.
   */


  /**
   * FINAL
   * This is a bit tricky question and we should solve them systematically. If two trees has an inorder and
   * (preorder / postorder) traversals the same then they are considered to be an identical trees. So we will use this
   * fundamental to solve this problem.
   *
   * Create an inorder traversal for each node and store in a set. While traversing if we come across a node that
   * has same traversal then this node qualifies for our scenario and we store them.
   *
   * We will do the same for post order traversal. For both the traversal if we get a common nodes, then those nodes
   * are the identical ones.
   *
   */


  private void driver() {
    Node root = new Node(new Node(new Node(null,4,null),2, new Node(null,5,null)), 1, new Node(null,3, new Node(new Node(null,4,null),2,new Node(null,5,null))));
    BinaryTree.display(root);

    Set<Integer> inorderEligible = new HashSet<>();
    Set<Integer> postorderEligible = new HashSet<>();

    inorder(root, new HashSet<>(), inorderEligible);
    postOrder(root, new HashSet<>(), postorderEligible);

    inorderEligible.retainAll(postorderEligible);

    if(!inorderEligible.isEmpty()) {
      System.out.println("The tree contains duplicate trees for the nodes");
      System.out.println(inorderEligible);
    }
  }

  private String inorder(Node node, Set<String> set, Set<Integer> eligible) {
    if(node == null) return "";
    String left = inorder(node.left, set, eligible);
    String right = inorder(node.left, set, eligible);
    String path = left + node.data + right;
    if(path.length() > 2) {
      if(set.contains(path)) eligible.add(node.data);
      else set.add(path);
    }
    return path;
  }

  private String postOrder(Node node, Set<String> set, Set<Integer> eligible) {
    if(node == null) return "";
    String left = postOrder(node.left, set, eligible);
    String right = postOrder(node.right, set, eligible);
    String path = left + right + node.data;
    if(path.length() > 2) {
      if(set.contains(path)) eligible.add(node.data);
      else set.add(path);
    }
    return path;
  }

}
