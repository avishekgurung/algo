package tree.avl.problems;


/**
 *
 * Construction has to be done with pen and paper.
 *
 */
public class Problem002 {

  /**
   * Let N(h) denote a minimal number of nodes of an AVL tree at height h.
   *
   * N(0) = 1
   * N(1) = 2
   *
   * We know that to create a minimum AVL tree, the left subtree is of height h-1 and right
   * subtree is of height h-2
   *
   * N(h) = N(h-1) + N(h-2) + 1
   * N(2) = N(1) + N(0) + 1 = 2 + 1 + 1 = 4
   * N(3) = N(2) + N(1) + 1 = 4 + 2 + 1 = 7
   * N(4) = N(3) + N(2) + 1 = 7 + 4 + 1 = 12
   * N(5) = N(4) + N(3) + 1 = 12 + 7 + 1 = 20
   *
   * So the total number of nodes in a minimal AVL tree of height 6 is 20.
   *
   */

}
