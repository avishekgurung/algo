package heap.problems;

/**
 * a. Max
 *          7
 *      6       3
 *    5   4   2   1
 *
 *   Min
 *          1
 *     2        5
 *   3   4    6   7
 *
 *
 * b. In order traversal involves travelling Left, Node and Right. But in heap, the node
 * can either be highest or smallest than its children. So the equations like
 * Left Tree < Node < Right Subtree
 * Left Tree > Node > Right Subtree
 * does not hold true when we perform in-order traversal in a heap.
 *
 * c. Max
 *        7
 *    3      6
 *  1  2   4   5
 *
 *    Min
 *        1
 *    5      2
 *  7  6   4   3
 *
 *
 * d. The second property of heap says that the all the leaves will be at height h
 * or h-1, so its a complete tree.
 * The maximum element can be: 2^(h+1) - 1
 * The minimum element can be: 2^h
 *
 * e. i. Search the element in an array. Say, its found at index i.
 *    ii. Replace the element by the last element:
 *        arr[i] = arr[count-1]
 *    iii. Percolate down from i
 *        count--;
 *        percolateDown(i)
 */

public class Problem003 {
}
