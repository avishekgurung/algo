package tree.binary.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem056 {

  private static boolean result = false;

  public static int divideTreeIntoHalves(Node node, int count) {
    if(node == null) return 0;
    int left = divideTreeIntoHalves(node.left, count);
    int right = divideTreeIntoHalves(node.right, count);
    int sum = left + right + 1;
    if(count - sum == sum) result = true;
    return sum;
  }

  public static int getSize(Node node) {
    if(node == null) return 0;
    return getSize(node.left) + 1 + getSize(node.right);
  }

  public static void main(String[] args) {

    Node node = BinarySearchTree.getTree();
    BinarySearchTree.display(node);
    int count = getSize(node);
    divideTreeIntoHalves(node, count);
    System.out.println(result);

    System.out.println();
    result = false;
    node = BinarySearchTree.createTree(new int[]{5,4,1,7,6,8});
    BinarySearchTree.display(node);
    count = getSize(node);
    divideTreeIntoHalves(node, count);
    System.out.println(result);


    System.out.println();
    result = false;
    node = BinarySearchTree.createTree(new int[]{7,8,5,6,4,3});
    BinarySearchTree.display(node);
    count = getSize(node);
    divideTreeIntoHalves(node, count);
    System.out.println(result );
  }
}

/**
 *
 * A logic used is when we traverse a tree and for any given node, we find its size, say s.
 * Let size of the whole tree be n. At any given node, if n - s = s then a tree can be divided
 * into equal halves.
 *
 * Or we can also say n == 2s. Little different than usual.
 *
 *
 */
