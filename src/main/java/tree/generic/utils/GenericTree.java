package tree.generic.utils;

public class GenericTree {

  public static Node getTree() {

    Node n1 = new Node(null, 1, null);
    Node n2 = new Node(null, 2, null);
    Node n3 = new Node(null, 3, null);
    Node n4 = new Node(null, 4, null);
    Node n5 = new Node(null, 5, null);
    Node n6 = new Node(null, 6, null);
    Node n7 = new Node(null, 7, null);
    Node n8 = new Node(null, 8, null);
    Node n9 = new Node(null, 9, null);
    Node n10 = new Node(null, 10, null);
    Node n11 = new Node(null, 11, null);
    Node n12 = new Node(null, 12, null);
    Node n13 = new Node(null, 13, null);
    Node n14 = new Node(null, 14, null);
    Node n15 = new Node(null, 15, null);

    n1.firstChild = n2;
    n2.nextSiblings = n3;
    n3.nextSiblings = n4;
    n4.firstChild = n7;
    n4.nextSiblings = n5;
    n5.nextSiblings = n6;

    n6.firstChild = n11;
    n11.nextSiblings = n12;

    n7.nextSiblings = n8;
    n8.nextSiblings = n9;
    n9.nextSiblings = n10;
    n9.firstChild = n15;

    n7.firstChild = n13;
    n13.nextSiblings = n14;
    return n1;
  }
}

/**
 *
 * Tree structure above
 *
 *        1
 *        |
 *        2 -> 3 -> 4 -> 5 -------------> 6
 *                  |                     |
 *                  7 -> 8 -> 9 -> 10     11 -> 12
 *                  |         |
 *                  13 -> 14  15
 *
 */
