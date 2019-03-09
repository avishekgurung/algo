package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem055 {

  public static boolean isCousins(Node root, Node x, Node y) {
    int xLevel = 0, yLevel = 0;
    Node xParent = null, yParent = null;
    int level = 0;

    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    queue.add(null);

    while(!queue.isEmpty()) {
      root = queue.remove();
      if(root == null) {
        if(queue.isEmpty()) break;
        queue.add(null);
        level++;
      }
      else {
        if(root.left != null) queue.add(root.left);
        if(root.right != null) queue.add(root.right);
        if(root.left == x || root.right == x) {
          xParent = root;
          xLevel = level;
        }
        if(root.left == y || root.right == y) {
          yParent = root;
          yLevel = level;
        }
      }
    }
    if(xParent == null || yParent == null) return false;
    if(xParent != yParent && xLevel == yLevel) return true;
    return false;
  }


  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);

    Node n2 = root.left;
    Node n3 = root.right;
    Node n4 = root.left.left;
    Node n6 = root.right.left;

    System.out.println();
    System.out.println("Cousin " + n2.data + " " + n3.data + " ? " + isCousins(root, n2,
        n3));
    System.out.println("Cousin " + n4.data + " " + n6.data + " ? " + isCousins(root, n4,
        n6));
    System.out.println("Cousin " + root.data + " " + n3.data + " ? " + isCousins(root,
        root, n3));

    System.out.println();
    System.out.println("Cousin " + n2.data + " " + n3.data + " ? " + recursionUtil(root,
        n2, n3));
    System.out.println("Cousin " + n4.data + " " + n6.data + " ? " + recursionUtil(root,
        n4, n6));
    System.out.println("Cousin " + root.data + " " + n3.data + " ? " + recursionUtil
        (root, root, n3));
  }


  public static boolean recursionUtil(Node root, Node x, Node y) {
    int[] xinfo = new int[2];
    int[] yinfo = new int[2];
    recursion(root, null, x, y,xinfo,yinfo,0);
    if(xinfo[0] != yinfo[0] && xinfo[1] == yinfo[1]) return true;
    return false;
  }

  public static void recursion(Node root, Node parent, Node x, Node y, int xInfo[], int
      yInfo[], int distance) {

    if(root == null) return;
    if(root == x && parent != null) {
      xInfo[0] = parent.data;
      xInfo[1] = distance;
    }
    if(root == y && parent != null) {
      yInfo[0] = parent.data;
      yInfo[1] = distance;
    }
    distance =  distance + 1;
    recursion(root.left, root, x, y, xInfo, yInfo, distance);
    recursion(root.right, root, x, y, xInfo, yInfo, distance);
  }

}
