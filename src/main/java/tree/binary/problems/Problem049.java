package tree.binary.problems;

public class Problem049 {

  private class Node {
    int data;
    Node left;
    Node mid;
    Node right;

    Node(int data) {
      this.data = data;
    }
  }

  private static Node prev = null;

  public Node modify(Node node) {
    if(node == null) return null;
    Node left = node.left;
    Node mid = node.mid;
    Node right = node.right;

    if(prev != null) prev.right = node;
    node.left = prev;
    node.mid = null;
    prev = node;
    modify(left);
    modify(mid);
    modify(right);
    return node;
  }

  public Node create() {
    Node n30 = new Node(30);
    Node n5 = new Node(5);
    Node n11 = new Node(11);
    Node n63 = new Node(63);
    Node n1 = new Node(1);
    Node n4 = new Node(4);
    Node n8 = new Node(8);
    Node n6 = new Node(6);

    n30.left = n5;
    n30.mid = n11;
    n30.right = n63;

    n5.left = n1;
    n5.mid = n4;
    n5.right = n8;

    n11.left = n6;
    return n30;
  }

  public static void main(String[] args) {
    Problem049 problem049 = new Problem049();
    Node root = problem049.create();
    root = problem049.modify(root);
    System.out.println(root.data);
  }
}

/**
 * This problem is really significant. It teaches us the new way to modify trees without creating
 * dependency. The most important point to note here is that, we are first storing the left, mid
 * and right node. Once these nodes are stored, we can do whatever we want with the current node.
 * And we can always use these stored child to traverse.
 *
 * Using this way we can fix many such problems.
 *
 * Another simple approach can be, traverse the tree as pre-order (like how we traversed). Store
 * the node in a queue say x. Keep one already popped element as prev. Pop the element e, make
 * suitable change and the keep e as prev. Continue this until all the elements of queue are
 * exhausted. This will however take a O(N) extra space.
 *
 */
