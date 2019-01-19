package tree.generic.problems;

public class Problem003 {
  /**
   *
   * To find a minimum height, the tree should be full, i.e. all the inner nodes must have 4 child.
   *
   *                  0
   *        0     0      0     0
   *      0000   0000   0000  0000
   *
   *      Level     Nodes   Height    Total Nodes
   *      0         1       0         1
   *      1         4       1         5
   *      2         16      2         21
   *
   *      We see that at height h, the number of nodes is 4^h.
   *
   *      At height h, the TOTAL NUMBER OF NODES = 4^(h+1)-1/3 (We have to deduce it by ourself)
   *
   *      Hence at height h, the total number of nodes is 4^(h+1)-1/3
   *
   *      n = 4^(h+1)-1/3
   *      3n = 4^(h+1)-1
   *      3n + 1 = 4^(h+1)
   *      log(3n + 1) = (h+1)log4
   *      h+1 = log(3n + 1) (base 4)
   *      h = log(3n + 1) - 1
   *      h = log(3n + 1) - log4
   *      h = log(3n + 1)/4
   *
   *
   */
}
