package tree.binary.problems;

import java.util.HashSet;
import java.util.Set;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem059 {

  private static boolean result = false;

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

    Node node = BinaryTree.getTree();
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
    System.out.println("Contains duplicate subtree: " + result);

  }
}
